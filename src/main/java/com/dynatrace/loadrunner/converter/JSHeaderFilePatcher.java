package com.dynatrace.loadrunner.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.dynatrace.loadrunner.Constants;
import com.dynatrace.loadrunner.config.Mode;
import com.dynatrace.loadrunner.converter.util.ResourceFileReaderUtil;

public class JSHeaderFilePatcher extends AbstractHeaderFilePatcher {

	JSHeaderFilePatcher(Mode mode) {
		super(mode);
	}

	@Override protected boolean addHeader(File sourceFile, File targetFile) throws IOException {
		if (isAlreadyPatched(sourceFile)) {
			return false;
		}
		try (
				BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
				PrintWriter writer = new PrintWriter(targetFile)
		) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line + Constants.CRLF);
			}
			writer.write(ResourceFileReaderUtil.getClassResources(FilesConverter.class, ResourceFileReaderUtil.JS_FUNCTION));
		}

		return true;
	}

	private boolean isAlreadyPatched(File sourceFile) throws IOException {
		try (
				BufferedReader reader = new BufferedReader(new FileReader(sourceFile))
		) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(Constants.DT_HEADER)) {
					return true;
				}
			}
		}
		return false;
	}

}
