package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.IOException;

public class FileScanner {

	private final static char EOF = (char) -1;

	private BufferedReader reader;

	private char firstChar, secondChar, thirdChar;

	private StringBuilder modifiedInstruction;
	private StringBuilder unmodifiedInstruction;
	private StringBuilder whiteSpace;
	private StringBuilder newWhiteSpace;

	private boolean insideString = false;

	public FileScanner(BufferedReader reader) {
		this.reader = reader;
	}

	public void initialize() {
		modifiedInstruction = new StringBuilder();
		unmodifiedInstruction = new StringBuilder();
		whiteSpace = new StringBuilder();
		newWhiteSpace = new StringBuilder();
		getChar();
	}

	/* TODO : rework if else */
	public boolean read() {

		if (firstChar == EOF) {
			return false;
		}

		cleanBuffer();

		while (firstChar != EOF) {
			if (firstChar == ';' && !insideString) {
				break;
			}
			if (firstChar == '}' && !insideString) {
				break;
			} else if (firstChar == '"') {
				if (secondChar != '\\') {
					insideString = !insideString;
				}
			} else if (firstChar == '\'') {
				if (secondChar != '\\') {
					insideString = !insideString;
				}
			} else if (firstChar == '/' && !insideString) {
				getChar();
				if (firstChar == '*' && !insideString) {
					unmodifiedInstruction.append(readBlockComment());
					continue;
				}
				if (firstChar == '/' && !insideString) {
					unmodifiedInstruction.append(readToLineEnd());
					continue;
				}
				append(secondChar);
			} else if (!Character.isWhitespace(firstChar) && whiteSpace.toString().isEmpty()) {
				whiteSpace.append(newWhiteSpace.toString());
			}

			append(firstChar);
			getChar();
		}
		append(firstChar);
		getChar();
		return true;
	}

	private void append(char character) {
		if (!Character.isWhitespace(character)) {
			modifiedInstruction.append(character);
		}
		unmodifiedInstruction.append(character);
	}

	/* TODO : do i need it */
	private void appendCommentBegin() {
		unmodifiedInstruction.append(secondChar);
		unmodifiedInstruction.append(firstChar);
	}

	/* TODO : inside if else or method */
	private String readBlockComment() {
		StringBuilder comment = new StringBuilder();
		boolean endFound = false;
		appendCommentBegin();
		do {
			getChar();
			comment.append(firstChar);
			while (firstChar == '*' && !endFound) {
				getChar();
				comment.append(firstChar);
				if (firstChar == '/') {
					endFound = true;
				}
			}
		} while (firstChar != EOF && !endFound);
		getChar();
		return comment.toString();
	}

	/* TODO : inside if else or method */
	private String readToLineEnd() {
		StringBuilder comment = new StringBuilder();
		appendCommentBegin();
		do {
			getChar();
			comment.append(firstChar);
			if ((firstChar == '\n' && secondChar != '\\')
					|| (firstChar == '\n' && secondChar == '\r' && thirdChar != '\\')) {
				break;
			}
		} while (firstChar != EOF);
		getChar();
		return comment.toString();
	}

	private void getChar() {
		try {
			thirdChar = secondChar;
			secondChar = firstChar;
			firstChar = (char) reader.read();
			if (firstChar == '\n') {
				newWhiteSpace.setLength(0);
			} else if (firstChar == '\t' || firstChar == ' ') {
				newWhiteSpace.append(firstChar);
			}
		} catch (IOException e) {
			firstChar = EOF;
		}
	}

	void skipWhiteSpaces() {
		while (firstChar != EOF && Character.isWhitespace(firstChar)) {
			getChar();
		}
	}

	boolean modifiedInstructionContais(String keyword) {
		return modifiedInstruction.toString().contains(keyword) ? true : false;
	}

	StringBuilder getWhiteSpace() {
		return whiteSpace;
	}

	/* TODO : method vs returning string */
	StringBuilder getModifiedInstruction() {
		return modifiedInstruction;
	}

	StringBuilder getUnmodifiedInstruction() {
		return unmodifiedInstruction;
	}

	private void cleanBuffer() {
		modifiedInstruction.setLength(0);
		unmodifiedInstruction.setLength(0);
		whiteSpace.setLength(0);
	}
}
