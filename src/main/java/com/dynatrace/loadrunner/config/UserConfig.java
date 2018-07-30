package com.dynatrace.loadrunner.config;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class UserConfig {

	private final Mode mode;
	private final Technology technology;
	private final String path;
	private final String[] body;
	private final String[] header;
	private final String lsn;

	private UserConfig(Mode mode, Technology technology, String path, String[] body, String[] header, String lsn) {
		this.mode = mode;
		this.technology = technology;
		this.path = path;
		this.body = body;
		this.header = header;
		this.lsn = lsn;
	}

	public Mode getMode() {
		return mode;
	}

	public Technology getTechnology() {
		return technology;
	}

	public String getPath() {
		return path;
	}

	public String[] getBody() {
		return body;
	}

	public String[] getHeader() {
		return header;
	}

	public String getLsn() {
		return lsn;
	}

	public static UserConfig from(Map<Argument, String> arguments) {
		Mode mode = Mode.from(arguments.keySet());
		Technology technology = Technology.from(arguments.keySet());
		String scriptName = arguments.get(Argument.SCRIPT_NAME);
		String path = arguments.get(Argument.PATH);
		String[] bodies = split(arguments.get(Argument.BODY));
		String[] headers = split(arguments.get(Argument.HEADER));

		return new UserConfig(mode, technology, path, bodies, headers, scriptName);
	}

	static String[] split(String argumentValue) {
		if (StringUtils.isBlank(argumentValue)) {
			return null;
		}
		return argumentValue.split("&");
	}

}
