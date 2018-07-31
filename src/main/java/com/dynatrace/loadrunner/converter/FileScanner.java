package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.IOException;

class FileScanner {

	private static final char EOF = (char) -1;
	private char ch, old, older;
	private String indentation = "";
	private String newIndentation = "";
	private boolean insideString = false;
	private StringBuilder instruction;
	private StringBuilder commentedInstruction;
	private BufferedReader reader;

	FileScanner(BufferedReader reader) {
		this.reader = reader;
	}

	void initialize() {
		readChar();
	}

	boolean readInstruction() {
		if (ch == EOF) {
			return false;
		}
		instruction = new StringBuilder();
		commentedInstruction = new StringBuilder();
		indentation = "";
		while (ch != EOF) {
			if (ch == ';' && !insideString) {
				break;
			}
			if (ch == '}' && !insideString) {
				break;
			} else if (ch == '"') {
				if (old != '\\') {
					insideString = !insideString;
				}
			} else if (ch == '\'') {
				if (old != '\\') {
					insideString = !insideString;
				}
			} else if (ch == '/' && !insideString) {
				readChar();
				if (ch == '*' && !insideString) {
					appendCommentBegin();
					commentedInstruction.append(readBlockComment());
					continue;
				}
				if (ch == '/' && !insideString) {
					appendCommentBegin();
					commentedInstruction.append(readToLineEnd());
					continue;
				}
				appendChar(old);
			} else if (!Character.isWhitespace(ch) && indentation.isEmpty()) {
				indentation = newIndentation;
			}

			appendChar(ch);
			readChar();
		}
		appendChar(ch);
		readChar();
		return true;
	}

	private void appendChar(char character) {
		if (!Character.isWhitespace(character)) {
			instruction.append(character);
		}
		commentedInstruction.append(character);
	}

	private void appendCommentBegin() {
		commentedInstruction.append(old);
		commentedInstruction.append(ch);
	}

	private String readBlockComment() {
		StringBuilder comment = new StringBuilder();
		boolean endFound = false;
		do {
			readChar();
			comment.append(ch);
			while (ch == '*' && !endFound) {
				readChar();
				comment.append(ch);
				if (ch == '/') {
					endFound = true;
				}
			}
		} while (ch != EOF && !endFound);
		readChar();
		return comment.toString();
	}

	private String readToLineEnd() {
		StringBuilder comment = new StringBuilder();
		do {
			readChar();
			comment.append(ch);
			if ((ch == '\n' && old != '\\') || (ch == '\n' && old == '\r' && older != '\\')) {
				break;
			}
		} while (ch != EOF);
		readChar();
		return comment.toString();
	}

	private void readChar() {
		try {
			older = old;
			old = ch;
			ch = (char) reader.read();
			if (ch == '\n') {
				newIndentation = "";
			} else if (ch == '\t' || ch == ' ') {
				newIndentation += ch;
			}
		} catch (IOException e) {
			ch = EOF;
		}
	}

	void skipWhiteSpaces() {
		while (ch != EOF && Character.isWhitespace(ch)) {
			readChar();
		}
	}

	String getIndentation() {
		return indentation;
	}

	StringBuilder getInstruction() {
		return instruction;
	}

	StringBuilder getCommentedInstruction() {
		return commentedInstruction;
	}

}
