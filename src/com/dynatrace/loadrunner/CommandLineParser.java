package com.dynatrace.loadrunner;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineParser {

	public HashMap<String, String> arguments;

	public CommandLineParser(String[] args) {

		arguments = new HashMap<String, String>();

		String key = null;
		String value = null;
		int index = 0;

		for (int i = 0; i < args.length; i++) {

			if (args[i].startsWith("--")) {
				key = args[i].substring(2);
			} else if (args[i].startsWith("-")) {
				key = args[i].substring(1);
			} else {
				arguments.put(args[i], null);
				continue;
			}
			index = key.indexOf('=');

			if (index == -1) {
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
				value = key.substring(index + 1);
				key = key.substring(0, index);
				arguments.put(key, value);
			}
		}
	}

	public String getValue(String key) {
		if (InputUtils.isValid(key)) {
			return arguments.get(key);
		}
		return null;
	}

	public boolean containsKey(String key) {

		if (InputUtils.isValid(key)) {

			if (arguments.get(key) != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

}

class InputUtils {

	public static boolean isValid(String value) {

		if (value == null) {
			return false;
		} else {
			value = value.trim();
			if (value.equals("") == true) {
				return false;
			}
		}

		return true;
	}

	public static boolean isValid(String value, String[] list) {

		if (isValid(value) == false) {
			return false;
		}

		boolean isValid = false;

		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(value)) {
				isValid = true;
			}
		}

		return isValid;
	}

	public static boolean isValidInt(String value) {

		if (isValid(value) == false) {
			return false;
		}
		try {
			Integer.parseInt(value);
		} catch (java.lang.NumberFormatException ex) {
			return false;
		}
		return true;

	}

	public static boolean isValidInt(int value, int minimum) {

		if (value >= minimum) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean isValidInt(int value, int minimum, int maximum) {

		if (value >= minimum && value <= maximum) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidDate(String date) {

		Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
		Matcher matcher = pattern.matcher(date);

		if (matcher.find() == true) {
			return true;
		} else {
			return false;
		}
	}

	public static String arrayToString(String[] values) {

		return java.util.Arrays.toString(values).replaceAll("[\\]\\[]", "");

	}

	public static boolean isValidArrayInt(String[] values) {

		boolean status = true;

		for (int i = 0; i < values.length; i++) {
			if (isValidInt(values[i]) == false) {
				status = false;
				i = values.length;
			}
		}
		return status;
	}
}