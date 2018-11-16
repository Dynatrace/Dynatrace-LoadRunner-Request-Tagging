package com.dynatrace.loadrunner.config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class UserConfigTest {

	@Test
	public void testSplit() {
		assertNull(UserConfig.split(null));
		assertNull(UserConfig.split(""));
		assertNull(UserConfig.split(" "));
		assertArrayEquals(new String[] { "a", "b", "c_d" }, UserConfig.split("a&b&c_d"));
	}

	@Test
	public void testFrom() {
		Map<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.DELETE, null);
		arguments.put(Argument.TYPE_JS, null);
		arguments.put(Argument.SCRIPT_NAME, "scriptName");
		arguments.put(Argument.PATH, "somePath");
		arguments.put(Argument.VERBOSE, null);

		UserConfig userConfig = UserConfig.from(arguments);

		assertEquals(Mode.DELETE, userConfig.getMode());
		assertEquals(Technology.JS, userConfig.getTechnology());
		assertEquals("scriptName", userConfig.getLsn());
		assertEquals("somePath", userConfig.getPath());
		assertNull(userConfig.getBody());
		assertNull(userConfig.getHeader());
		assertTrue(userConfig.isVerbose());
	}
}