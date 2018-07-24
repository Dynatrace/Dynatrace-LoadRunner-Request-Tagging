package com.dynatrace.loadrunner.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

public class FilePatcher {

	private final static char EOF = (char) -1;

	private String regex, transaction_start, transaction_end, header;
	private String[] keywords, click_and_script;
	private char param;

	private File sourceFile;
	private File targetFile;
	private BufferedWriter writer;
	private FileScanner scanner;

	private List<String> transactionNames;
	private boolean insert;
	private boolean cEngine;
	private String LSN;

	public FilePatcher(File sourceFile, File targetFile, ScriptFile scriptFile) {
		writer = null;
		transactionNames = new LinkedList<String>();
		this.targetFile = targetFile;
		this.sourceFile = sourceFile;
	}

	public void configure(String LSN, boolean cEngine, boolean insert) throws IOException {
		this.LSN = LSN;
		this.cEngine = cEngine;
		this.insert = insert;
		setupConstants();
		generateFile();
	}

	private void setupConstants() {
		header = Constants.ADD_HEADER;
		if (cEngine) {
			regex = header + Constants.C_REGEX;
			transaction_start = Constants.C_TRANS_START;
			transaction_end = Constants.C_TRANS_END;
			param = Constants.C_PARAM;
			keywords = Constants.C_KEYWORDS;
			click_and_script = Constants.CLICK_AND_SCRIPT_KEYWORDS;
		} else {
			regex = header + Constants.JS_REGEX;
			transaction_start = Constants.JS_TRANS_START;
			transaction_end = Constants.JS_TRANS_END;
			param = Constants.JS_PARAM;
			keywords = Constants.JS_KEYWORDS;
			click_and_script = Constants.JS_CLICK_AND_SCRIPT_KEYWORDS;
		}
	}

	public void generateFile() throws IOException {
		try {
			writer = new BufferedWriter(new FileWriter(targetFile));
			scanner = new FileScanner(sourceFile);
			scanner.initalize();
			parseFile();
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
			if (scanner != null)
				scanner.close();
		}
	}

	private void parseFile() throws IOException {
		while (scanner.readInstruction())
			handleInstruction(scanner.getInstruction().toString(), scanner.getCommentedInstruction().toString());
	}

	private void handleInstruction(String instruction, String commentedInstruction) throws IOException {
		String write = commentedInstruction;
		if (write == null)
			write = instruction;
		write = removeEOF(commentedInstruction);
		if (!instruction.contains(header)) {
			if (instruction.contains(transaction_start))
				transactionNames.add(getFirstStringParameter(write));
			else if (instruction.contains(transaction_end))
				transactionNames.remove(getFirstStringParameter(write));
			else {
				for (String keyword : keywords) {
					if (instruction.contains(keyword)) {
						if (insert) {
							String pageContext = getFirstStringParameter(instruction);
							write = insertMethodCall(keyword, write, pageContext);
						}
						break;
					}
				}
			}
			writer.write(write);
		}
		else {
			writer.write(write.replaceAll(regex, ""));
			scanner.readWhiteSpaces();
		}
	}

	private String insertMethodCall(String keyword, String commentedInstruction, String pageContext)
			throws UnsupportedEncodingException {
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
			}
			else {
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
		if (!tsn.isEmpty()) {
			parameterBuilder.append("TSN=" + tsn + ";");
		}
		if (!isClickAndScriptKeyword(keyword)) {
			parameterBuilder.append("PC=" + pageContext + ";");
			parameterBuilder.append("SI=LoadRunner;");
			if (!LSN.isEmpty()) {
				parameterBuilder.append("LSN=" + LSN + ";");
			}
		}
		parameterBuilder.append("\"");
		String instruction = start + header + "(" + parameterBuilder.toString() + ");" + Constants.CRLF_OS_INDEPENDENT
				+ scanner.getIndention() + end;

		return instruction;
	}

	private boolean isClickAndScriptKeyword(String keyword) {
		for (String word : click_and_script) {
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
