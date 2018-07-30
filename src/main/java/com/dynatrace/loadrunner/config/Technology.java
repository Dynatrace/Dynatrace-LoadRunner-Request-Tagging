package com.dynatrace.loadrunner.config;

import java.util.Set;

public enum Technology {
	C(Argument.TYPE_C), JS(Argument.TYPE_JS);

	private final Argument sourceArgument;

	private Technology(Argument sourceArgument) {
		this.sourceArgument = sourceArgument;
	}

	public Argument getSourceArgument() {
		return sourceArgument;
	}

	static Technology byArgument(Argument argument) {
		for (Technology t : values()) {
			if (t.getSourceArgument().equals(argument)) {
				return t;
			}
		}
		return null;
	}

	public static Technology from(Set<Argument> argumentKeys) {
		for (Argument argument : argumentKeys) {
			Technology technology = byArgument(argument);
			if (technology != null) {
				return technology;
			}
		}
		return Technology.C;
	}
}
