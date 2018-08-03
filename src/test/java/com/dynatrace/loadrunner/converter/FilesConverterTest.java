package com.dynatrace.loadrunner.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.dynatrace.loadrunner.config.InputFiles;
import com.dynatrace.loadrunner.config.Mode;
import com.dynatrace.loadrunner.config.Technology;
import com.google.common.collect.Sets;

@RunWith(value = Parameterized.class)
public class FilesConverterTest {

	@Rule
	public TemporaryFolder tempFolderRule = new TemporaryFolder();

	@SuppressWarnings("unused")
	private String testCaseLabel;
	private InputFiles input;
	private Mode mode;
	private Technology technology;
	private OutputFiles result;

	private final static String LSN = "script name";

	public FilesConverterTest(String testCaseLabel, InputFiles input, Mode mode, Technology technology,
			OutputFiles result) {
		this.testCaseLabel = testCaseLabel;
		this.input = input;
		this.mode = mode;
		this.technology = technology;
		this.result = result;
	}

	@Parameters(name = "{0} (testCase #{index})")
	public static Collection<Object[]> files() {
		return Arrays.asList(new Object[][] {
				{ "patch C files",
						new InputFiles(Sets.newHashSet(new File("src/test/resources/c-unconverted-globals.h")),
								Sets.newHashSet(new File("src/test/resources/c-unconverted-action.c"))),
						Mode.INSERT, Technology.C,
						new OutputFiles(Sets.newHashSet(new File("src/test/resources", "c-converted-globals.h")),
								Sets.newHashSet(new File("src/test/resources", "c-converted-action.c"))) },
				{ "revert C files",
						new InputFiles(Sets.newHashSet(new File("src/test/resources/c-converted-globals.h")),
								Sets.newHashSet(new File("src/test/resources/c-converted-action.c"))),
						Mode.DELETE, Technology.C,
						new OutputFiles(Sets.newHashSet(new File("src/test/resources", "c-unconverted-globals.h")),
								Sets.newHashSet(new File("src/test/resources", "c-unconverted-action.c"))) },
				{ "patch JS files",
						new InputFiles(Sets.newHashSet(new File("src/test/resources/js-unconverted-globals.js")),
								Sets.newHashSet(new File("src/test/resources/js-unconverted-action.js"))),
						Mode.INSERT, Technology.JS,
						new OutputFiles(Sets.newHashSet(new File("src/test/resources", "js-converted-globals.js")),
								Sets.newHashSet(new File("src/test/resources", "js-converted-action.js"))) },
				{ "revert JS files",
						new InputFiles(Sets.newHashSet(new File("src/test/resources/js-converted-globals.js")),
								Sets.newHashSet(new File("src/test/resources/js-converted-action.js"))),
						Mode.DELETE, Technology.JS,
						new OutputFiles(Sets.newHashSet(new File("src/test/resources", "js-unconverted-globals.js")),
								Sets.newHashSet(new File("src/test/resources", "js-unconverted-action.js"))) } });
	}

	@Test
	public void test() throws IOException {
		File tempHeader = tempFolderRule.newFile("headerFile.tmp");
		File tempAction = tempFolderRule.newFile("bodyFile.tmp");
		Files.copy(getFirstPath(input.getHeaderFiles()), tempHeader.toPath(), StandardCopyOption.REPLACE_EXISTING);
		Files.copy(getFirstPath(input.getBodyFiles()), tempAction.toPath(), StandardCopyOption.REPLACE_EXISTING);

		convertFiles(mode, technology, new InputFiles(Sets.newHashSet(tempHeader), Sets.newHashSet(tempAction)));

		assertCompareFiles(tempHeader, getFirst(result.getHeaderFiles()));
		assertCompareFiles(tempAction, getFirst(result.getBodyFiles()));
	}

	private Path getFirstPath(Collection<File> files) {
		return getFirst(files).toPath();
	}

	private File getFirst(Collection<File> files) {
		return files.iterator().next();
	}

	private void convertFiles(Mode mode, Technology technology, InputFiles inputFiles) {
		FilesConverter converter = new FilesConverter(mode, technology, inputFiles, LSN);
		converter.convert();
	}

	private void assertCompareFiles(File expectedFile, File actualFile) throws IOException {
		String messageSuffix = " (" + expectedFile.getName() + " vs " + actualFile.getName() + ")";
		try (BufferedReader expectedFileReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(expectedFile)));
				BufferedReader actualFileReader = new BufferedReader(
						new InputStreamReader(new FileInputStream(actualFile)))) {
			String expectedLine;
			while ((expectedLine = expectedFileReader.readLine()) != null) {
				String actualLine = actualFileReader.readLine();
				if (actualLine == null) {
					// assertFail
					fail("Compared file is empty" + messageSuffix);
				}
				assertEquals("Lines do not match" + messageSuffix, expectedLine, actualLine);
			}
			if (actualFileReader.readLine() != null)
				fail("Files do not have the same amount of lines" + messageSuffix);
		}
	}
}
