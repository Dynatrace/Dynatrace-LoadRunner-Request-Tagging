package com.dynatrace.loadrunner.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReaderUtil {

	public final static String C_FUNCTION = "/dynatraceFunction_C.txt";
	public final static String JS_FUNCTION = "/dynatraceFunction_JS.txt";
	public final static String PRINT_USAGES = "/printUsages.txt";
	public final static String VERSION = "/version.txt";

	public final static Class<FileReaderUtil> CLASS = FileReaderUtil.class;

	private static String readFromInputStream(final InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

	public static String getPrintUsages() throws IOException {
		return readFromInputStream(CLASS.getResourceAsStream(PRINT_USAGES));
	}

	public static String getVersion() throws IOException {
		return readFromInputStream(CLASS.getResourceAsStream(VERSION));
	}

	public static String getCFunction() throws IOException {
		return readFromInputStream(CLASS.getResourceAsStream(C_FUNCTION));
	}

	public static String getJsFunction() throws IOException {
		return readFromInputStream(CLASS.getResourceAsStream(JS_FUNCTION));
	}

}
