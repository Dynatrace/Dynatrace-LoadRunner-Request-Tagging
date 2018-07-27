package com.dynatrace.loadrunner;

import java.util.Set;

public enum Mode {
	INSERT(Argument.INSERT), DELETE(Argument.DELETE);

	private final Argument sourceArgument;

	private Mode(Argument sourceArgument) {
		this.sourceArgument = sourceArgument;
	}

	public Argument getSourceArgument() {
		return sourceArgument;
	}

	static Mode byArgument(Argument argument) {
		for (Mode m : values()) {
			if (m.getSourceArgument().equals(argument)) {
				return m;
			}
		}
		return null;
	}

	public static Mode from(Set<Argument> argumentKeys) {
		for (Argument argument : argumentKeys) {
			Mode mode = byArgument(argument);
			if (mode != null) {
				return mode;
			}
		}
		throw new IllegalStateException("Invalid program arguments");
	}
}
