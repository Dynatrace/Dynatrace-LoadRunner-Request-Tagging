package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.dynatrace.loadrunner.Constants;
import com.dynatrace.loadrunner.config.Mode;
import com.google.common.collect.Lists;

abstract class AbstractBodyFilePatcher extends AbstractFilePatcher {

	private final static char EOF = (char) -1;

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

	protected boolean patch(File sourceFile, File targetFile) throws IOException {
		switch (mode) {
		case DELETE:
			return addBody(sourceFile, targetFile);
		case INSERT:
			return addBody(sourceFile, targetFile);
		}
		return false;
	}

	private boolean addBody(File sourceFile, File targetFile) throws IOException {
		try (
				BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
				PrintWriter writer = new PrintWriter(targetFile)
		) {
			FileScanner scanner = new FileScanner(reader);
			scanner.initalize();
			parseFile(scanner, writer);
		}
		return true;
	}

	private boolean removeBody(File sourceFile, File targetFile) {
		return false;
	}

	private void parseFile(FileScanner scanner, PrintWriter writer) throws IOException {
		while (scanner.readInstruction())
			handleInstruction(scanner, writer, scanner.getInstruction().toString(),
					scanner.getCommentedInstruction().toString());
	}

	private void handleInstruction(FileScanner scanner, PrintWriter writer, String instruction,
			String commentedInstruction) throws IOException {
		String write = commentedInstruction;
		if (write == null)
			write = instruction;
		write = removeEOF(commentedInstruction);
		if (!instruction.contains(header)) {
			if (instruction.contains(transactionStart))
				transactionNames.add(getFirstStringParameter(write));
			else if (instruction.contains(transactionEnd))
				transactionNames.remove(getFirstStringParameter(write));
			else {
				for (String keyword : keywords) {
					if (instruction.contains(keyword)) {
						if (mode.equals(Mode.INSERT)) {
							String pageContext = getFirstStringParameter(instruction);
							write = insertMethodCall(scanner, keyword, write, pageContext);
						}
						break;
					}
				}
			}
			writer.write(write);
		} else {
			writer.write(write.replaceAll(regex, ""));
			scanner.readWhiteSpaces();
		}
	}

	private String insertMethodCall(FileScanner scanner, String keyword, String commentedInstruction,
			String pageContext) throws UnsupportedEncodingException {
		int insertPosition = 0;
		int keywordIndex = 0;
		char aktChar;
		for (int i = 0; i < commentedInstruction.length(); i++) {
			aktChar = commentedInstruction.charAt(i);
			if (aktChar == keyword.charAt(keywordIndex)) {
				keywordIndex++;
				if (keywordIndex == keyword.length()) {
					insertPosition = i - keywordIndex + 1;
					break;
				}
			} else {
				keywordIndex = 0;
				if (aktChar == keyword.charAt(keywordIndex)) {
					keywordIndex++;
				} else if (aktChar == '/') {
					aktChar = commentedInstruction.charAt(++i);
					if (aktChar == '*')
						i = skipBlockComment(commentedInstruction, i);
					else if (aktChar == '/')
						i = skipLine(commentedInstruction, aktChar, i);
				} else if (aktChar == '#')
					i = skipLine(commentedInstruction, aktChar, i);
			}
		}

		String start = commentedInstruction.substring(0, insertPosition);
		String end = commentedInstruction.substring(insertPosition);

		StringBuilder parameterBuilder = new StringBuilder();
		parameterBuilder.append("\"");
		String tsn = createTimerName();
		if (StringUtils.isNotBlank(tsn)) {
			parameterBuilder.append("TSN=" + tsn + ";");
		}
		if (!isClickAndScriptKeyword(keyword)) {
			parameterBuilder.append("PC=" + pageContext + ";");
			parameterBuilder.append("SI=LoadRunner;");
			if (StringUtils.isNotBlank(scriptName)) {
				parameterBuilder.append("LSN=" + scriptName + ";");
			}
		}
		parameterBuilder.append("\"");
		String instruction = start + header + "(" + parameterBuilder.toString() + ");" + Constants.CRLF
				+ scanner.getIndentation() + end;

		return instruction;
	}

	private boolean isClickAndScriptKeyword(String keyword) {
		for (String word : clickAndScript) {
			if (word.equals(keyword))
				return true;
		}
		return false;
	}

	private String createTimerName() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String transactionName : transactionNames) {
			if (!first)
				builder.append(" - ");
			first = false;
			builder.append(transactionName);
		}
		return builder.toString();
	}

	private int skipLine(String commentedInstruction, char aktCh, int i) {
		char oldChar = '/', olderChar, aktChar = aktCh;
		int index = i;
		do {
			olderChar = oldChar;
			oldChar = aktChar;
			aktChar = commentedInstruction.charAt(++index);
			if ((aktChar == '\n' && oldChar != '\\') || (aktChar == '\n' && oldChar == '\r' && olderChar != '\\'))
				break;
		} while (index < commentedInstruction.length());
		return index;
	}

	private int skipBlockComment(String commentedInstruction, int i) {
		char aktChar;
		int index = i;

		while (index < commentedInstruction.length() - 1) {
			aktChar = commentedInstruction.charAt(++index);
			while (aktChar == '*' && index < commentedInstruction.length() - 1) {
				aktChar = commentedInstruction.charAt(++index);
				if (aktChar == '/') {
					return index;
				}
			}
		}
		return index;
	}

	private String getFirstStringParameter(String instruction) {
		StringBuilder builder = new StringBuilder();
		int i = instruction.indexOf(param) + 1;
		if (i == 0)
			return "";
		char ch = instruction.charAt(i++), old = param;
		while (i < instruction.length()) {
			if (ch == param && old != '\\')
				break;
			builder.append(ch);
			old = ch;
			ch = instruction.charAt(i++);
		}
		return builder.toString();
	}

	private String removeEOF(String instruction) {
		String write = instruction;
		if (instruction.length() > 0 && instruction.charAt(instruction.length() - 1) == EOF)
			write = instruction.substring(0, instruction.length() - 1);
		return write;
	}

}
