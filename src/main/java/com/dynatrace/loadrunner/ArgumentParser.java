package com.dynatrace.loadrunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dynatrace.loadrunner.UserConfig.Mode;
import com.dynatrace.loadrunner.UserConfig.Technology;

public class ArgumentParser {

	private final static List<String> ARGUMENTS_WITHOUT_VALUE = Arrays.asList("insert", "delete", "-js", "-c", "-help");
	private final static List<String> ARGUMENTS_WITH_VALUE = Arrays.asList("-lsn", "-body", "-header", "-path");

	private ArgumentParser() {
	}

	public static UserConfig getConfig(String[] arguments) {
		Map<String, String> argumentsMap = parseArguments(arguments);
		validateSyntax(argumentsMap);
		UserConfig userConfig = new UserConfig();
		for (Entry<String, String> pair : argumentsMap.entrySet()) {
			System.out.println(pair.getKey());
			switch (pair.getKey().toLowerCase()) {
			case "insert":
				userConfig.setMode(Mode.INSERT);
				break;
			case "delete":
				userConfig.setMode(Mode.DELETE);
				break;
			case "-lsn":
				userConfig.setLsn(pair.getValue());
				break;
			case "-js":
				userConfig.setTechnology(Technology.JS);
				break;
			case "-c":
				userConfig.setTechnology(Technology.C);
				break;
			case "-body":
				userConfig.setBody(pair.getValue().split("&"));
				break;
			case "-header":
				userConfig.setHeader(pair.getValue().split("&"));
				break;
			case "-path":
				userConfig.setPath(pair.getValue());
				break;
			}
		}
		return userConfig;
	}

	private static Map<String, String> parseArguments(String[] argumentsArray) throws IllegalArgumentException {
		List<String> argumentsList = Arrays.asList(argumentsArray);
		Map<String, String> argumentsMap = new HashMap<>();
		Iterator<String> iterator = argumentsList.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next().toLowerCase();
			if (!ARGUMENTS_WITHOUT_VALUE.contains(key)) {
				if (!ARGUMENTS_WITH_VALUE.contains(key)) {
					throw new IllegalArgumentException("Unknown parameter: " + key);
				} else {
					String value = iterator.next().toLowerCase();
					if (ARGUMENTS_WITHOUT_VALUE.contains(value) || ARGUMENTS_WITH_VALUE.contains(value)) {
						throw new IllegalArgumentException(
								value + " is a keyword, thus it cannot be a value for key " + key);
					} else {
						argumentsMap.put(key, value);
					}
				}
			} else {
				argumentsMap.put(key, null);
			}
		}
		return argumentsMap;
	}

	private static void validateSyntax(Map<String, String> argumentsMap) throws IllegalArgumentException {
		if (argumentsMap.isEmpty()) {
			throw new IllegalArgumentException("Arguments cannot be empty");
		}
		if ((argumentsMap.containsKey("insert") && argumentsMap.containsKey("delete"))
				|| (!argumentsMap.containsKey("insert") && (!argumentsMap.containsKey("delete")))) {
			throw new IllegalArgumentException("<mode> should contain either insert or delete");
		}
		if (argumentsMap.containsKey("-path")
				&& (argumentsMap.containsKey("-body") || argumentsMap.containsKey("-headers"))) {
			throw new IllegalArgumentException("<path parameter> should contain either -path or -body && -header");
		}
		if (argumentsMap.containsKey("-js") && argumentsMap.containsKey("-c")) {
			throw new IllegalArgumentException("<optional parameter> should not contain both -c and -js arguments");
		}
	}

}
