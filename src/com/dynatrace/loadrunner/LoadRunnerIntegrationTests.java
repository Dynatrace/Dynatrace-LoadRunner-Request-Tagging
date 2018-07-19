package com.dynatrace.loadrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.dynatrace.loadrunner.logic.LoadRunnerConverter;
import com.dynatrace.loadrunner.logic.ScriptFile;

public class LoadRunnerIntegrationTests {

	@Rule
	public TemporaryFolder tempFolderRule = new TemporaryFolder();

	private Path cHeaderFilePath;
	private Path jsHeaderFilePath;
	private Path cHeaderFileOriginalPath;
	private Path jsHeaderFileOriginalPath;
	private Path cActionFilePath;
	private Path jsActionFilePath;
	private Path cActionFileOriginalPath;
	private Path jsActionFileOriginalPath;


	@Before
	public void setup() {

		cHeaderFilePath = Paths.get("testresources", "c-converted-globals.h");
		jsHeaderFilePath = Paths.get("testresources", "js-converted-globals.js");
		cHeaderFileOriginalPath = Paths.get("testresources", "c-unconverted-globals.h");
		jsHeaderFileOriginalPath = Paths.get("testresources", "js-unconverted-globals.js");
		cActionFilePath = Paths.get("testresources", "c-converted-action.c");
		jsActionFilePath = Paths.get("testresources", "js-converted-action.js");
		cActionFileOriginalPath = Paths.get("testresources", "c-unconverted-action.c");
		jsActionFileOriginalPath = Paths.get("testresources", "js-unconverted-action.js");
		
	}

	@Test
	public void cScriptConverting() throws IOException {
		File tempHeader = tempFolderRule.newFile("globals.h");
		File tempAction = tempFolderRule.newFile("Action.c");
		Files.copy(cHeaderFileOriginalPath, tempHeader.toPath(),StandardCopyOption.REPLACE_EXISTING);
		Files.copy(cActionFileOriginalPath, tempAction.toPath(),StandardCopyOption.REPLACE_EXISTING);
		
		List<ScriptFile> headerList = new LinkedList<>();
		List<ScriptFile> bodyList = new LinkedList<>();
		headerList.add(new ScriptFile(tempHeader));
		bodyList.add(new ScriptFile(tempAction));
		
		convertFiles(true,headerList,bodyList,true);
		
		assertCompareFiles(tempHeader,cHeaderFilePath.toFile());
		assertCompareFiles(tempAction,cActionFilePath.toFile());
	}

	@Test
	public void cScriptUnconverting() throws IOException {
		File tempHeader = tempFolderRule.newFile("globals.h");
		File tempAction = tempFolderRule.newFile("Action.c");
		Files.copy(cHeaderFilePath, tempHeader.toPath(),StandardCopyOption.REPLACE_EXISTING);
		Files.copy(cActionFilePath, tempAction.toPath(),StandardCopyOption.REPLACE_EXISTING);
		
		List<ScriptFile> headerList = new LinkedList<>();
		List<ScriptFile> bodyList = new LinkedList<>();
		headerList.add(new ScriptFile(tempHeader));
		bodyList.add(new ScriptFile(tempAction));
		
		convertFiles(false,headerList,bodyList,true);
		
		assertCompareFiles(tempHeader,cHeaderFileOriginalPath.toFile());
		assertCompareFiles(tempAction,cActionFileOriginalPath.toFile());
	}

	@Test
	public void jsScriptConverting() throws IOException {
		File tempHeader = tempFolderRule.newFile("globals.js");
		File tempAction = tempFolderRule.newFile("Action.js");
		Files.copy(jsHeaderFileOriginalPath, tempHeader.toPath(),StandardCopyOption.REPLACE_EXISTING);
		Files.copy(jsActionFileOriginalPath, tempAction.toPath(),StandardCopyOption.REPLACE_EXISTING);
		
		List<ScriptFile> headerList = new LinkedList<>();
		List<ScriptFile> bodyList = new LinkedList<>();
		headerList.add(new ScriptFile(tempHeader));
		bodyList.add(new ScriptFile(tempAction));
		
		convertFiles(true,headerList,bodyList,false);
		
		assertCompareFiles(tempHeader,jsHeaderFilePath.toFile());
		assertCompareFiles(tempAction,jsActionFilePath.toFile());
	}

	@Test
	public void jsScriptUnconverting() throws IOException {
		File tempHeader = tempFolderRule.newFile("globals.js");
		File tempAction = tempFolderRule.newFile("Action.js");
		Files.copy(jsHeaderFilePath, tempHeader.toPath(),StandardCopyOption.REPLACE_EXISTING);
		Files.copy(jsActionFilePath, tempAction.toPath(),StandardCopyOption.REPLACE_EXISTING);
		
		List<ScriptFile> headerList = new LinkedList<>();
		List<ScriptFile> bodyList = new LinkedList<>();
		headerList.add(new ScriptFile(tempHeader));
		bodyList.add(new ScriptFile(tempAction));
		
		convertFiles(false,headerList,bodyList,false);
		assertCompareFiles(tempHeader,jsHeaderFileOriginalPath.toFile());
		assertCompareFiles(tempAction,jsActionFileOriginalPath.toFile());
	}
	
	private void convertFiles(boolean mode,List<ScriptFile> header, List<ScriptFile> body, boolean cEngine) {
		LoadRunnerConverter converter = new LoadRunnerConverter();
		converter.configureConverter(mode, header, body,"script name", cEngine);
		converter.convertFiles();
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
					Assert.assertTrue("Files do not have the same amount of lines", false);
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
