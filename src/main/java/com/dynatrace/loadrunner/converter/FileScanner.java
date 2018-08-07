package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.IOException;

import com.dynatrace.loadrunner.Constants;

public class FileScanner {

	private final static char EOF = (char) -1;

	private BufferedReader reader;

	private char firstChar, secondChar, thirdChar;

	private StringBuilder modifiedInstruction;
	private StringBuilder unmodifiedInstruction;
	private StringBuilder whiteSpace;
	private StringBuilder newWhiteSpace;

	private boolean outsideString = true;

	public FileScanner(BufferedReader reader) {
		this.reader = reader;
	}

	/**
	 * 
	 */
	public void initialize() {
		modifiedInstruction = new StringBuilder();
		unmodifiedInstruction = new StringBuilder();
		whiteSpace = new StringBuilder();
		newWhiteSpace = new StringBuilder();
		getChar();
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 */
	public boolean goToNextInstruction() {
		if (firstChar == EOF) {
			return false;
		}
		cleanBuffer();
		while (firstChar != EOF) {

			if (foundInstruction()) {
				break;
			}

			checkIfStringKeyword();

			checkIfComment();

			checkIfWhiteSpace();

			append(firstChar);
			getChar();
		}

		append(firstChar);
		getChar();
		return true;
	}

	private void checkIfWhiteSpace() {
		if (!Character.isWhitespace(firstChar) && whiteSpace.toString().isEmpty()) {
			whiteSpace.append(newWhiteSpace.toString());
		}
	}

	private void checkIfComment() {
		if (firstChar == Constants.SLASH && outsideString) {
			getChar();
			if (firstChar == Constants.ASTERISK && outsideString) {
				unmodifiedInstruction.append(readBlockComment());
				return;
			}
			if (firstChar == Constants.SLASH && outsideString) {
				unmodifiedInstruction.append(readToLineEnd());
				return;
			}
			append(secondChar);
		}
	}

	private void checkIfStringKeyword() {
		if ((firstChar == Constants.DOUBLE_QUOTE || firstChar == Constants.SINGLE_QUOTE)
				&& secondChar != Constants.BACKSLASH) {
			outsideString = !outsideString;
		}
	}

	private boolean foundInstruction() {
		return ((firstChar == Constants.SEMICOLON || firstChar == Constants.CURLY_RIGHT_BRACE) && outsideString) ? true
				: false;
	}

	private void append(char character) {
		if (!Character.isWhitespace(character)) {
			modifiedInstruction.append(character);
		}
		unmodifiedInstruction.append(character);
	}

	private String readBlockComment() {
		StringBuilder comment = new StringBuilder();
		boolean endFound = false;
		comment.append(secondChar);
		comment.append(firstChar);
		do {
			getChar();
			comment.append(firstChar);
			while (firstChar == Constants.ASTERISK && !endFound) {
				getChar();
				comment.append(firstChar);
				if (firstChar == Constants.SLASH) {
					endFound = true;
				}
			}
		} while (firstChar != EOF && !endFound);
		getChar();
		return comment.toString();
	}

	private String readToLineEnd() {
		StringBuilder comment = new StringBuilder();
		comment.append(secondChar);
		comment.append(firstChar);
		do {
			getChar();
			comment.append(firstChar);
			if ((firstChar == Constants.LINE_FEED && secondChar != Constants.BACKSLASH)
					|| (firstChar == Constants.LINE_FEED && secondChar == Constants.CARRIAGE_RETURN
							&& thirdChar != Constants.BACKSLASH)) {
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
			if (firstChar == Constants.LINE_FEED) {
				newWhiteSpace.setLength(0);
			} else if (firstChar == Constants.TAB || firstChar == Constants.WHITESPACE) {
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

	boolean modifiedInstructionContains(String keyword) {
		return modifiedInstruction.toString().contains(keyword) ? true : false;
	}

	StringBuilder getWhiteSpace() {
		return whiteSpace;
	}

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
