package com.dynatrace.loadrunner.data;

import java.io.File;

public class ScriptFile {

	private ScriptFileState state;
	private String path;
	private String fileName;
	private File file;

	public ScriptFile(File file)
	{
		this.fileName=file.getName();
		this.path=file.getParentFile().getAbsolutePath();
		this.file=file;
		this.state=ScriptFileState.Unhandled;
	}

	public String getPath() {
		return path;
	}

	public String getFileName() {
		return fileName;
	}

	public File getFile() {
		return file;
	}

	public ScriptFileState getState() {
		return state;
	}

	public void setState(ScriptFileState state) {
		this.state = state;
	}
}
