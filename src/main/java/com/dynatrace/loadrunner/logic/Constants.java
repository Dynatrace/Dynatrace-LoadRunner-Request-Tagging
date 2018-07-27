package com.dynatrace.loadrunner.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

public final class Constants {

	public static final String DT_HEADER = "addDynatraceHeaderTest";

	public static final String INCLUDE_KEYWORD = "#include";
	public static final String TMP_FILE_EXT = ".tmp";
	public static final String CRLF = "\r\n";

	public static final String UNABLE_TO_RESTORE_FILE = "Unable to restore the backup file ";
	public static final String FILE_NOT_FOUND = "File not found: ";

	/* C files constants */
	public static final char C_PARAM = '"';
	public static final String C_REGEX = "\\s*\\(\\s*([\"']).*\\1\\s*\\);";
	public static final String C_TRANSACTION_START = "lr_start_transaction";
	public static final String C_TRANSACTION_END = "lr_end_transaction";

	// TODO check if we need them both almost identical, or should we separate their purpose clearly
	public static final Set<String> C_KEYWORDS = Sets.newHashSet(
			"web_browser", "web_button", "web_check_box", "web_edit_field", "web_element",
			"web_file", "web_image_link", "web_image_submit", "web_list", "web_map_area", "web_radio_group",
			"web_reg_dialog", "web_static_image", "web_table", "web_text_area", "web_text_link", "web_url",
			"web_link", "web_image", "web_submit_form", "web_submit_data", "web_custom_request");
	public static final Set<String> C_CLICK_AND_SCRIPT_KEYWORDS = Sets.newHashSet(
			"web_browser", "web_button", "web_check_box", "web_edit_field", "web_element",
			"web_file", "web_image_link", "web_image_submit", "web_list", "web_map_area", "web_radio_group",
			"web_reg_dialog", "web_static_image", "web_table", "web_text_area", "web_text_link");

	/* JS files constants */
	public static final char JS_PARAM = '\'';
	public static final String JS_REGEX = "\\(\".*\"\\);";
	public static final String JS_TRANSACTION_START = "lr.startTransaction";
	public static final String JS_TRANSACTION_END = "lr.endTransaction";

	public static final Set<String> JS_KEYWORDS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("web.url", "web.customRequest", "web.submitData")));
	public static final Set<String> JS_CLICK_AND_SCRIPT_KEYWORDS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("web.image", "web.link")));
}
