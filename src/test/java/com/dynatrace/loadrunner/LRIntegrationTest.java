package com.dynatrace.loadrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.dynatrace.loadrunner.logic.LRConverter;
import com.dynatrace.loadrunner.logic.ScriptFile;

@RunWith(value = Parameterized.class)
public class LRIntegrationTest {

	@Rule
	public TemporaryFolder tempFolderRule = new TemporaryFolder();

	private Wrapper input;
	private Wrapper result;
	private boolean mode;
	private boolean cEngine;
	ClassLoader cl = getClass().getClassLoader();

	public LRIntegrationTest(Wrapper input, Wrapper result, boolean mode, boolean cEngine) {
		this.input = input;
		this.result = result;
		this.mode = mode;
		this.cEngine = cEngine;
	}

	@Parameters
	public static Collection<Object[]> files() {
		return Arrays.asList(new Object[][] {
				// CONVERTING C
				{ new Wrapper(Paths.get("src","test","resources", "c-unconverted-action.c"),
						Paths.get("src","test","resources", "c-unconverted-globals.h")),
						new Wrapper(Paths.get("src","test","resources", "c-converted-action.c"),
								Paths.get("src","test","resources", "c-converted-globals.h")),
						true, true },
				// UNCONVERTING C
				{ new Wrapper(Paths.get("src","test","resources", "c-converted-action.c"),
						Paths.get("src","test","resources", "c-converted-globals.h")),
						new Wrapper(Paths.get("src","test","resources", "c-unconverted-action.c"),
								Paths.get("src","test","resources", "c-unconverted-globals.h")),
						false, true },
				// CONVERTING JS
				{ new Wrapper(Paths.get("src","test","resources", "js-unconverted-action.js"),
						Paths.get("src","test","resources", "js-unconverted-globals.js")),
						new Wrapper(Paths.get("src","test","resources", "js-converted-action.js"),
								Paths.get("src","test","resources", "js-converted-globals.js")),
						true, false },
				// UNCONVERTING JS
				{ new Wrapper(Paths.get("src","test","resources", "js-converted-action.js"),
						Paths.get("src","test","resources", "js-converted-globals.js")),
						new Wrapper(Paths.get("src","test","resources", "js-unconverted-action.js"),
								Paths.get("src","test","resources", "js-unconverted-globals.js")),
						false, false } });
	}

	@Test
	public void test() throws IOException {
		File tempHeader = tempFolderRule.newFile("globals.h");
		File tempAction = tempFolderRule.newFile("Action.c");
		Files.copy(input.getHeader(), tempHeader.toPath(), StandardCopyOption.REPLACE_EXISTING);
		Files.copy(input.getBody(), tempAction.toPath(), StandardCopyOption.REPLACE_EXISTING);

		List<ScriptFile> headerList = new LinkedList<>();
		List<ScriptFile> bodyList = new LinkedList<>();
		headerList.add(new ScriptFile(tempHeader));
		bodyList.add(new ScriptFile(tempAction));

		convertFiles(mode, headerList, bodyList, cEngine);

		assertCompareFiles(tempHeader, result.getHeader().toFile());
		assertCompareFiles(tempAction, result.getBody().toFile());
	}

	private void convertFiles(boolean mode, List<ScriptFile> header, List<ScriptFile> body, boolean cEngine) {
		LRConverter converter = new LRConverter(mode, header, body, "script name", cEngine);
		converter.convert();
	}

	private void assertCompareFiles(File modifiedFile, File comparisonFile) throws IOException {
		BufferedReader modifiedReader = new BufferedReader(new InputStreamReader(new FileInputStream(modifiedFile)));
		BufferedReader comparisonReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(comparisonFile)));
		try {
			String line;
			while ((line = modifiedReader.readLine()) != null) {
				String otherLine = comparisonReader.readLine();
				if (otherLine == null) {
					//assertFail
					Assert.assertTrue("Compared file is empty", false);
				}
				Assert.assertEquals("Lines do not match", line, otherLine);
			}
			if (comparisonReader.readLine() != null)
				Assert.assertTrue("Files do not have the same amount of lines", false);
		} finally {
			modifiedReader.close();
			comparisonReader.close();
		}
	}

}
