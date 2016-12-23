package com.dynatrace.loadrunner.logic;

import java.io.File;

public class ScriptFile {

	private String fileName;
	private File file;

	public ScriptFile(File file)
	{
		this.fileName=file.getName();
		this.file=file;
	}

	public String getFileName() {
		return fileName;
	}

	public File getFile() {
		return file;
	}
}
