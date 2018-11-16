package com.dynatrace.loadrunner.converter;

import java.io.File;
import java.io.IOException;

import com.dynatrace.loadrunner.Constants;
import com.dynatrace.loadrunner.config.Mode;

abstract class AbstractFilePatcher {

	protected final Mode mode;
	protected final boolean verbose;

	AbstractFilePatcher(Mode mode, boolean verbose) {
		this.mode = mode;
		this.verbose = verbose;
	}

	void patch(File sourceFile) {
		try {
			File targetFile = new File(sourceFile.getAbsolutePath() + Constants.TMP_FILE_EXT);
			if (patchInternal(sourceFile, targetFile)) {
				replace(sourceFile, targetFile);
			}
		} catch (IOException e) {
			System.err.printf("Error processing file '%s': %s%n", sourceFile.getName(), e.getMessage());
		}
	}

	private boolean patchInternal(File sourceFile, File targetFile) throws IOException {
		if(verbose) {
			switch (mode) {
			case DELETE:
				System.out.printf("Removing header from file %s%n", sourceFile.getAbsolutePath());
				break;
			case INSERT:
				System.out.printf("Adding header to file %s%n", sourceFile.getAbsolutePath());
				break;
			}
		}
		return patch(sourceFile, targetFile);
	}

	protected abstract boolean patch(File sourceFile, File targetFile) throws IOException;

	private void replace(File sourceFile, File targetFile) throws IOException {
		if (!sourceFile.delete() || !targetFile.renameTo(sourceFile)) {
			throw new IOException(Constants.UNABLE_TO_RESTORE_FILE + sourceFile.getAbsolutePath());
		}
		if(verbose) {
			System.out.printf("Replaced %s with %s%n", sourceFile.getName(), targetFile.getName());
		}
	}
}
