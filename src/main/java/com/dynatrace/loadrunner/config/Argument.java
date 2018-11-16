package com.dynatrace.loadrunner.config;

public enum Argument {

	INSERT("insert"),
	DELETE("delete"),
	TYPE_JS("-js"),
	TYPE_C("-c"),
	VERBOSE("-verbose"),
	HELP("-help"),
	SCRIPT_NAME("-lsn", true),
	BODY("-body", true),
	HEADER("-header", true),
	PATH("-path", true);

	private final String name;
	private final boolean valueRequired;

	Argument(String name, boolean valueRequired) {
		this.name = name;
		this.valueRequired = valueRequired;
	}

	Argument(String name) {
		this(name, false);
	}

	public String getName() {
		return name;
	}

	public boolean isValueRequired() {
		return valueRequired;
	}

	public static Argument byName(String name) {
		for (Argument argument : values()) {
			if (argument.getName().trim().equalsIgnoreCase(name.trim())) {
				return argument;
			}
		}
		return null;
	}

}
