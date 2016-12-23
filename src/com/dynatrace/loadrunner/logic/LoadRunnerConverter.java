package com.dynatrace.loadrunner.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.dynatrace.loadrunner.data.ScriptFile;
import com.dynatrace.loadrunner.data.ScriptFileState;

/**
 *
 * @author ardeshir.arfaian
 *
 *         pass list with .c file names pass list with globals.h file locations
 *
 *         modify globals.h file modify .c files
 *
 *         extended functionality match URLs with mappings and use mappings
 *         update modified .c | .h files build in logging what should happen to
 *         commented portions don't replace existing headerCalls
 */
public class LoadRunnerConverter {

	public class AlreadyModifiedException extends Exception {
		private static final long serialVersionUID = -3655274412477949745L;
	}

	private List<ScriptFile> hFiles;
	private List<ScriptFile> cFiles;
	private boolean mode;

	private void replaceOriginalFile(File sourceFile, File targetFile) throws IOException{
		// replace original file with temporary file
		if (!sourceFile.delete())
			throw new IOException(Constants.WAS_NOT_ABLE_TO_RESTORE + sourceFile.getAbsolutePath());
		if (!targetFile.renameTo(sourceFile))
			throw new IOException(Constants.WAS_NOT_ABLE_TO_RESTORE + sourceFile.getAbsolutePath());
	}

	private void convertCFile(ScriptFile scriptFile) {
		try {
			File sourceFile = scriptFile.getFile();
			File targetFile = new File(sourceFile.getAbsolutePath()+".tmp");

			CFilePatcher generator=new CFilePatcher(sourceFile, targetFile, scriptFile);
			generator.generateFile(mode);

			replaceOriginalFile(sourceFile, targetFile);

		} catch (IOException e) {
			System.out.println("Error: " + scriptFile.getFileName() + " " + e.getMessage());
		}
	}

	private void convertCFiles() {
		Iterator<ScriptFile> cFile = cFiles.iterator();
		while (cFile.hasNext()) {
			convertCFile(cFile.next());
		}
	}

	private boolean insertDynaTraceFunctions(File sourceFile, File targetFile,
			int lastIncludeLine) throws IOException, FileNotFoundException {
		BufferedReader reader = null;
		PrintWriter writer = null;
		int lineCount = 0;
		String line = null;

		try {
			writer = new PrintWriter(targetFile);
			reader = new BufferedReader(new FileReader(sourceFile));

			lineCount = 0;
			while ((line = reader.readLine()) != null) {
				writer.write(line + Constants.CRLF_OS_INDEPENDENT);
				if (++lineCount == lastIncludeLine)
					writer.write(Constants.DT_FUNCTION);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(Constants.COULD_NOT_FIND_THE_FILE);
		}
		finally
		{
			try {
				writer.close();
			} catch (Exception e) {}
			try {
				reader.close();
			} catch (Exception e) {}
		}

		return true;
	}

	private int findLastIncludeInHFile(File sourceFile) throws IOException,FileNotFoundException, AlreadyModifiedException {
		BufferedReader reader = null;
		String line = null;
		int lineCount = 0;
		int result = 0;

		try{
			reader = new BufferedReader(new FileReader(sourceFile));

			while ((line = reader.readLine()) != null) {
				lineCount++;
				if (line.contains("#include"))
					result = lineCount;

				if (line.contains(Constants.ADD_HEADER_FUNCTION) && mode)
					throw new AlreadyModifiedException();
			}
		}
		catch (FileNotFoundException fne){
			throw new FileNotFoundException(Constants.COULD_NOT_FIND_THE_FILE);
		}
		finally{
			try {
				reader.close();
			} catch (Exception e) {}
		}
		return result;
	}

	private void convertHFile(ScriptFile scriptFile) {
		boolean success = false;
		int lastIncludeLine;
		// read file, search last #include & fill in
		try {
			File sourceFile = scriptFile.getFile();
			File targetFile = new File(sourceFile.getAbsolutePath()+".tmp");
			scriptFile.setState(ScriptFileState.Running);
			try {
				if (mode)
				{
					lastIncludeLine = findLastIncludeInHFile(sourceFile);
					success = insertDynaTraceFunctions(sourceFile, targetFile, lastIncludeLine);
				}
				else
				{
					success = removeDynaTraceFunctions(sourceFile, targetFile);
				}
			} catch (AlreadyModifiedException ame) {
				System.out.println("Warning: " + scriptFile.getFileName() + " The file is already modified!");
			}

			if (success)
				replaceOriginalFile(sourceFile, targetFile);
			scriptFile.setState(ScriptFileState.Handled);

		} catch (IOException e) {
			System.out.println("Error: " + scriptFile.getFileName() + " " + e.getMessage());
			scriptFile.setState(ScriptFileState.Error);
		}
	}

	/**
	 * Removes the dynaTrace specific Functions from the globals.h file
	 *
	 * @param sourceFile
	 * @param targetFile
	 * @return true if the removal was successful
	 * @throws IOException
	 * @author simon.schatka
	 */
	private boolean removeDynaTraceFunctions(File sourceFile, File targetFile) throws IOException {

		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(targetFile);
			reader = new BufferedReader(new FileReader(sourceFile));

			String line;
			while ((line = reader.readLine()) != null) {
				boolean found=false;
				//Found our Function-->read until we discover a "}" to remove our functions
				//if }" is found, we continue reading, because then it is the lr_eval_string function we encountered
				if (line.contains(Constants.ADD_HEADER_FUNCTION))
				{
					found=true;
					while ((line = reader.readLine()) != null)
					{
						if (line.contains("}") && !line.contains("}\""))
							break;
					}
					//read an additional line and check if it is emtpy
					//if it is empty delete it as well, could be one of ours
					line=reader.readLine();
					if (line!=null && !line.isEmpty())
						writer.write(line+ Constants.CRLF_OS_INDEPENDENT);
				}
				if (!found)
					writer.write(line+ Constants.CRLF_OS_INDEPENDENT);
			}
		}catch (FileNotFoundException e) {
			throw new FileNotFoundException(Constants.COULD_NOT_FIND_THE_FILE);
		}
		finally{
			try {
				reader.close();
			} catch (Exception e) {}

			try {
				writer.close();
			} catch (Exception e) {}
		}

		return true;
	}

	private void convertHFiles() {
		Iterator<ScriptFile> hFile = hFiles.iterator();

		while (hFile.hasNext()) {
			convertHFile(hFile.next());
		}
	}

	public void convertFiles() {
		if (cFiles != null)
			convertCFiles();

		if (hFiles != null)
			convertHFiles();
	}

	public void configureConverter(boolean mode, List<ScriptFile> hFiles, List<ScriptFile> cFiles) {
		this.hFiles = hFiles;
		this.cFiles = cFiles;
		this.mode = mode;
	}
}
