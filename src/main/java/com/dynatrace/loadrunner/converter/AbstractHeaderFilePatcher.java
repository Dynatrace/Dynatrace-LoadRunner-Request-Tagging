package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.dynatrace.loadrunner.Constants;
import com.dynatrace.loadrunner.config.Mode;

abstract class AbstractHeaderFilePatcher extends AbstractFilePatcher {

	AbstractHeaderFilePatcher(Mode mode, boolean verbose) {
		super(mode, verbose);
	}

	protected boolean patch(File sourceFile, File targetFile) throws IOException {
		switch (mode) {
		case DELETE:
			return removeHeader(sourceFile, targetFile);
		case INSERT:
			return addHeader(sourceFile, targetFile);
		default:
			throw new UnsupportedOperationException("Unknown patch mode: " + mode);
		}
	}

	protected abstract boolean addHeader(File sourceFile, File targetFile) throws IOException;

	private boolean removeHeader(File sourceFile, File targetFile) throws IOException {
		try (
				BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
				PrintWriter writer = new PrintWriter(targetFile)
		) {
			boolean headerFound = false;
			int totalBracesCount = 0;

			String line;
			while ((line = reader.readLine()) != null) {
				headerFound |= line.contains(Constants.DT_HEADER);
				if (headerFound) {
					totalBracesCount += countBraces(line);
					headerFound = totalBracesCount > 0;
					continue;
					// skip this line; we're in the middle of header block
				}
				writer.write(line);
				writer.write(Constants.CRLF);
			}
		}
		return true;
	}

	private int countBraces(String line) {
		int result = 0;
		for (int i = 0; i < line.length(); i++) {
			switch (line.charAt(i)) {
			case '{':
				result++;
				break;
			case '}':
				result--;
				break;
			}
		}
		return result;
	}

}
