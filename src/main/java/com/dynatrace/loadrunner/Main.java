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

		UserConfig userConfig = UserConfig.from(argumentsMap);
		Technology technology = userConfig.getTechnology();
		FilesConverter converter = new FilesConverter(userConfig.getMode(), technology, getInputFiles(userConfig, technology),
				userConfig.getLsn());
		converter.convert();
		System.out.println("Conversion complete");
	}

	private static InputFiles getInputFiles(UserConfig userConfig, Technology technology) {
		if (StringUtils.isBlank(userConfig.getPath())) {
			return new InputFiles(
					FileReaderUtil.getHeaderFiles(userConfig.getHeader(), technology),
					FileReaderUtil.getBodyFiles(userConfig.getBody(), technology));
		}
		return FileReaderUtil.findInputFiles(new File(userConfig.getPath()), technology);
	}

	private static void printUsage() throws IOException {
		System.out.println(ResourceFileReaderUtil.getClassResources(Main.class, ResourceFileReaderUtil.PRINT_USAGES));
	}
}