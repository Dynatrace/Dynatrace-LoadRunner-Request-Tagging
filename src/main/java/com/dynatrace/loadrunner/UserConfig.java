package com.dynatrace.loadrunner;

import java.util.Arrays;

public class UserConfig {

	public enum Technology {
		C, JS
	};

	public enum Mode {
		INSERT, DELETE
	};

	private Mode mode;
	private Technology technology;
	private String path;
	private String[] body;
	private String[] header;
	private String lsn;

	public UserConfig() {
		technology = Technology.C;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String[] getBody() {
		return body;
	}

	public void setBody(String[] body) {
		this.body = body;
	}

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}

	public String getLsn() {
		return lsn;
	}

	public void setLsn(String lsn) {
		this.lsn = lsn;
	}

	@Override
	public String toString() {
		return "UserConfig [mode=" + mode + ", technology=" + technology + ", path=" + path + ", body="
				+ Arrays.toString(body) + ", header=" + Arrays.toString(header) + ", lsn=" + lsn + "]";
	}

}
