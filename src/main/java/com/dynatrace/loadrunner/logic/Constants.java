package com.dynatrace.loadrunner.logic;

public class Constants {
	public final static String ADD_HEADER = "addDynatraceHeaderTest";

	public final static String INCLUDE = "#include";
	public final static String TMP = ".tmp";
	public final static String C_REGEX = "\\s*\\(\\s*([\"']).*\\1\\s*\\);";
	public final static String C_TRANS_START = "lr_start_transaction";
	public final static String C_TRANS_END = "lr_end_transaction";
	public final static char C_PARAM = '"';

	public static final String CRLF_OS_INDEPENDENT = "\r\n";

	public static String[] C_KEYWORDS = new String[] {
			"web_browser", "web_button", "web_check_box", "web_edit_field", "web_element", "web_file", "web_image_link",
			"web_image_submit", "web_list", "web_map_area", "web_radio_group", "web_reg_dialog", "web_static_image",
			"web_table", "web_text_area", "web_text_link",
			"web_url", "web_link", "web_image", "web_submit_form", "web_submit_data", "web_custom_request", };
	public static String[] CLICK_AND_SCRIPT_KEYWORDS = new String[] { "web_browser", "web_button", "web_check_box",
			"web_edit_field", "web_element", "web_file", "web_image_link", "web_image_submit", "web_list",
			"web_map_area", "web_radio_group", "web_reg_dialog", "web_static_image", "web_table", "web_text_area",
			"web_text_link" };

	public static final String WAS_NOT_ABLE_TO_RESTORE = "Was not able to restore the backup file ";
	public static final String COULD_NOT_FIND_THE_FILE = "Could not find the file ";
	public static final String THE_FILE_IS_ALREADY_MODIFIED = "The file is already modified ";

	public static final String JS_REGEX = "\\(\".*\"\\);";
	public static final String JS_TRANS_START = "lr.startTransaction";
	public static final String JS_TRANS_END = "lr.endTransaction";
	public static final char JS_PARAM = '\'';

	public static String[] JS_KEYWORDS = new String[] { "web.url", "web.customRequest", "web.submitData" };
	public static String[] JS_CLICK_AND_SCRIPT_KEYWORDS = new String[] { "web.image", "web.link", };
}
