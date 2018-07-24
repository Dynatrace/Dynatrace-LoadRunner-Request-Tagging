package com.dynatrace.loadrunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.dynatrace.loadrunner.logic.LRConverter;
import com.dynatrace.loadrunner.logic.ScriptFile;

public class Main {

	private static List<ScriptFile> headers = new ArrayList<>();
	private static List<ScriptFile> body = new ArrayList<>();
	private static String scriptName = "";
	private static Boolean mode;
	private static boolean cEngine = true;
	private static final String VERSION = "Dt-LoadRunner-request-tagging version 2.0.1";

	public static void printUsages() {

		System.out.println("The LoadRunner Request Tagging tool uses the following syntax: \n"
				+ "java -jar Dt-LoadRunner-request-tagging.jar <mode> <path parameter> <optional parameters> \n" + "\n"
				+ "mode:\n"
				+ "	insert: to add the Dynatrace HTTP header to the selected LoadRunner scripts, type insert\n"
				+ "	delete: to remove all modifications previously made by the LoadRunner Request Tagging tool, type delete\n"
				+ "path parameter:\n" + "	Pick either -path or -body and -header\n"
				+ "	-path <filepath>: use to scan all directories and subdirectories for script file's and insert/delete script in them\n"
				+ "	-body <files> -header <files>: use to select exactly in which header and body files should be processed, the file seperator is & between files\n"
				+ "optional parameteer:\n"
				+ "	-LSN <value>: sets load script name to value passed after -LSN. If skipped, the script name will be taken from *.usr file\n"
				+ "	-c: sets C as scripting language used (default)\n"
				+ "	-js: sets JavaScript as scripting language\n" + "	-help: prints usage\n");
	}

	public static void main(String[] args) {

		System.out.println(VERSION + "\n");

		if (args.length == 0) {
			printUsages();
			return;
		}

		CommandLineParser parser = new CommandLineParser(args);

		if (parser.arguments.containsKey("-help")) {
			printUsages();
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
				printUsages();
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