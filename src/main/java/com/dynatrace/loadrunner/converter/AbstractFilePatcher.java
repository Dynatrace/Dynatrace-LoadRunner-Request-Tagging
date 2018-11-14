package com.dynatrace.loadrunner.converter;

import java.io.File;
import java.io.IOException;

import com.dynatrace.loadrunner.Constants;

abstract class AbstractFilePatcher {

	protected final boolean verbose;

	AbstractFilePatcher(boolean verbose) {
		this.verbose = verbose;
	}

	void patch(File sourceFile) {
		try {
			File targetFile = new File(sourceFile.getAbsolutePath() + Constants.TMP_FILE_EXT);
			if (patch(sourceFile, targetFile)) {
				replace(sourceFile, targetFile);
			}
		} catch (IOException e) {
			System.err.printf("Error processing file '%s': %s", sourceFile.getName(), e.getMessage());
		}
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
