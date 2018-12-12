package com.dynatrace.loadrunner.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

public class FileScannerTest {

	@Test
	public void instructionCountTest() {
		int expectedInstructionCount = 6;
		File file = new File("src/test/resources/file-scanner-test.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			fail("FileScanner test file not found");
		}
		FileScanner scanner = new FileScanner(reader);
		scanner.initialize();
		int instructionCount = 0;
		while (scanner.goToNextInstruction()) {
			instructionCount++;
		}
		assertEquals(expectedInstructionCount, instructionCount);
	}

	@Test
	public void skipBlockCommentTest() {
		String expectedModifiedString = "Testingreadingaline;";
		String skipCommentString = "Testing/*this should be skipped*/ reading a line;";
		Reader inputString = new StringReader(skipCommentString);
		BufferedReader reader = new BufferedReader(inputString);
		FileScanner scanner = new FileScanner(reader);
		scanner.initialize();
		scanner.goToNextInstruction();
		assertEquals(expectedModifiedString, scanner.getModifiedInstruction().toString());
		assertEquals(skipCommentString, scanner.getUnmodifiedInstruction().toString());
	}

	@Test
	public void skipBlockCommentWithLineCommentInsideTest() {
		String expectedModifiedString = "Testingreadingaline;";
		String skipCommentString = "Testing/*\n* this\n* should\n* be\n* skipped\n//including line comment nested*/ reading a line;";
		Reader inputString = new StringReader(skipCommentString);
		BufferedReader reader = new BufferedReader(inputString);
		FileScanner scanner = new FileScanner(reader);
		scanner.initialize();
		scanner.goToNextInstruction();
		assertEquals(expectedModifiedString, scanner.getModifiedInstruction().toString());
		assertEquals(skipCommentString, scanner.getUnmodifiedInstruction().toString());
	}

	@Test
	public void skipLineCommentTest() {
		String expectedModifiedString = "ThiswilltestNewline;";
		String lineCommentString = "This will test //line comment\nNew line;";
		Reader inputString = new StringReader(lineCommentString);
		BufferedReader reader = new BufferedReader(inputString);
		FileScanner scanner = new FileScanner(reader);
		scanner.initialize();
		scanner.goToNextInstruction();
		assertEquals(expectedModifiedString, scanner.getModifiedInstruction().toString());
		assertEquals(lineCommentString, scanner.getUnmodifiedInstruction().toString());
	}

	@Test
	public void commentInsideStringTest() {
		String expectedModifiedString = "Thiswilltest\"/*commentinsidestring*/\";";
		String testString = "This will test \"/* comment inside string */\";";
		Reader inputString = new StringReader(testString);
		BufferedReader reader = new BufferedReader(inputString);
		FileScanner scanner = new FileScanner(reader);
		scanner.initialize();
		scanner.goToNextInstruction();
		assertEquals(expectedModifiedString, scanner.getModifiedInstruction().toString());
		assertEquals(testString, scanner.getUnmodifiedInstruction().toString());
	}
}
