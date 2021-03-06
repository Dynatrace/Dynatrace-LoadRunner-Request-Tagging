package com.dynatrace.loadrunner.converter;

import java.io.File;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import com.dynatrace.loadrunner.config.InputFiles;
import com.dynatrace.loadrunner.config.Mode;
import com.dynatrace.loadrunner.config.Technology;

public class FilesConverter {

	private Collection<File> bodyFiles;
	private Collection<File> headerFiles;

	private final AbstractBodyFilePatcher bodyFilePatcher;
	private final AbstractHeaderFilePatcher headerFilePatcher;
	private final boolean verbose;

	public FilesConverter(Mode mode, Technology technology, InputFiles inputFiles, String userScriptName, boolean verbose) {
		headerFiles = inputFiles.getHeaderFiles();
		bodyFiles = inputFiles.getBodyFiles();
		this.verbose = verbose;
		bodyFilePatcher = getBodyFilePatcher(technology, mode,
				StringUtils.isBlank(userScriptName) ? inputFiles.getScriptNameFromPath() : userScriptName);
		headerFilePatcher = getHeaderFilePatcher(technology, mode);
	}

	private AbstractHeaderFilePatcher getHeaderFilePatcher(Technology technology, Mode mode) {
		switch (technology) {
		case C:
			return new CHeaderFilePatcher(mode, verbose);
		case JS:
			return new JSHeaderFilePatcher(mode, verbose);
		default:
			throw new UnsupportedOperationException("Unsupported technology: " + technology);
		}
	}

	private AbstractBodyFilePatcher getBodyFilePatcher(Technology technology, Mode mode, String scriptName) {
		switch (technology) {
		case C:
			return new CBodyFilePatcher(mode, scriptName, verbose);
		case JS:
			return new JSBodyFilePatcher(mode, scriptName, verbose);
		default:
			throw new UnsupportedOperationException("Unsupported technology: " + technology);
		}
	}

	public void convert() {
		for (File bodyFile : bodyFiles) {
			bodyFilePatcher.patch(bodyFile);
		}
		for (File headerFile : headerFiles) {
			headerFilePatcher.patch(headerFile);
		}
	}
}
