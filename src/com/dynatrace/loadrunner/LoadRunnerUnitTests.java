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

public class LoadRunnerUnitTests {
	
	@Rule
	public TemporaryFolder tempFolderRule = new TemporaryFolder();
	
	private Path cHeaderFilePath;
	private Path cHeaderFileOriginalPath;
	private Path cActionFilePath;
	private Path cActionFileOriginalPath;
	
	@Before
	public void setup() {
		cHeaderFilePath = Paths.get("testresources", "c-converted-globals.h");
		cHeaderFileOriginalPath = Paths.get("testresources", "c-unconverted-globals.h");
		cActionFilePath = Paths.get("testresources", "c-converted-action.c");
		cActionFileOriginalPath = Paths.get("testresources", "c-unconverted-action.c");
	}	

	@Test
	public void insertingScriptRecurring() throws IOException {
		File tempHeader = tempFolderRule.newFile("RecurringGlobals.h");
		File tempAction = tempFolderRule.newFile("RecurringAction.c");
		Files.copy(cHeaderFileOriginalPath, tempHeader.toPath(),StandardCopyOption.REPLACE_EXISTING);
		Files.copy(cActionFileOriginalPath, tempAction.toPath(),StandardCopyOption.REPLACE_EXISTING);
		
		List<ScriptFile> headerList = new LinkedList<>();
		List<ScriptFile> bodyList = new LinkedList<>();
		headerList.add(new ScriptFile(tempHeader));
		bodyList.add(new ScriptFile(tempAction));
		
		for(int repeat=0;repeat<10;repeat++) {
			convertFiles(true,headerList,bodyList,true);
		}
		
		assertCompareFiles(tempHeader,cHeaderFilePath.toFile());
		assertCompareFiles(tempAction,cActionFilePath.toFile());
	}
	
	@Test
	public void ConvertUnconvertScenario() throws IOException {
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
		convertFiles(false,headerList,bodyList,true);
		assertCompareFiles(tempHeader,cHeaderFileOriginalPath.toFile());
		assertCompareFiles(tempAction,cActionFileOriginalPath.toFile());
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
