package com.dynatrace.loadrunner;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dynatrace.loadrunner.config.Argument;
import com.dynatrace.loadrunner.config.ArgumentParser;
import com.dynatrace.loadrunner.config.InputFiles;
import com.dynatrace.loadrunner.config.Technology;
import com.dynatrace.loadrunner.config.UserConfig;
import com.dynatrace.loadrunner.converter.FilesConverter;
import com.dynatrace.loadrunner.converter.util.FileReaderUtil;
import com.dynatrace.loadrunner.converter.util.ResourceFileReaderUtil;

public class Main {

	public static void main(String[] args) throws IOException {
		Map<Argument, String> argumentsMap = ArgumentParser.parse(args);

		if (containsHelp(argumentsMap)) {
			printUsage();
			return;
		}

		UserConfig userConfig = null;
		try {
			if (!isValid(argumentsMap)) {
				printUsage();
				return;
			}

			userConfig = UserConfig.from(argumentsMap);
			Technology technology = userConfig.getTechnology();
			FilesConverter converter = new FilesConverter(userConfig.getMode(), technology,
					getInputFiles(userConfig, technology), userConfig.getLsn(), userConfig.isVerbose());
			converter.convert();
		} catch (UnsupportedOperationException e) {
			System.err.printf("%nUnexpected error occurred: %s%n", e.getMessage());
		} catch (Exception e) {
			if (userConfig != null && userConfig.isVerbose()) {
				System.err.println("\nUnexpected error occurred (details below)");
				e.printStackTrace();
			} else {
				System.err.printf("%nUnexpected error occurred: %s%n", e.getMessage());
			}
		}
		System.err.flush();

		System.out.println("\nConversion complete");
	}

	private static boolean containsHelp(Map<Argument, String> argumentsMap) {
		return argumentsMap.containsKey(Argument.HELP);
	}

	private static boolean isValid(Map<Argument, String> argumentsMap) {
		try {
			ArgumentParser.validate(argumentsMap);
		} catch (IllegalArgumentException e) {
			System.err.printf("%nValidation error occurred: %s%n", e.getMessage());
			return false;
		}
		return true;
	}

	private static InputFiles getInputFiles(UserConfig userConfig, Technology technology) {
		if (StringUtils.isBlank(userConfig.getPath())) {
			return new InputFiles(FileReaderUtil.getHeaderFiles(userConfig.getHeader(), technology),
					FileReaderUtil.getBodyFiles(userConfig.getBody(), technology));
		}
		return FileReaderUtil.findInputFiles(new File(userConfig.getPath()), technology);
	}

	private static void printUsage() throws IOException {
		System.out.println(ResourceFileReaderUtil.getClassResources(Main.class, ResourceFileReaderUtil.PRINT_USAGES));
	}
}
