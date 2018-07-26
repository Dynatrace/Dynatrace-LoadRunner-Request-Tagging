package com.dynatrace.loadrunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.dynatrace.loadrunner.UserConfig.Mode;
import com.dynatrace.loadrunner.UserConfig.Technology;
import com.dynatrace.loadrunner.logic.LRConverter;
import com.dynatrace.loadrunner.logic.ScriptFile;

public class Main {

	private static List<ScriptFile> headers = new ArrayList<>();
	private static List<ScriptFile> body = new ArrayList<>();
	private static String lsn;
	private static Mode mode;
	private static Technology technology;

	public static void main(String[] args) throws IOException {

		UserConfig userConfig = ArgumentParser.getConfig(args);

		setLsn(userConfig.getLsn(), userConfig.getPath());
		setMode(userConfig.getMode());
		setTechnology(userConfig.getTechnology());
		if (userConfig.getPath() == null) {
			getHeaders(userConfig.getHeader());
			getBodies(userConfig.getBody());
		} else {
			getFilesFromPath(userConfig.getPath());
		}
		prepareFiles();
		LRConverter converter = new LRConverter(mode, technology, headers, body, lsn);
		converter.convert();
	}

	private static void setLsn(String scriptName, String path) {
		if (StringUtils.isBlank(scriptName) && StringUtils.isNotBlank(path)) {
			getScriptNameFromPath(path);
		} else if (StringUtils.isNotBlank(scriptName)) {
			lsn = scriptName;
		} else {
			lsn = "";
		}
	}

	private static void setMode(Mode selectedMode) {
		mode = selectedMode;
	}

	private static void setTechnology(Technology selectedTechnology) {
		technology = selectedTechnology;
	}

	private static void getFilesFromPath(String path) {
		searchPath(new File(path));
	}

	private static void getHeaders(String[] headersArray) {
		for (String file : headersArray) {
			headers.add(new ScriptFile(new File(file)));
		}
	}

	private static void getBodies(String[] bodiesArray) {
		for (String file : bodiesArray) {
			body.add(new ScriptFile(new File(file)));
		}
	}

	private static void getScriptNameFromPath(String path) {
		File directory = new File(path);
		for (File file : directory.listFiles()) {
			if (getFileExtension(file).equals("usr")) {
				lsn = file.getName().replaceFirst("[.][^.]+$", "");
			}
		}
	}

	private static void searchPath(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				searchPath(fileEntry);
			}
			if (fileEntry.getName().equals("globals.js") || fileEntry.getName().equals("globals.h")) {
				headers.add(new ScriptFile(fileEntry));
			} else if ((!fileEntry.getName().equals("globals.js") && getFileExtension(fileEntry).equals("js"))
					|| getFileExtension(fileEntry).equals("c")) {
				body.add(new ScriptFile(fileEntry));
			}
		}
	}

	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	private static void prepareFiles() {
		if (technology.equals(Technology.C)) {
			Iterator<ScriptFile> iterator = headers.iterator();
			while (iterator.hasNext()) {
				ScriptFile file = iterator.next();
				if (!getFileExtension(file.getFile()).equals("h") && !file.getFileName().equals("globals.h")) {
					iterator.remove();
				}
			}
			iterator = body.iterator();
			while (iterator.hasNext()) {
				ScriptFile file = iterator.next();
				if (!getFileExtension(file.getFile()).equals("c")) {
					iterator.remove();
				}
			}
		} else if (technology.equals(Technology.JS)) {
			Iterator<ScriptFile> iterator = headers.iterator();
			while (iterator.hasNext()) {
				ScriptFile file = iterator.next();
				if (!getFileExtension(file.getFile()).equals("js") && !file.getFileName().equals("globals.js")) {
					iterator.remove();
				}
			}
			iterator = body.iterator();
			while (iterator.hasNext()) {
				ScriptFile file = iterator.next();
				if (!getFileExtension(file.getFile()).equals("js")) {
					iterator.remove();
				}
			}
		}
	}
}