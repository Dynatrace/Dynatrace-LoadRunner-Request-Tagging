package com.dynatrace.loadrunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

class ArgumentParser {

	private ArgumentParser() {
	}

	static Map<Argument, String> parse(String[] argumentsArray) {
		Map<Argument, String> arguments = new HashMap<>();
		Iterator<String> iterator = Arrays.asList(argumentsArray).iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (StringUtils.isBlank(key)) {
				continue;
			}
			Argument argument = Argument.byName(key);
			if (argument == null) {
				throw new IllegalArgumentException("Unknown parameter: '" + key + "'");
			}
			if (argument.isValueRequired() && iterator.hasNext()) {
				arguments.put(argument, iterator.next());
			} else {
				arguments.put(argument, null);
			}
		}
		return arguments;
	}

	static void validate(Map<Argument, String> arguments) throws IllegalArgumentException {
		if (arguments.isEmpty()) {
			throw new IllegalArgumentException("Parameters are empty");
		}
		if (!arguments.containsKey(Argument.INSERT) && !arguments.containsKey(Argument.DELETE)) {
			throw new IllegalArgumentException("<mode> needs to be specified");
		}
		if (arguments.containsKey(Argument.INSERT) == arguments.containsKey(Argument.DELETE)) {
			throw new IllegalArgumentException("<mode> should contain either '" + Argument.INSERT.getName() + "' or '"
					+ Argument.DELETE.getName() + "'");
		}
		if (arguments.containsKey(
				Argument.PATH) == (arguments.containsKey(Argument.BODY) || arguments.containsKey(Argument.HEADER))
				|| arguments.containsKey(Argument.BODY) != arguments.containsKey(Argument.HEADER)) {
			throw new IllegalArgumentException("<path parameter> should contain either '" + Argument.PATH.getName()
					+ "' or '" + Argument.BODY.getName() + "' and '" + Argument.HEADER.getName() + "'");
		}
		if (arguments.containsKey(Argument.TYPE_C) && arguments.containsKey(Argument.TYPE_JS)) {
			throw new IllegalArgumentException("<optional parameter> should contain either '"
					+ Argument.TYPE_JS.getName() + "' or '" + Argument.TYPE_C.getName() + "'");
		}
		for (Map.Entry<Argument, String> argumentEntry : arguments.entrySet()) {
			Argument key = argumentEntry.getKey();
			if (key.isValueRequired() && StringUtils.isBlank(argumentEntry.getValue())) {
				throw new IllegalArgumentException("Parameter '" + key.getName() + "' requires value");
			}
		}

	}

}
