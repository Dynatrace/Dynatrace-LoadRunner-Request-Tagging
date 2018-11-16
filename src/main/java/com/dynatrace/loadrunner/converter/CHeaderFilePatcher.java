package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.dynatrace.loadrunner.Constants;
import com.dynatrace.loadrunner.config.Mode;
import com.dynatrace.loadrunner.converter.util.ResourceFileReaderUtil;

public class CHeaderFilePatcher extends AbstractHeaderFilePatcher {

	CHeaderFilePatcher(Mode mode, boolean verbose) {
		super(mode, verbose);
	}

	@Override
	protected boolean addHeader(File sourceFile, File targetFile) throws IOException {
		int lastIncludeLine = getLastIncludeKeywordLine(sourceFile);
		if (lastIncludeLine < 0) {
			// file was already patched
			return false;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
				PrintWriter writer = new PrintWriter(targetFile)) {
			int lineCount = 0;
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line + Constants.CRLF);
				if (++lineCount == lastIncludeLine) {
					writer.write(ResourceFileReaderUtil.getClassResources(FilesConverter.class,
							ResourceFileReaderUtil.C_FUNCTION));
				}
			}
		}
		return true;
	}

	private int getLastIncludeKeywordLine(File sourceFile) throws IOException {
		int result = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
			String line;
			int lineCount = 0;
			while ((line = reader.readLine()) != null) {
				lineCount++;
				if (line.trim().startsWith(Constants.INCLUDE_KEYWORD)) {
					result = lineCount;
				}
				if (line.contains(Constants.DT_HEADER)) {
					return -1;
				}
			}
		}
		return result;
	}
}
