package com.dynatrace.loadrunner.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class DirectoryBrowser {
	private static final String COULD_NOT_RETRIEVE_FILES = "Could not retrieve files in the specified Directory";

	/**
	 *
	 * @param dirPath
	 * @return a List of Loadrunner ScriptFiles(or more correctly .c and globals.h files)
	 * @throws Exception
	 * @author simon.schatka
	 */
	public static List<File> getFiles(String dirPath) throws FileNotFoundException
	{
		List<File> files=new LinkedList<File>();
		recurseDirectory(new File(dirPath), files);
		return files;
	}

	private static void recurseDirectory(File actDir, List<File> fileList) throws FileNotFoundException
	{
		if (actDir.exists())
		{
			File[] files=actDir.listFiles();
			if (files==null) {
				throw new FileNotFoundException(COULD_NOT_RETRIEVE_FILES);
			}
			for (File file: files)
			{
				if (file.isDirectory())
				{
					recurseDirectory(file, fileList);
				}
				else
				{
					if (FilterType.C_FILES.accept(file) || FilterType.H_FILES.accept(file)){
						fileList.add(file);
					}
				}
			}
		}
	}
}
