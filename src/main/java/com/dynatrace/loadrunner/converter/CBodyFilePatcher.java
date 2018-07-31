package com.dynatrace.loadrunner.converter;

import java.util.Set;

import com.dynatrace.loadrunner.config.Mode;
import com.google.common.collect.Sets;

final class CBodyFilePatcher extends AbstractBodyFilePatcher {

	private static final char C_PARAM = '"';
	private static final String C_REGEX = "\\s*\\(\\s*([\"']).*\\1\\s*\\);";
	private static final String C_TRANSACTION_START = "lr_start_transaction";
	private static final String C_TRANSACTION_END = "lr_end_transaction";

	// TODO check if we need them both almost identical, or should we separate their purpose clearly
	private static final Set<String> C_KEYWORDS = Sets.newHashSet(
			"web_browser", "web_button", "web_check_box", "web_edit_field", "web_element",
			"web_file", "web_image_link", "web_image_submit", "web_list", "web_map_area", "web_radio_group",
			"web_reg_dialog", "web_static_image", "web_table", "web_text_area", "web_text_link", "web_url",
			"web_link", "web_image", "web_submit_form", "web_submit_data", "web_custom_request");
	private static final Set<String> C_CLICK_AND_SCRIPT_KEYWORDS = Sets.newHashSet(
			"web_browser", "web_button", "web_check_box", "web_edit_field", "web_element",
			"web_file", "web_image_link", "web_image_submit", "web_list", "web_map_area", "web_radio_group",
			"web_reg_dialog", "web_static_image", "web_table", "web_text_area", "web_text_link");

	CBodyFilePatcher(Mode mode, String scriptName) {
		super(mode, scriptName);
	}

	protected void initialize() {
		regex = header + C_REGEX;
		transactionStart = C_TRANSACTION_START;
		transactionEnd = C_TRANSACTION_END;
		param = C_PARAM;
		keywords = C_KEYWORDS;
		clickAndScript = C_CLICK_AND_SCRIPT_KEYWORDS;
	}
}
