package com.dynatrace.loadrunner;

public class UserConfig {

	public enum Technology {
		C, JS
	};

	public enum Mode {
		INSERT, DELETE
	};

	private final Mode mode;
	private final Technology technology;
	private final String path;
	private final String[] body;
	private final String[] header;
	private final String lsn;

	public UserConfig(Mode mode, Technology technology, String path, String[] body, String[] header, String lsn) {
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

	/* return copy */
	public String[] getBody() {
		return body;
	}

	/* return copy */
	public String[] getHeader() {
		return header;
	}

	public String getLsn() {
		return lsn;
	}

}
