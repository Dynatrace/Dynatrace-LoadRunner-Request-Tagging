package com.dynatrace.loadrunner.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.dynatrace.loadrunner.config.Mode;

final class JSBodyFilePatcher extends AbstractBodyFilePatcher {

	private static final char JS_PARAM = '\'';
	private static final String JS_REGEX = "\\(\".*\"\\);";
	private static final String JS_TRANSACTION_START = "lr.startTransaction";
	private static final String JS_TRANSACTION_END = "lr.endTransaction";

	private static final Set<String> JS_KEYWORDS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("web.url", "web.customRequest", "web.submitData")));
	private static final Set<String> JS_CLICK_AND_SCRIPT_KEYWORDS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("web.image", "web.link")));

	JSBodyFilePatcher(Mode mode, String scriptName) {
		super(mode, scriptName);
	}

	protected void initialize() {
		regex = header + JS_REGEX;
		transactionStart = JS_TRANSACTION_START;
		transactionEnd = JS_TRANSACTION_END;
		param = JS_PARAM;
		keywords = JS_KEYWORDS;
		clickAndScript = JS_CLICK_AND_SCRIPT_KEYWORDS;
	}
}
