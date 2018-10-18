package com.dynatrace.loadrunner.converter.util;

import java.util.List;

import com.dynatrace.loadrunner.Constants;

public class BodyFilePatcherUtil {

	private final static char EOF = (char) -1;
	private final static String TRANSACTION_SEPARATOR = " - ";

	private BodyFilePatcherUtil() {
		// prevent creation
	}

	public static int getInsertPosition(String unmodifiedInstruction, String keyword) {
		int insertPosition = 0;
		int keywordIndex = 0;
		char processedChar;
		for (int i = 0; i < unmodifiedInstruction.length(); i++) {
			processedChar = unmodifiedInstruction.charAt(i);
			if (processedChar == keyword.charAt(keywordIndex)) {
				keywordIndex++;
				if (keywordIndex == keyword.length()) {
					insertPosition = i - keywordIndex + 1;
					break;
				}
			} else {
				keywordIndex = 0;
				if (processedChar == keyword.charAt(keywordIndex)) {
					keywordIndex++;
				} else if (processedChar == Constants.SLASH) {
					processedChar = unmodifiedInstruction.charAt(++i);
					if (processedChar == Constants.ASTERISK)
						i = BodyFilePatcherUtil.getIndexAfterBlockComment(unmodifiedInstruction, i);
					else if (processedChar == Constants.SLASH)
						i = BodyFilePatcherUtil.getIndexAfterLineComment(unmodifiedInstruction, processedChar, i);
				} else if (processedChar == Constants.HASH)
					i = BodyFilePatcherUtil.getIndexAfterLineComment(unmodifiedInstruction, processedChar, i);
			}
		}
		return insertPosition;
	}

	public static String concatTransactionNames(List<String> transactionNames) {
		StringBuilder builder = new StringBuilder();
		boolean firstTransaction = true;
		for (String transactionName : transactionNames) {
			if (!firstTransaction)
				builder.append(TRANSACTION_SEPARATOR);
			firstTransaction = false;
			builder.append(transactionName);
		}
		return builder.toString();
	}

	private static int getIndexAfterLineComment(String commentedInstruction, char character, int passedIndex) {
		char oldChar;
		char currentChar = character;
		int index = passedIndex;
		do {
			oldChar = currentChar;
			currentChar = commentedInstruction.charAt(++index);
			if (currentChar == Constants.LINE_FEED && oldChar != Constants.BACKSLASH)
				break;
		} while (index < commentedInstruction.length());
		return index;
	}

	private static int getIndexAfterBlockComment(String commentedInstruction, int i) {
		char currentChar;
		int index = i;
		while (index < commentedInstruction.length() - 1) {
			currentChar = commentedInstruction.charAt(++index);
			while (currentChar == Constants.ASTERISK && index < commentedInstruction.length() - 1) {
				currentChar = commentedInstruction.charAt(++index);
				if (currentChar == Constants.SLASH) {
					return index;
				}
			}
		}
		return index;
	}

	public static String getFirstStringParameter(String instruction, char stringParameter) {
		String instruction;
        
        // if this C language, remove comments
        if (stringParameter == Constants.DOUBLE_QUOTE) {
            instruction = removeComments(instructionWithComments);
        }
        else {
            instruction = instructionWithComments;
        }
		StringBuilder builder = new StringBuilder();
		int i = instruction.indexOf(stringParameter) + 1;
		if (i == 0)
			return "";
		char ch = instruction.charAt(i++), old = stringParameter;
		while (i < instruction.length()) {
			if (ch == stringParameter && old != Constants.BACKSLASH)
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
	
	public static String removeComments(String code) {
        final int outsideComment = 0;
        final int insideLineComment = 1;
        final int insideblockComment = 2;
        final int insideblockComment_noNewLineYet = 3; // we want to have at least one new line in the result if the block is not inline.

        int currentState = outsideComment;
        String endResult = "";
        Scanner s = new Scanner(code);
        s.useDelimiter("");
        while (s.hasNext()) {
            String c = s.next();
            switch (currentState) {
                case outsideComment:
                    if (c.equals("/") && s.hasNext()) {
                        String c2 = s.next();
                        if (c2.equals("/")) {
                            currentState = insideLineComment;
                        } else if (c2.equals("*")) {
                            currentState = insideblockComment_noNewLineYet;
                        } else {
                            endResult += c + c2;
                        }
                    } else {
                        endResult += c;
                    }
                    break;
                case insideLineComment:
                    if (c.equals("\n")) {
                        currentState = outsideComment;
                        endResult += "\n";
                    }
                    break;
                case insideblockComment_noNewLineYet:
                    if (c.equals("\n")) {
                        endResult += "\n";
                        currentState = insideblockComment;
                    }
                case insideblockComment:
                    while (c.equals("*") && s.hasNext()) {
                        String c2 = s.next();
                        if (c2.equals("/")) {
                            currentState = outsideComment;
                            break;
                        }

                    }

            }
        }
        s.close();
        return endResult;
    }

}
