package com.dynatrace.loadrunner.data;

import java.io.File;


public enum FilterType {
	ALL_FILES,
	NO_FILES,
	C_FILES,
	H_FILES;

	public boolean accept(File f)
	{
		if (f==null || f.isDirectory())
			return false;
		if (this==C_FILES)
		{
			if (f.getName().endsWith(".c"))
				return true;
			return false;
		}
		if (this==H_FILES)
		{
			if (f.getName().equals("globals.h"))
				return true;
			return false;
		}
		if (this==ALL_FILES)
			return true;
		return false;
	}
}
