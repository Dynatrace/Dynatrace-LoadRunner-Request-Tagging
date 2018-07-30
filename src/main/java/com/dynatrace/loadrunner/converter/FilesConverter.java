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

	public FilesConverter(Mode mode, Technology technology, InputFiles inputFiles, String userScriptName) {
		headerFiles = inputFiles.getHeaderFiles();
		bodyFiles = inputFiles.getBodyFiles();
		String scriptName = StringUtils.isBlank(userScriptName) ? inputFiles.getScriptNameFromPath() : userScriptName;
		bodyFilePatcher = getBodyFilePatcher(technology, mode, scriptName);
		headerFilePatcher = getHeaderFilePatcher(technology, mode);
	}

	private AbstractHeaderFilePatcher getHeaderFilePatcher(Technology technology, Mode mode) {
		switch (technology) {
		case C:
			return new CHeaderFilePatcher(mode);
		case JS:
			return new JSHeaderFilePatcher(mode);
		}
		return null;
	}

	private AbstractBodyFilePatcher getBodyFilePatcher(Technology technology, Mode mode, String scriptName) {
		switch (technology) {
		case C:
			return new CBodyFilePatcher(mode, scriptName);
		case JS:
			return new JSBodyFilePatcher(mode, scriptName);
		}
		return null;
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
