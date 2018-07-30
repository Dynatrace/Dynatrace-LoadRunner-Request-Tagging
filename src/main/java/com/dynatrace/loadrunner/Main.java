package com.dynatrace.loadrunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dynatrace.loadrunner.logic.FileReaderUtil;
import com.dynatrace.loadrunner.logic.LRConverter;
import com.dynatrace.loadrunner.logic.ScriptFile;

public class Main {

	private static List<ScriptFile> headers = new ArrayList<>();
	private static List<ScriptFile> body = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Map<Argument, String> argumentsMap = ArgumentParser.parse(args);
		if (argumentsMap.containsKey(Argument.HELP)) {
			printUsage();
			return;
		}

		try {
			ArgumentParser.validate(argumentsMap);
		} catch (IllegalArgumentException e) {
			System.out.println("\nError occurred: " + e.getMessage() + "\n");
			printUsage();
			return;
		}

		printVersion();
		UserConfig userConfig = UserConfig.from(argumentsMap);

		String lsn = userConfig.getLsn();
		if (StringUtils.isBlank(lsn)) {
			lsn = getScriptNameFromPath(userConfig.getPath());
		}
		Mode mode = userConfig.getMode();
		Technology technology = userConfig.getTechnology();
		if (userConfig.getPath() == null) {
			getHeaders(userConfig.getHeader());
			getBodies(userConfig.getBody());
		} else {
			getFilesFromPath(userConfig.getPath());
		}
		prepareFiles(technology);
		LRConverter converter = new LRConverter(mode, technology, headers, body, lsn);
		converter.convert();
		System.out.println("Conversion complete");
	}

	private static void printVersion() throws IOException {
		System.out.println(FileReaderUtil.getVersion());
	}

	private static void printUsage() throws IOException {
		System.out.println(FileReaderUtil.getPrintUsages());
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

	private static String getScriptNameFromPath(String path) {
		String lsn = "";
		File directory = new File(path);
		for (File file : directory.listFiles()) {
			if (getFileExtension(file).equals("usr")) {
				lsn = file.getName().replaceFirst("[.][^.]+$", "");
				return lsn;
			}
		}
		return lsn;
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
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		return "";
	}

	private static void prepareFiles(Technology technology) {
		switch (technology) {
		case C:
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
			break;
		case JS:
			Iterator<ScriptFile> iteratorJS = headers.iterator();
			while (iteratorJS.hasNext()) {
				ScriptFile file = iteratorJS.next();
				if (!getFileExtension(file.getFile()).equals("js") && !file.getFileName().equals("globals.js")) {
					iteratorJS.remove();
				}
			}
			iteratorJS = body.iterator();
			while (iteratorJS.hasNext()) {
				ScriptFile file = iteratorJS.next();
				if (!getFileExtension(file.getFile()).equals("js")) {
					iteratorJS.remove();
				}
			}
			break;
		}
	}
}