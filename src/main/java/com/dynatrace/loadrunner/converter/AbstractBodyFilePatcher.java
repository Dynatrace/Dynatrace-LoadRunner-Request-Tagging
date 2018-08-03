package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.dynatrace.loadrunner.Constants;
import com.dynatrace.loadrunner.config.Mode;
import com.dynatrace.loadrunner.converter.util.BodyFilePatcherUtil;
import com.google.common.collect.Lists;

/* TODO : rework */
abstract class AbstractBodyFilePatcher extends AbstractFilePatcher {

	private final Mode mode;
	private final String scriptName;

	protected final String header = Constants.DT_HEADER;
	String regex;
	String transactionStart;
	String transactionEnd;
	Set<String> keywords;
	Set<String> clickAndScript;
	char param;

	private final List<String> transactionNames = Lists.newArrayList();

	AbstractBodyFilePatcher(Mode mode, String scriptName) {
		this.scriptName = scriptName;
		this.mode = mode;
		initialize();
	}

	protected abstract void initialize();

	/* TODO : is this okay? */
	protected boolean patch(File sourceFile, File targetFile) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
				PrintWriter writer = new PrintWriter(targetFile)) {
			FileScanner scanner = new FileScanner(reader);
			scanner.initialize();
			parseFile(scanner, writer);
		}
		return true;
	}

	/* TODO : change method arguments to become easier to read and understand */
	private void parseFile(FileScanner scanner, PrintWriter writer) {
		while (scanner.read()) {
			handle(scanner, writer);
		}
	}

	private void handle(FileScanner scanner, PrintWriter writer) {
		String instructionToWrite = BodyFilePatcherUtil.removeEOF(scanner.getUnmodifiedInstruction().toString());
		if (scanner.modifiedInstructionContais(header)) {
			writer.write(instructionToWrite.replaceAll(regex, ""));
			scanner.skipWhiteSpaces();
		} else {
			/* TODO : handle transactions differently */
			if (scanner.modifiedInstructionContais(transactionStart)) {
				transactionNames.add(BodyFilePatcherUtil.getFirstStringParameter(instructionToWrite, param));
			} else if (scanner.modifiedInstructionContais(transactionEnd)) {
				transactionNames.remove(BodyFilePatcherUtil.getFirstStringParameter(instructionToWrite, param));
			} else {
				for (String keyword : keywords) {
					if (scanner.modifiedInstructionContais(keyword)) {
						if (mode.equals(Mode.INSERT)) {
							/* TODO : rename pageContext */
							String pageContext = BodyFilePatcherUtil
									.getFirstStringParameter(scanner.getModifiedInstruction().toString(), param);
							/* TODO : change insertMethodCall */
							instructionToWrite = insertMethodCall(instructionToWrite,
									scanner.getWhiteSpace().toString(), keyword, pageContext);
						}
						break;
					}
				}
			}
			writer.write(instructionToWrite);
		}
	}

	/* TODO : UTIL CLASS? its not writing, its building line to write */
	private String insertMethodCall(String unmodifiedInstruction, String whiteSpaces, String keyword,
			String pageContext) {

		int insertPosition = BodyFilePatcherUtil.getInsertPosition(unmodifiedInstruction, keyword);

		String start = unmodifiedInstruction.substring(0, insertPosition);
		String end = unmodifiedInstruction.substring(insertPosition);

		StringBuilder parameterBuilder = new StringBuilder();
		parameterBuilder.append("\"");
		String tsn = BodyFilePatcherUtil.concatTransactionNames(transactionNames);
		if (StringUtils.isNotBlank(tsn)) {
			parameterBuilder.append("TSN=").append(tsn).append(';');
		}

		if (!clickAndScript.contains(keyword)) {
			parameterBuilder.append("PC=").append(pageContext).append(';');
			parameterBuilder.append("SI=LoadRunner;");
			if (StringUtils.isNotBlank(scriptName)) {
				parameterBuilder.append("LSN=").append(scriptName).append(';');
			}
		}
		parameterBuilder.append("\"");

		return start + header + "(" + parameterBuilder.toString() + ");" + Constants.CRLF + whiteSpaces + end;
	}

}
