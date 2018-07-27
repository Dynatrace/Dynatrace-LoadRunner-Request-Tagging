package com.dynatrace.loadrunner;

enum Argument {

	INSERT("insert"),
	DELETE("delete"),
	TYPE_JS("-js"),
	TYPE_C("-c"),
	HELP("-help"),
	SCRIPT_NAME("-lsn", true),
	BODY("-body", true),
	HEADER("-header", true),
	PATH("-path", true);

	private final String name;
	private final boolean valueRequired;

	private Argument(String name, boolean valueRequired) {
		this.name = name;
		this.valueRequired = valueRequired;
	}

	private Argument(String name) {
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
			if (argument.getName().trim().toLowerCase().equals(name.trim().toLowerCase())) {
				return argument;
			}
		}
		return null;
	}

}
