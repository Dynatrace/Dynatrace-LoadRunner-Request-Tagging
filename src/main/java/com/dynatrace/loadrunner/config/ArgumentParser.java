package com.dynatrace.loadrunner.config;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ArgumentParser {

	private ArgumentParser() {
	}

	/**
	 * Parse all the arguments passed during program execution and perform initial validation
	 *
	 * @param argumentsArray program arguments passed on execution
	 * @return parsed arguments map with their values if required, and null value otherwise
	 * @throws IllegalArgumentException in case when argument is unrecognized
	 */
	public static Map<Argument, String> parse(String[] argumentsArray) {
		Map<Argument, String> arguments = new EnumMap<>(Argument.class);
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

	/**
	 * Validates all the arguments parsed by parse() method:</br>
	 * <ul>
	 * <li>check if there are any argument provided</li>
	 * <li>check if required arguments are provided</li>
	 * <li>check if there aren't any arguments in conflict</li>
	 * <li>check if there are values provided for arguments that require them</li>
	 * </ul>
	 *
	 * @param arguments arguments to validate
	 * @throws IllegalArgumentException in case when the validation fails
	 */
	public static void validate(Map<Argument, String> arguments) {
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
