package com.dynatrace.loadrunner.converter;

import java.io.File;
import java.io.IOException;

import com.dynatrace.loadrunner.Constants;

abstract class AbstractFilePatcher {

	void patch(File sourceFile) {
		try {
			File targetFile = new File(sourceFile.getAbsolutePath() + Constants.TMP_FILE_EXT);
			if (patch(sourceFile, targetFile)) {
				replace(sourceFile, targetFile);
			}
		} catch (IOException e) {
			System.out.println("Error processing file '" + sourceFile.getName() + "': " + e.getMessage());
		}
	}

	protected abstract boolean patch(File sourceFile, File targetFile) throws IOException;

	private void replace(File sourceFile, File targetFile) throws IOException {
		if (!sourceFile.delete() || !targetFile.renameTo(sourceFile)) {
			throw new IOException(Constants.UNABLE_TO_RESTORE_FILE + sourceFile.getAbsolutePath());
		}
	}
}
