package com.dynatrace.loadrunner.config;

import java.io.File;
import java.util.Collection;

public class InputFiles {

	private final Collection<File> headerFiles;
	private final Collection<File> bodyFiles;
	private final String scriptNameFromPath;

	public InputFiles(Collection<File> headerFiles, Collection<File> bodyFiles) {
		this(headerFiles, bodyFiles, null);
	}

	public InputFiles(Collection<File> headerFiles, Collection<File> bodyFiles, String scriptNameFromPath) {
		this.headerFiles = headerFiles;
		this.bodyFiles = bodyFiles;
		this.scriptNameFromPath = scriptNameFromPath;
	}

	public Collection<File> getHeaderFiles() {
		return headerFiles;
	}

	public Collection<File> getBodyFiles() {
		return bodyFiles;
	}

	public String getScriptNameFromPath() {
		return scriptNameFromPath;
	}
}
