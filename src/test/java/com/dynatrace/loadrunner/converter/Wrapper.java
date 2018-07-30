package com.dynatrace.loadrunner.converter;

import java.nio.file.Path;

public class Wrapper {
	private Path body;
	private Path header;

	public Wrapper(Path body, Path header) {
		this.body = body;
		this.header = header;
	}

	public Path getBody() {
		return body;
	}

	public Path getHeader() {
		return header;
	}
}
