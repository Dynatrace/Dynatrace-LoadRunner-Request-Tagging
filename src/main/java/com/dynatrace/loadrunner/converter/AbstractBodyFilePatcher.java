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

abstract class AbstractBodyFilePatcher extends AbstractFilePatcher {

	private final String scriptName;

	static final String HEADER = Constants.DT_HEADER;
	String regex;
	String transactionStart;
	String transactionEnd;
	Set<String> keywords;
	Set<String> clickAndScript;
	char param;

	private final List<String> transactionNames = Lists.newArrayList();

	AbstractBodyFilePatcher(Mode mode, String scriptName, boolean verbose) {
		super(mode, verbose);
		this.scriptName = scriptName;
		initialize();
	}

	protected abstract void initialize();

	protected boolean patch(File sourceFile, File targetFile) throws IOException {
		try (
				BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
				PrintWriter writer = new PrintWriter(targetFile)
		) {
			if(verbose) {
				System.out.printf("Patching file: %s%n", sourceFile.getAbsolutePath());
			}
			FileScanner scanner = new FileScanner(reader);
			scanner.initialize();
			parseFile(scanner, writer);
		}
		return true;
	}

	private void parseFile(FileScanner scanner, PrintWriter writer) {
		if(verbose) {
			System.out.println("parsing...");
		}
		switch (mode) {
		case INSERT:
			while (scanner.goToNextInstruction()) {
				handleInsert(scanner, writer);
			}
			break;
		case DELETE:
			while (scanner.goToNextInstruction()) {
				handleDelete(scanner, writer);
			}
			break;
		default:
			throw new UnsupportedOperationException("Unknown patch mode: " + mode);
		}
		if(verbose) {
			System.out.println("... parsing done");
		}
	}

	private void handleInsert(FileScanner scanner, PrintWriter writer) {
		String instructionToWrite = BodyFilePatcherUtil.removeEOF(scanner.getUnmodifiedInstruction().toString());
		if (scanner.modifiedInstructionContains(transactionStart)) {
			transactionNames.add(BodyFilePatcherUtil.getFirstStringParameter(instructionToWrite, param));
		} else if (scanner.modifiedInstructionContains(transactionEnd)) {
			transactionNames.remove(BodyFilePatcherUtil.getFirstStringParameter(instructionToWrite, param));
		} else {
			String keyword = processKeywords(scanner.getModifiedInstruction().toString());
			if (StringUtils.isNotBlank(keyword)) {
				String processedPage = BodyFilePatcherUtil
						.getFirstStringParameter(scanner.getModifiedInstruction().toString(), param);
				instructionToWrite = modifyInstruction(instructionToWrite, scanner.getWhiteSpace().toString(), keyword,
						processedPage);
			}
		}
		writer.write(instructionToWrite);
	}

	private void handleDelete(FileScanner scanner, PrintWriter writer) {
		String instructionToWrite = BodyFilePatcherUtil.removeEOF(scanner.getUnmodifiedInstruction().toString());
		if (scanner.modifiedInstructionContains(HEADER)) {
			writer.write(instructionToWrite.replaceAll(regex, ""));
			scanner.skipWhiteSpaces();
		} else {
			writer.write(instructionToWrite);
		}
	}

	private String processKeywords(String modifiedInstruction) {
		for (String keyword : keywords) {
			if (modifiedInstruction.contains(keyword)) {
				return keyword;
			}
		}
		return null;
	}

	private String modifyInstruction(String unmodifiedInstruction, String whiteSpaces, String keyword,
			String processedPage) {
		int insertPosition = BodyFilePatcherUtil.getInsertPosition(unmodifiedInstruction, keyword);
		return unmodifiedInstruction.substring(0, insertPosition)
				+ HEADER
				+ '(' + buildParameters(keyword, processedPage) + ");"
				+ Constants.CRLF
				+ whiteSpaces
				+ unmodifiedInstruction.substring(insertPosition);
	}

	private String buildParameters(String keyword, String processedPage) {
		StringBuilder parameterBuilder = new StringBuilder();
		parameterBuilder.append("\"");
		String tsn = BodyFilePatcherUtil.concatTransactionNames(transactionNames);
		if (StringUtils.isNotBlank(tsn)) {
			parameterBuilder.append("TSN=").append(tsn).append(';');
		}
		if (!clickAndScript.contains(keyword)) {
			parameterBuilder.append("PC=").append(processedPage).append(';');
			parameterBuilder.append("SI=LoadRunner;");
			if (StringUtils.isNotBlank(scriptName)) {
				parameterBuilder.append("LSN=").append(scriptName).append(';');
			}
		}
		parameterBuilder.append("\"");
		return parameterBuilder.toString();
	}

}
