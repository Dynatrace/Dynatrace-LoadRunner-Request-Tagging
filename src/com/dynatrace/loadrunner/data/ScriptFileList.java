package com.dynatrace.loadrunner.data;

import java.io.File;
import java.util.ArrayList;

public class ScriptFileList {
	private ArrayList<ScriptFile> files;

	public ScriptFileList()
	{
		files=new ArrayList<ScriptFile>();
	}

	public void addScriptFile(File file) {
		ScriptFile scriptFile = new ScriptFile(file);
		files.add(scriptFile);
	}

	public void clear()
	{
		files.clear();
	}

	public ArrayList<ScriptFile> getScriptFiles()
	{
		return files;
	}
}
