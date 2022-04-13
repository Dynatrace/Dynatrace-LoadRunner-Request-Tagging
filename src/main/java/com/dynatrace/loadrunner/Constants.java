package com.dynatrace.loadrunner;

import java.util.ArrayList;
import java.util.List;

public final class Constants {

	public static final String DT_HEADER = "addDynatraceHeaderTest";

	public static final String INCLUDE_KEYWORD = "#include";
	public static final String TMP_FILE_EXT = ".tmp";
	public static final String CRLF = "\r\n";

	public static final String UNABLE_TO_RESTORE_FILE = "Unable to restore the backup file ";

	public static final char BACKSLASH = '\\';
	public static final char SINGLE_QUOTE = '\'';
	public static final char DOUBLE_QUOTE = '"';
	public static final char ASTERISK = '*';
	public static final char SLASH = '/';
	public static final char SEMICOLON = ';';
	public static final char CURLY_RIGHT_BRACE = '}';
	public static final char LINE_FEED = '\n';
	public static final char CARRIAGE_RETURN = '\r';
	public static final char WHITESPACE = ' ';
	public static final char TAB = '\t';
	public static final char HASH = '#';

	public static final List<Character> ESCAPE_SEQUENCES = new ArrayList();

	static {
		ESCAPE_SEQUENCES.add(BACKSLASH);
		ESCAPE_SEQUENCES.add(DOUBLE_QUOTE);
		ESCAPE_SEQUENCES.add(SINGLE_QUOTE);
		ESCAPE_SEQUENCES.add('t');
		ESCAPE_SEQUENCES.add('b');
		ESCAPE_SEQUENCES.add('n');
		ESCAPE_SEQUENCES.add('r');
		ESCAPE_SEQUENCES.add('f');
	}

	private Constants() {
		// prevent creation
	}
}
