package com.dynatrace.loadrunner.converter;

import java.io.File;
import java.util.Collection;

public class OutputFiles {

	private final Collection<File> headerFiles;
	private final Collection<File> bodyFiles;

	public OutputFiles(Collection<File> headerFiles, Collection<File> bodyFiles) {
		this.headerFiles = headerFiles;
		this.bodyFiles = bodyFiles;
	}

	public Collection<File> getHeaderFiles() {
		return headerFiles;
	}

	public Collection<File> getBodyFiles() {
		return bodyFiles;
	}
}
