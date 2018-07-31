package com.dynatrace.loadrunner.converter.util;

import java.io.File;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import com.dynatrace.loadrunner.config.InputFiles;
import com.dynatrace.loadrunner.config.Technology;
import com.google.common.collect.Sets;

public class FileReaderUtil {

	private static final String USR_FILE_EXT = "usr";
	private static final String C_BODY_FILE_EXT = "c";
	private static final String C_GLOBALS_FILE = "globals.h";
	private static final String JS_BODY_FILE_EXT = "js";
	private static final String JS_GLOBALS_FILE = "globals.js";

	private FileReaderUtil() {
		// prevent creation
	}

	private static String getFileExtension(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}

	public static InputFiles findInputFiles(final File folder, Technology technology) {
		Set<File> allFiles = Sets.newHashSet();
		findFilesRecursive(folder, allFiles);
		Collection<File> headerFiles = filterHeaderFiles(allFiles, technology);
		Collection<File> bodyFiles = filterBodyFiles(allFiles, technology);

		return new InputFiles(headerFiles, bodyFiles, getScriptNameFromPath(allFiles));
	}

	private static String getScriptNameFromPath(final Collection<File> allFiles) {
		for (File file : allFiles) {
			if (USR_FILE_EXT.equals(getFileExtension(file.getName()))) {
				return file.getName().replaceFirst("[.][^.]+$", "");
			}
		}
		return null;
	}

	private static void findFilesRecursive(final File file, Set<File> output) {
		if (!file.exists()) {
			return;
		}
		if (file.isDirectory()) {
			for (final File subFile : Objects.requireNonNull(file.listFiles())) {
				findFilesRecursive(subFile, output);
			}
		} else {
			output.add(file);
		}
	}

	public static Collection<File> getHeaderFiles(String[] input, Technology technology) {
		return filterHeaderFiles(getFiles(input), technology);
	}

	public static Collection<File> getBodyFiles(String[] input, Technology technology) {
		return filterBodyFiles(getFiles(input), technology);
	}

	private static Collection<File> getFiles(String[] input) {
		Set<File> output = Sets.newHashSet();
		for (String inputFile : input) {
			File file = new File(inputFile);
			if (file.exists()) {
				output.add(file);
			}
		}
		return output;
	}

	private static Collection<File> filterHeaderFiles(Collection<File> input, Technology technology) {
		switch (technology) {
		case C:
			return filterHeaderFiles(input, C_GLOBALS_FILE);
		case JS:
			return filterHeaderFiles(input, JS_GLOBALS_FILE);
		default:
			return Sets.newHashSet();
		}
	}

	private static Collection<File> filterHeaderFiles(Collection<File> input, String globalsFileName) {
		Set<File> output = Sets.newHashSet();
		for (File file : input) {
			String fileName = file.getName();
			if (globalsFileName.equals(fileName)) {
				output.add(file);
			}
		}
		return output;
	}

	private static Collection<File> filterBodyFiles(Collection<File> input, Technology technology) {
		switch (technology) {
		case C:
			return filterBodyFiles(input, C_BODY_FILE_EXT);
		case JS:
			return filterBodyFiles(input, JS_BODY_FILE_EXT);
		default:
			return Sets.newHashSet();
		}
	}

	private static Collection<File> filterBodyFiles(Collection<File> input, String fileExt) {
		Set<File> output = Sets.newHashSet();
		for (File file : input) {
			String fileName = file.getName();
			if (fileExt.equals(getFileExtension(fileName))) {
				output.add(file);
			}
		}
		return output;
	}
}
