package com.dynatrace.loadrunner;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.dynatrace.loadrunner.logic.FileReaderUtil;

public class FileReaderUtilTest {

	@Test
	public void testVersion() throws IOException {
		assertEquals(FileReaderUtil.getVersion(),
				readFromInputStream(this.getClass().getResourceAsStream(FileReaderUtil.VERSION)));
	}

	@Test
	public void testPrintUsages() throws IOException {
		assertEquals(FileReaderUtil.getPrintUsages(),
				readFromInputStream(this.getClass().getResourceAsStream(FileReaderUtil.PRINT_USAGES)));
	}

	@Test
	public void testCFunction() throws IOException {
		assertEquals(FileReaderUtil.getCFunction(),
				readFromInputStream(this.getClass().getResourceAsStream(FileReaderUtil.C_FUNCTION)));
	}

	@Test
	public void testJsFunction() throws IOException {
		assertEquals(FileReaderUtil.getJsFunction(),
				readFromInputStream(this.getClass().getResourceAsStream(FileReaderUtil.JS_FUNCTION)));
	}

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
}
