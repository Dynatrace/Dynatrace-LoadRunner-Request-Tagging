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

	public final static String C_FUNCTION = CRLF_OS_INDEPENDENT + "void addDynatraceHeaderTest(char* header){"
			+ CRLF_OS_INDEPENDENT + "	char* headerValue;" + CRLF_OS_INDEPENDENT + "	int headerValueLength;"
			+ CRLF_OS_INDEPENDENT + "	int vuserid, scid;" + CRLF_OS_INDEPENDENT + "	char *groupid, *timestamp;"
			+ CRLF_OS_INDEPENDENT + "	char* vuserstring=(char*) malloc(sizeof(char) * 10);" + CRLF_OS_INDEPENDENT
			+ "	char* ltnString=(char*) malloc(sizeof(char) * 10);" + CRLF_OS_INDEPENDENT + CRLF_OS_INDEPENDENT
			+ "	if(lr_get_attrib_string(\"DynatraceLTN\")!=NULL){" + CRLF_OS_INDEPENDENT
			+ "		strcpy(ltnString,lr_get_attrib_string(\"DynatraceLTN\"));" + CRLF_OS_INDEPENDENT + "	}"
			+ CRLF_OS_INDEPENDENT + "	lr_whoami(&vuserid, &groupid, &scid);" + CRLF_OS_INDEPENDENT
			+ "	itoa(vuserid,vuserstring,10);" + CRLF_OS_INDEPENDENT + CRLF_OS_INDEPENDENT
			+ "	headerValueLength = strlen(header) + 4 + strlen(vuserstring) + 4 + strlen(ltnString) + 4;"
			+ CRLF_OS_INDEPENDENT + "	headerValue = (char*) malloc(sizeof(char) * headerValueLength);"
			+ CRLF_OS_INDEPENDENT + "	strcpy(headerValue, header);" + CRLF_OS_INDEPENDENT
			+ "	if(lr_get_attrib_string(\"DynatraceLTN\")!=NULL){" + CRLF_OS_INDEPENDENT
			+ "		strcat(headerValue,\"LTN=\");" + CRLF_OS_INDEPENDENT + "		strcat(headerValue,ltnString);"
			+ CRLF_OS_INDEPENDENT + "		strcat(headerValue,\";\");" + CRLF_OS_INDEPENDENT + "	}"
			+ CRLF_OS_INDEPENDENT + "	strcat(headerValue,\"VU=\");" + CRLF_OS_INDEPENDENT
			+ "	strcat(headerValue,vuserstring);" + CRLF_OS_INDEPENDENT + "	strcat(headerValue,\";\");"
			+ CRLF_OS_INDEPENDENT + CRLF_OS_INDEPENDENT + "	web_add_header(\"X-dynaTrace-Test\", headerValue);"
			+ CRLF_OS_INDEPENDENT + "	free(headerValue);" + CRLF_OS_INDEPENDENT + "	free(vuserstring);"
			+ CRLF_OS_INDEPENDENT + "}" + CRLF_OS_INDEPENDENT;

	public static String[] C_KEYWORDS = new String[] {
			// Click&Script Commands
			"web_browser", "web_button", "web_check_box", "web_edit_field", "web_element", "web_file", "web_image_link",
			"web_image_submit", "web_list", "web_map_area", "web_radio_group", "web_reg_dialog", "web_static_image",
			"web_table", "web_text_area", "web_text_link",
			// Other Commands
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

	public static String JS_FUNCTION = "function addDynatraceHeaderTest(headerString) {" + CRLF_OS_INDEPENDENT
			+ "	result = lr.whoami();" + CRLF_OS_INDEPENDENT + "	var vuserID = \"VU=\"+result[0];"
			+ CRLF_OS_INDEPENDENT + "	var header = headerString;" + CRLF_OS_INDEPENDENT
			+ "	var LTN = lr.getAttribString(\"DynatraceLTN\");" + CRLF_OS_INDEPENDENT + "	if(LTN){"
			+ CRLF_OS_INDEPENDENT + "		header+= \"LTN=\"+LTN+\";\";" + CRLF_OS_INDEPENDENT + "	}"
			+ CRLF_OS_INDEPENDENT + "	header += vuserID+';'" + CRLF_OS_INDEPENDENT
			+ "	web.addHeader(\"X-dynaTrace-Test\",header)" + CRLF_OS_INDEPENDENT + "}";

	public static String[] JS_KEYWORDS = new String[] { "web.url", "web.customRequest", "web.submitData" };
	public static String[] JS_CLICK_AND_SCRIPT_KEYWORDS = new String[] { "web.image", "web.link", };
}
