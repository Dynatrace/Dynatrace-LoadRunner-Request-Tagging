package com.dynatrace.loadrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.dynatrace.loadrunner.data.ScriptFile;
import com.dynatrace.loadrunner.logic.LoadRunnerConverter;

/**
 * @author thomas.ebner, hans-peter.weidinger
 */
public class LoadrunnerScriptConverterTest {

	@Rule
	public TemporaryFolder tempFolderRule = new TemporaryFolder();

	private File patchedHFile;
	private File patchedCFile;
	private File hFile;
	private File cFile;
	private File originalHFile;
	private File originalCFile;
	private LoadRunnerConverter converter;

	@Before
	public void setup() throws IOException {
		// setup header files, same for all tests.
		// .c files have to be created in individual tests!
		converter = new LoadRunnerConverter();
		patchedHFile = new File(LoadrunnerScriptConverterTest.class.getResource("/patchedglobals.h").getPath());
		originalHFile = new File(LoadrunnerScriptConverterTest.class.getResource("/originalglobals.h").getPath());
		hFile = tempFolderRule.newFile("globals.h");
		copyFile(originalHFile, hFile);
	}

	@Test
	public void testScriptConverter() throws IOException {
		patchedCFile = new File(LoadrunnerScriptConverterTest.class.getResource("/patchedaction.c").getPath());
		originalCFile = new File(LoadrunnerScriptConverterTest.class.getResource("/originalaction.c").getPath());
		cFile = tempFolderRule.newFile("action.c");
		copyFile(originalCFile, cFile);

		doTest();
	}

	@Test
	public void testBlockComment() throws IOException {
		patchedCFile = new File(LoadrunnerScriptConverterTest.class.getResource("/patchedaction_blockcomment.c").getPath());
		originalCFile = new File(LoadrunnerScriptConverterTest.class.getResource("/originalaction_blockcomment.c").getPath());
		cFile = tempFolderRule.newFile("action.c");
		copyFile(originalCFile, cFile);

		doTest();
	}

	@Test
	public void testSkipBlockComment() throws IOException {
		patchedCFile = new File(LoadrunnerScriptConverterTest.class.getResource("/patched_skipblockcomment.c").getPath());	// TODO:
// change file for comparison
		originalCFile = new File(LoadrunnerScriptConverterTest.class.getResource("/original_skipblockcomment.c").getPath());
		cFile = tempFolderRule.newFile("action.c");
		copyFile(originalCFile, cFile);

		doTest();
	}

	private void doTest() throws IOException {

		LinkedList<ScriptFile> hFiles = new LinkedList<ScriptFile>();
		hFiles.add(new ScriptFile(hFile));
		LinkedList<ScriptFile> cFiles = new LinkedList<ScriptFile>();
		cFiles.add(new ScriptFile(cFile));

		// insert Calls
		insertCalls(hFiles, cFiles);

		// insert Calls again, to make sure nothing odd happens
		insertCalls(hFiles, cFiles);

		// remove Calls
		removeCalls(hFiles, cFiles);

		//remove Calls again to make sure nothing odd happens
		removeCalls(hFiles, cFiles);
	}


	private void removeCalls(LinkedList<ScriptFile> hFiles, LinkedList<ScriptFile> cFiles) throws IOException {
		converter.configureConverter(false, hFiles, cFiles);
		converter.convertFiles();

		compareFiles(hFile, originalHFile);
		compareFiles(cFile, originalCFile);
	}


	private void insertCalls(LinkedList<ScriptFile> hFiles, LinkedList<ScriptFile> cFiles) throws IOException {
		converter.configureConverter(true, hFiles, cFiles);
		converter.convertFiles();

		compareFiles(hFile, patchedHFile);
		compareFiles(cFile, patchedCFile);
	}

	private void compareFiles(File modifiedFile, File comparisonFile) throws IOException {
		BufferedReader modifiedReader = new BufferedReader(new InputStreamReader(new FileInputStream(modifiedFile)));
		BufferedReader comparisonReader = new BufferedReader(new InputStreamReader(new FileInputStream(comparisonFile)));
		try {
			String line;
			while ((line = modifiedReader.readLine()) != null) {
				String otherLine = comparisonReader.readLine();
				if (otherLine == null)
					Assert.assertTrue("Files do not have the same amount of lines", false);
				Assert.assertEquals("Lines do not match", line, otherLine);
			}
			if (comparisonReader.readLine() != null)
				Assert.assertTrue("Files do not have the same amount of lines", false);
		} finally {
			modifiedReader.close();
			comparisonReader.close();
		}
	}

	private static void copyFile(File sourceFile, File destFile) throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}
}
