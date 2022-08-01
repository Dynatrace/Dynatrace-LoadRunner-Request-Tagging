package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.IOException;

import com.dynatrace.loadrunner.Constants;

class FileScanner {

	private final static char NULL = (char) 0;
	private final static char EOF = (char) -1;

	private final BufferedReader reader;
	private final StringBuilder modifiedInstruction;
	private final StringBuilder unmodifiedInstruction;

	private final StringBuilder unmodifiedInstructionWithoutComments;
	private final StringBuilder whiteSpace;
	private final StringBuilder newWhiteSpace;

	private char firstChar;
	private char secondChar;
	private char thirdChar;

	private char currentStringDelimiter;

	FileScanner(BufferedReader reader) {
		this.reader = reader;
		modifiedInstruction = new StringBuilder();
		unmodifiedInstruction = new StringBuilder();
		unmodifiedInstructionWithoutComments = new StringBuilder();
		whiteSpace = new StringBuilder();
		newWhiteSpace = new StringBuilder();
	}

	/**
	 * Initialize local state by reading the first character
	 */
	void initialize() {
		getChar();
	}

	boolean goToNextInstruction() {
		if (eof()) {
			return false;
		}
		cleanBuffer();
		while (!eof()) {
			if (foundInstruction()) {
				break;
			}
			skipEscapeSequence();
			processStringLiteral();
			processComment();
			processWhitespace();

			append(firstChar);
			getChar();
		}

		append(firstChar);
		getChar();
		return true;
	}

	private boolean eof() {
		return firstChar == EOF;
	}

	private void skipEscapeSequence() {
		if (firstChar == Constants.BACKSLASH) {
			append(firstChar);
			getChar();
			append(firstChar);
			getChar();
			skipEscapeSequence();
		}
	}

	private void processWhitespace() {
		if (!Character.isWhitespace(firstChar) && whiteSpace.toString().isEmpty()) {
			whiteSpace.append(newWhiteSpace.toString());
		}
	}

	private void processComment() {
		if (firstChar == Constants.SLASH && outsideString()) {
			getChar();
			switch (firstChar) {
			case Constants.ASTERISK:
				unmodifiedInstruction.append(readBlockComment());
				processComment();
				return;
			case Constants.SLASH:
				unmodifiedInstruction.append(readToLineEnd());
				processComment();
				return;
			}
			append(secondChar);
		}
	}

	private void processStringLiteral() {
		if ((firstChar == Constants.DOUBLE_QUOTE || firstChar == Constants.SINGLE_QUOTE)) {
			if(outsideString()) { // step into String value
				currentStringDelimiter = firstChar;
			} else if(currentStringDelimiter == firstChar) { // jump out of String value only when the same delimiter occurs
				currentStringDelimiter = NULL;
			}
		}
	}

	private boolean outsideString() {
		return currentStringDelimiter == NULL;
	}

	private boolean foundInstruction() {
		return (firstChar == Constants.SEMICOLON || firstChar == Constants.CURLY_RIGHT_BRACE) && outsideString();
	}

	private void append(char character) {
		if (!Character.isWhitespace(character)) {
			modifiedInstruction.append(character);
		}
		unmodifiedInstruction.append(character);
		unmodifiedInstructionWithoutComments.append(character);
	}

	private String readBlockComment() {
		StringBuilder comment = new StringBuilder();
		boolean endFound = false;
		comment.append(secondChar);
		comment.append(firstChar);
		do {
			getChar();
			comment.append(firstChar);
			while (firstChar == Constants.ASTERISK) {
				getChar();
				comment.append(firstChar);
				if (firstChar == Constants.SLASH) {
					endFound = true;
					break;
				}
			}
		} while (!eof() && !endFound);
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
			if (firstChar == Constants.LINE_FEED && (
					(secondChar == Constants.CARRIAGE_RETURN && thirdChar != Constants.BACKSLASH)
							|| secondChar != Constants.BACKSLASH)) {
				break;
			}
		} while (!eof());
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
		while (!eof() && Character.isWhitespace(firstChar)) {
			getChar();
		}
	}

	boolean modifiedInstructionContains(String keyword) {
		return modifiedInstruction.toString().contains(keyword);
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

	StringBuilder getUnmodifiedInstructionWithoutComments() { return unmodifiedInstructionWithoutComments; }

	private void cleanBuffer() {
		modifiedInstruction.setLength(0);
		unmodifiedInstruction.setLength(0);
		unmodifiedInstructionWithoutComments.setLength(0);
		whiteSpace.setLength(0);
		currentStringDelimiter = NULL;
	}
}
