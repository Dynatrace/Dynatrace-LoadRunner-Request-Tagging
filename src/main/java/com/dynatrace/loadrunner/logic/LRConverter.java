package com.dynatrace.loadrunner.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.dynatrace.loadrunner.Mode;
import com.dynatrace.loadrunner.Technology;

public class LRConverter {

	public class AlreadyModifiedException extends Exception {
		private static final long serialVersionUID = -3655274412477949745L;
	}

	private List<ScriptFile> bodyFiles;
	private List<ScriptFile> headerFiles;
	private String lsn;
	private Mode mode;
	private Technology technology;

	public LRConverter(Mode mode, Technology technology, List<ScriptFile> headerFiles, List<ScriptFile> bodyFiles,
			String lsn) {
		this.mode = mode;
		this.technology = technology;
		this.headerFiles = headerFiles;
		this.bodyFiles = bodyFiles;
		this.lsn = lsn;
	}

	public void convert() {
		Iterator<ScriptFile> bodyFile = bodyFiles.iterator();
		while (bodyFile.hasNext()) {
			convertBody(bodyFile.next());
		}
		Iterator<ScriptFile> headerFile = headerFiles.iterator();
		while (headerFile.hasNext()) {
			convertHeader(headerFile.next());
		}
	}

	private void convertBody(ScriptFile file) {
		try {
			File sourceFile = file.getFile();
			File targetFile = new File(sourceFile.getAbsolutePath() + Constants.TMP_FILE_EXT);
			FilePatcher generator = new FilePatcher(sourceFile, targetFile, file);
			if (lsn != null || !lsn.isEmpty()) {
				generator.configure(lsn, technology, mode);
			} else {
				generator.configure("", technology, mode);
			}
			replace(sourceFile, targetFile);

		} catch (IOException e) {
			System.out.println("Error: " + file.getFileName() + " " + e.getMessage());
		}
	}

	private void convertHeader(ScriptFile file) {
		boolean success = false;
		int lastIncludeLine;
		try {
			File sourceFile = file.getFile();
			File targetFile = new File(sourceFile.getAbsolutePath() + Constants.TMP_FILE_EXT);
			try {
				if (mode.equals(Mode.INSERT)) {
					lastIncludeLine = findLastIncludeInHFile(sourceFile);
					if (technology.equals(Technology.C)) {
						success = convertCGlobals(sourceFile, targetFile, lastIncludeLine);
					} else {
						success = convertJsGlobals(sourceFile, targetFile);
					}
				} else {
					success = removeHeader(sourceFile, targetFile);
				}
			} catch (AlreadyModifiedException ame) {
				System.out.println("Warning: " + file.getFileName() + " The file is already modified!");
			}

			if (success) {
				replace(sourceFile, targetFile);
			}
		} catch (IOException e) {
			System.out.println("Error: " + file.getFileName() + " " + e.getMessage());
		}
	}

	private boolean removeHeader(File sourceFile, File targetFile) throws IOException {

		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(targetFile);
			reader = new BufferedReader(new FileReader(sourceFile));

			String line;
			while ((line = reader.readLine()) != null) {
				boolean found = false;
				if (line.contains(Constants.DT_HEADER)) {
					int braces = 0;
					found = true;
					while ((line = reader.readLine()) != null) {
						if (line.contains("{")) {
							braces++;
							continue;
						}
						if (line.contains("}") && braces > 0) {
							braces--;
							continue;
						}
						if (line.contains("}") && !line.contains("}\""))
							break;
					}
					line = reader.readLine();
					if (line != null && !line.isEmpty())
						writer.write(line);
				}

				if (!found)
					writer.write(line + Constants.CRLF);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(Constants.FILE_NOT_FOUND);
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
			}

			try {
				writer.close();
			} catch (Exception e) {
			}
		}

		return true;
	}

	private void replace(File sourceFile, File targetFile) throws IOException {
		if (!sourceFile.delete() || !targetFile.renameTo(sourceFile)) {
			throw new IOException(Constants.UNABLE_TO_RESTORE_FILE + sourceFile.getAbsolutePath());
		}
	}

	private int findLastIncludeInHFile(File sourceFile)
			throws IOException, FileNotFoundException, AlreadyModifiedException {
		BufferedReader reader = null;
		String line = null;
		int lineCount = 0;
		int result = 0;

		try {
			reader = new BufferedReader(new FileReader(sourceFile));

			while ((line = reader.readLine()) != null) {
				lineCount++;
				if (line.trim().startsWith(Constants.INCLUDE_KEYWORD)) {
					result = lineCount;
				}
				if (line.contains(Constants.DT_HEADER) && mode.equals(Mode.INSERT))
					throw new AlreadyModifiedException();
			}
		} catch (FileNotFoundException fne) {
			throw new FileNotFoundException(Constants.FILE_NOT_FOUND);
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	private boolean convertCGlobals(File sourceFile, File targetFile, int lastIncludeLine)
			throws IOException, FileNotFoundException {
		BufferedReader reader = null;
		PrintWriter writer = null;
		int lineCount = 0;
		String line = null;

		try {
			writer = new PrintWriter(targetFile);
			reader = new BufferedReader(new FileReader(sourceFile));

			lineCount = 0;
			while ((line = reader.readLine()) != null) {
				writer.write(line + Constants.CRLF);
				if (++lineCount == lastIncludeLine)
					writer.write(FileReaderUtil.getClassResources(LRConverter.class, FileReaderUtil.C_FUNCTION));
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(Constants.FILE_NOT_FOUND);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
			try {
				reader.close();
			} catch (Exception e) {
			}
		}

		return true;
	}

	private boolean convertJsGlobals(File sourceFile, File targetFile) throws IOException {
		BufferedReader reader = null;
		PrintWriter writer = null;
		String line = null;

		try {
			writer = new PrintWriter(targetFile);
			reader = new BufferedReader(new FileReader(sourceFile));
			while ((line = reader.readLine()) != null) {
				writer.write(line + Constants.CRLF);
			}
			writer.write(FileReaderUtil.getClassResources(LRConverter.class, FileReaderUtil.JS_FUNCTION));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(Constants.FILE_NOT_FOUND);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
			try {
				reader.close();
			} catch (Exception e) {
			}
		}

		return true;
	}

}
