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

	private ArgumentParser() {
	}

	public static UserConfig getConfig(String[] arguments) {

		Technology technology = Technology.C;
		Mode mode = null;
		String[] bodies = null;
		String[] headers = null;
		String lsn = null;
		String path = null;

		Map<Argument, String> argumentsMap = parse(arguments);
		validate(argumentsMap);

		for (Entry<Argument, String> pair : argumentsMap.entrySet()) {
			switch (pair.getKey()) {
			case INSERT:
				mode = Mode.INSERT;
				break;
			case DELETE:
				mode = Mode.DELETE;
				break;
			case LSN:
				lsn = pair.getValue();
				break;
			case TYPE_JS:
				technology = Technology.JS;
				break;
			case TYPE_C:
				technology = Technology.C;
				break;
			case BODY:
				bodies = pair.getValue().split("&");
				break;
			case HEADER:
				headers = pair.getValue().split("&");
				break;
			case PATH:
				path = pair.getValue();
				break;
			case HELP:
				break;
			}
		}

		UserConfig userConfig = new UserConfig(mode, technology, path, bodies, headers, lsn);
		System.out.println(userConfig.toString());
		return userConfig;
	}

	private static Map<Argument, String> parse(String[] argumentsArray) {
		List<String> argumentsList = Arrays.asList(argumentsArray);
		Map<Argument, String> argumentsMap = new HashMap<>();
		Iterator<String> iterator = argumentsList.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next().toLowerCase();
			Argument argument = getEnumValue(key);
			if (argument == null) {
				throw new IllegalArgumentException("Unknown parameter: " + key);
			} else {
				if (argument.isValueRequired() && iterator.hasNext()) {
					argumentsMap.put(argument, iterator.next());
				} else {
					argumentsMap.put(argument, null);
				}
			}
		}
		return argumentsMap;
	}

	private static Argument getEnumValue(String name) {
		for (Argument argument : Argument.values()) {
			if (argument.getName().equals(name)) {
				return argument;
			}
		}
		return null;
	}

	private static void validate(Map<Argument, String> argumentsMap) throws IllegalArgumentException {
		if (argumentsMap.isEmpty()) {
			throw new IllegalArgumentException("Parameters are empty");
		}
		if ((argumentsMap.containsKey(Argument.INSERT) == argumentsMap.containsKey(Argument.DELETE))
				|| (!argumentsMap.containsKey(Argument.INSERT) && !argumentsMap.containsKey(Argument.DELETE))) {
			throw new IllegalArgumentException("<mode> should contain either insert or delete");
		}
		if ((argumentsMap.containsKey(Argument.PATH) == (argumentsMap.containsKey(Argument.BODY)
				|| argumentsMap.containsKey(Argument.HEADER)))
				|| (!argumentsMap.containsKey(Argument.PATH) == (!argumentsMap
						.containsKey(Argument.BODY) == !argumentsMap.containsKey(Argument.HEADER)))) {
			throw new IllegalArgumentException("<path parameter> should contain either path or body and header");
		}
		if (argumentsMap.containsKey(Argument.TYPE_C) && argumentsMap.containsKey(Argument.TYPE_JS)) {
			throw new IllegalArgumentException("<optional parameter> should contain either -js or -c");
		}
	}

}
