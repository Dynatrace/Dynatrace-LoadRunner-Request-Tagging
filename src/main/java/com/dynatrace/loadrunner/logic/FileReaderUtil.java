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
	
	public static String getClassResources(Class<?> cls,String name) throws IOException {
		return readFromInputStream(cls.getResourceAsStream(name));
	}
}
