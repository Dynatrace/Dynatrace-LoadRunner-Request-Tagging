package com.dynatrace.loadrunner.converter.util;

import java.util.List;

/* TODO : rename variables to make them more readable */
public class BodyFilePatcherUtil {

	private final static char EOF = (char) -1;

	public static int getInsertPosition(String unmodifiedInstruction, String keyword) {
		int insertPosition = 0;
		int keywordIndex = 0;
		char aktChar;
		for (int i = 0; i < unmodifiedInstruction.length(); i++) {
			aktChar = unmodifiedInstruction.charAt(i);
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
					aktChar = unmodifiedInstruction.charAt(++i);
					if (aktChar == '*')
						i = BodyFilePatcherUtil.getIndexAfterBlockComment(unmodifiedInstruction, i);
					else if (aktChar == '/')
						i = BodyFilePatcherUtil.getIndexAfterLineComment(unmodifiedInstruction, aktChar, i);
				} else if (aktChar == '#')
					i = BodyFilePatcherUtil.getIndexAfterLineComment(unmodifiedInstruction, aktChar, i);
			}
		}
		return insertPosition;
	}

	public static String concatTransactionNames(List<String> transactionNames) {
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

	public static int getIndexAfterLineComment(String commentedInstruction, char aktCh, int i) {
		char oldChar;
		char aktChar = aktCh;
		int index = i;
		do {
			oldChar = aktChar;
			aktChar = commentedInstruction.charAt(++index);
			if (aktChar == '\n' && oldChar != '\\')
				break;
		} while (index < commentedInstruction.length());
		return index;
	}

	public static int getIndexAfterBlockComment(String commentedInstruction, int i) {
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

	public static String getFirstStringParameter(String instruction, char stringParameter) {
		StringBuilder builder = new StringBuilder();
		int i = instruction.indexOf(stringParameter) + 1;
		if (i == 0)
			return "";
		char ch = instruction.charAt(i++), old = stringParameter;
		while (i < instruction.length()) {
			if (ch == stringParameter && old != '\\')
				break;
			builder.append(ch);
			old = ch;
			ch = instruction.charAt(i++);
		}
		return builder.toString();
	}

	public static String removeEOF(String instruction) {
		String write = instruction;
		if (instruction.length() > 0 && instruction.charAt(instruction.length() - 1) == EOF)
			write = instruction.substring(0, instruction.length() - 1);
		return write;
	}

}
