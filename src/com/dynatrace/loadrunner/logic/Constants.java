package com.dynatrace.loadrunner.logic;

public class Constants {
	public final static String ADD_HEADER_FUNCTION="addDynaTraceHeader";

	public static final String CRLF_OS_INDEPENDENT = "\r\n";

	public final static String DT_FUNCTION = CRLF_OS_INDEPENDENT + "void addDynaTraceHeader(char* header){" + CRLF_OS_INDEPENDENT
		+ "	char* headerValue;" + CRLF_OS_INDEPENDENT
		+ "	int headerValueLength;" + CRLF_OS_INDEPENDENT
		+ "	int vuserid, scid;" + CRLF_OS_INDEPENDENT
		+ "	char *groupid, *timestamp;" + CRLF_OS_INDEPENDENT
		+ "	char* vuserstring=(char*) malloc(sizeof(char) * 10);" + CRLF_OS_INDEPENDENT + CRLF_OS_INDEPENDENT
		+ "	web_save_timestamp_param(\"TimeStamp\", LAST);" + CRLF_OS_INDEPENDENT
		+ "	timestamp=lr_eval_string(\"{TimeStamp}\");" + CRLF_OS_INDEPENDENT + CRLF_OS_INDEPENDENT
		+ "	lr_whoami(&vuserid, &groupid, &scid);" + CRLF_OS_INDEPENDENT
		+ "	itoa(vuserid,vuserstring,10);" + CRLF_OS_INDEPENDENT + CRLF_OS_INDEPENDENT
		+ "	headerValueLength = strlen(header) + 4 + strlen(vuserstring) + 4 + strlen(timestamp) + 1;" + CRLF_OS_INDEPENDENT
		+ "	headerValue = (char*) malloc(sizeof(char) * headerValueLength);" + CRLF_OS_INDEPENDENT
		+ "	strcpy(headerValue, header);" + CRLF_OS_INDEPENDENT
		+ "	strcat(headerValue,\";VU=\");" + CRLF_OS_INDEPENDENT
		+ "	strcat(headerValue,vuserstring);" + CRLF_OS_INDEPENDENT
		+ "	strcat(headerValue,\";ID=\");" + CRLF_OS_INDEPENDENT
		+ "	strcat(headerValue,timestamp);" + CRLF_OS_INDEPENDENT + CRLF_OS_INDEPENDENT
		+ "	web_add_header(\"X-dynaTrace\", headerValue);" + CRLF_OS_INDEPENDENT
		+ "	free(headerValue);" + CRLF_OS_INDEPENDENT
		+ "	free(vuserstring);" + CRLF_OS_INDEPENDENT
		+ "}" + CRLF_OS_INDEPENDENT;
	public static String[] KEYWORDS = new String[] {
		//Click&Script Commands
		"web_browser","web_button","web_check_box",
		"web_edit_field","web_element","web_file","web_image_link",
		"web_image_submit","web_list","web_map_area","web_radio_group",
		"web_reg_dialog","web_static_image","web_table","web_text_area",
		"web_text_link",
		//Other Commands
		"web_url", "web_link",
		"web_image", "web_submit_form", "web_submit_data",
		"web_custom_request",
	};
	public static String[] CLICK_AND_SCRIPT_KEYWORDS=new String[] {"web_browser",
		"web_button","web_check_box","web_edit_field","web_element",
		"web_file","web_image_link","web_image_submit","web_list","web_map_area",
		"web_radio_group","web_reg_dialog","web_static_image","web_table",
		"web_text_area","web_text_link"
	};

	public static final String WAS_NOT_ABLE_TO_RESTORE = "Was not able to restore the backup file ";
	public static final String COULD_NOT_FIND_THE_FILE = "Could not find the file ";
	public static final String THE_FILE_IS_ALREADY_MODIFIED = "The file is already modified ";
	
}
