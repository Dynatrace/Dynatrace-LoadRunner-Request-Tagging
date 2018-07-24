package com.dynatrace.loadrunner;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class CommandLineParser {

	final public Map<String, String> arguments;

	public CommandLineParser(String[] args) {

		arguments = new HashMap<>();

		for (int i = 0; i < args.length; i++) {
			String key = null;
			if (args[i].startsWith("-")) {
				key = args[i].substring(1);
				if ((i + 1) < args.length) {
					if (args[i + 1].charAt(0) != '-') {
						arguments.put(key, args[i + 1]);
						i++;
					} else {
						arguments.put(args[i], null);
					}
				} else {
					arguments.put(args[i], null);
				}
			} else {
				/*
				 * If param doesn't start with '-', then we assume key doesn't have a value thus
				 * key will be put with null value, example: insert / delete params
				 */
				arguments.put(args[i], null);
				continue;
			}
		}
	}

	public String getValue(String key) {
		if (isValid(key)) {
			return arguments.get(key);
		}
		return null;
	}

	public boolean validateKey(String key) {
		return isValid(key) && arguments.containsKey(key);
	}

	private boolean isValid(String value) {
		return StringUtils.isNotBlank(value);
	}

}