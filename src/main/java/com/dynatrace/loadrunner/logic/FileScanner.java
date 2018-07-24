package com.dynatrace.loadrunner.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileScanner {

	private static final char EOF = (char) -1;
	private char ch, old, older;
	private String indention = "";
	private String newIndention = "";
	private boolean insideString = false;
	private StringBuilder instruction;
	private StringBuilder commentedInstruction;
	private BufferedReader reader;

	public FileScanner(File input) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(input));
	}

	public void initalize() {
		readChar();
	}

	public boolean readInstruction() throws IOException {
		if (ch == EOF) {
			return false;
		}
		instruction = new StringBuilder();
		commentedInstruction = new StringBuilder();
		indention = "";
		/*
		 * switch case which seemed preffered way becomes unreadable due to need of if's
		 * to check whether insideString So in the end it will be both switch and if
		 * instead of if's
		 */
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
			} else if (!Character.isWhitespace(ch) && indention.isEmpty()) {
				indention = newIndention;
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

	private String readBlockComment() throws IOException {
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

	private String readToLineEnd() throws IOException {
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
				newIndention = "";
			} else if (ch == '\t' || ch == ' ') {
				newIndention += ch;
			}
		} catch (IOException e) {
			ch = EOF;
		}
	}

	public String readWhiteSpaces() throws IOException {
		StringBuilder whitespaces = new StringBuilder();
		while (ch != EOF && Character.isWhitespace(ch)) {
			readChar();
			whitespaces.append(ch);
		}
		if (whitespaces.length() > 0)
			return whitespaces.substring(0, whitespaces.length() - 1);
		return "";
	}

	public void close() {
		try {
			reader.close();
		} catch (Exception e) {
		}
	}

	public String getIndention() {
		return indention;
	}

	public StringBuilder getInstruction() {
		return instruction;
	}

	public StringBuilder getCommentedInstruction() {
		return commentedInstruction;
	}

}
