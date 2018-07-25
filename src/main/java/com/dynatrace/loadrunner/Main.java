package com.dynatrace.loadrunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.dynatrace.loadrunner.logic.FileReaderUtil;
import com.dynatrace.loadrunner.logic.LRConverter;
import com.dynatrace.loadrunner.logic.ScriptFile;

public class Main {

	private static List<ScriptFile> headers = new ArrayList<>();
	private static List<ScriptFile> body = new ArrayList<>();
	private static String scriptName = "";
	private static Boolean mode;
	private static boolean cEngine = true;

	public static void main(String[] args) throws IOException {

		System.out.println(FileReaderUtil.getClassResources(Main.class, FileReaderUtil.VERSION));

		if (args.length == 0) {
			System.out.println(FileReaderUtil.getClassResources(Main.class, FileReaderUtil.PRINT_USAGES));
			return;
		}

		CommandLineParser parser = new CommandLineParser(args);

		if (parser.arguments.containsKey("-help")) {
			System.out.println(FileReaderUtil.getClassResources(Main.class, FileReaderUtil.PRINT_USAGES));
			return;
		}

		for (Entry<String, String> pair : parser.arguments.entrySet()) {
			String key = pair.getKey().toLowerCase();
			if (key.equals("insert")) {
				setMode(pair.getKey());
			} else if (key.equals("delete")) {
				setMode(pair.getKey());
			} else if (key.equals("lsn")) {
				setScriptName(pair.getValue());
			} else if (key.equals("path")) {
				try {
					File directory = new File(pair.getValue());
					searchPath(directory);
				} catch (NullPointerException e) {
					System.out.println("Make sure you'd provided correct path to script file \n");
					return;
				}
			} else if (key.equals("-c")) {
				cEngine = true;
			} else if (key.equals("-js")) {
				cEngine = false;
			} else if (key.equals("body")) {
				String bodies[] = pair.getValue().split("&");
				for (String str : bodies) {
					body.add(new ScriptFile(new File(str)));
				}
			} else if (key.equals("header")) {
				String header[] = pair.getValue().split("&");
				for (String str : header) {
					headers.add(new ScriptFile(new File(str)));
				}
			} else {
				System.out.println(FileReaderUtil.getClassResources(Main.class, FileReaderUtil.PRINT_USAGES));
				System.out.println("\nUnknown parameter: " + key);
				return;
			}
		}
		if (scriptName.isEmpty() && parser.validateKey("path")) {
			getScriptNameFromPath(parser.arguments.get("path"));
		}
		validateFiles();
		boolean validated = validateParams();
		if (validated) {
			LRConverter converter = new LRConverter(mode, headers, body, scriptName, cEngine);
			converter.convert();
			System.out.println("conversion complete");
		} else {
			System.out.println("ERROR, conversion failed");
		}
	}

	private static void getScriptNameFromPath(String path) {
		File directory = new File(path);
		for (File file : directory.listFiles()) {
			if (getFileExtension(file).equals("usr")) {
				scriptName = file.getName().replaceFirst("[.][^.]+$", "");
			}
		}
	}

	private static boolean validateParams() {
		if (headers.isEmpty()) {
			System.out.println("Headers not found");
			return false;
		}
		if (body.isEmpty()) {
			System.out.println("Bodies not found");
			return false;
		}
		if (mode == null) {
			System.out.println("Provide insert/delete parameter");
			return false;
		}
		return true;
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

	private static void setMode(String arg) {
		if (arg.equals("insert")) {
			mode = true;
		}
		if (arg.equals("delete")) {
			mode = false;
		}
		System.out.println("Setting mode to: " + arg);
	}

	private static void setScriptName(String name) {
		scriptName = name;
		System.out.println("Setting script name to: " + scriptName);
	}

	private static void validateFiles() {
		if (cEngine) {
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
		} else {
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