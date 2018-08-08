package com.dynatrace.loadrunner.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class ArgumentParserTest {

	private static final String VALIDATE_PATH_ERROR_MESSAGE = "<path parameter> should contain either '-path' or '-body' and '-header'";

	@Test
	public void parse_empty() {
		Map<Argument, String> parsed = ArgumentParser.parse(new String[0]);
		assertNotNull(parsed);
		assertTrue(parsed.isEmpty());
	}

	@Test
	public void parse_blank() {
		Map<Argument, String> parsed = ArgumentParser.parse(new String[] { "" });
		assertNotNull(parsed);
		assertTrue(parsed.isEmpty());
	}

	@Test
	public void parse_invalid() {
		try {
			ArgumentParser.parse(new String[] { "someInvalidParameter" });
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unknown parameter: 'someInvalidParameter'", e.getMessage());
		}
	}

	@Test
	public void parse() {
		Map<Argument, String> parsed = ArgumentParser
				.parse(new String[] { Argument.INSERT.getName(), Argument.PATH.getName(), "somePath" });
		assertTrue(parsed.containsKey(Argument.INSERT));
		assertNull(parsed.get(Argument.INSERT));
		assertTrue(parsed.containsKey(Argument.PATH));
		assertEquals("somePath", parsed.get(Argument.PATH));
	}

	@Test
	public void validate_emptyMap() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Parameters are empty", e.getMessage());
		}
	}

	@Test
	public void validate_noModeSpecified() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.PATH, "somePath");
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("<mode> needs to be specified", e.getMessage());
		}
	}

	@Test
	public void validate_bothModesSpecified() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.DELETE, null);
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("<mode> should contain either 'insert' or 'delete'", e.getMessage());
		}
	}

	@Test
	public void validate_pathAndBodySpecified() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.PATH, null);
		arguments.put(Argument.BODY, null);
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(VALIDATE_PATH_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void validate_pathAndHeaderSpecified() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.PATH, null);
		arguments.put(Argument.HEADER, null);
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(VALIDATE_PATH_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void validate_pathAndBodyAndHeaderSpecified() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.PATH, null);
		arguments.put(Argument.BODY, null);
		arguments.put(Argument.HEADER, null);
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(VALIDATE_PATH_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void validate_bodyWithoutHeader() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.BODY, null);
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(VALIDATE_PATH_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void validate_bothTechTypesSpecified() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.PATH, null);
		arguments.put(Argument.TYPE_C, null);
		arguments.put(Argument.TYPE_JS, null);
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("<optional parameter> should contain either '-js' or '-c'", e.getMessage());
		}
	}

	@Test
	public void validate_missingValue() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.PATH, null);
		arguments.put(Argument.TYPE_C, null);
		try {
			ArgumentParser.validate(arguments);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Parameter '" + Argument.PATH.getName() + "' requires value", e.getMessage());
		}
	}

	@Test
	public void validate_success() {
		HashMap<Argument, String> arguments = Maps.newHashMap();
		arguments.put(Argument.INSERT, null);
		arguments.put(Argument.PATH, "somePath");
		arguments.put(Argument.TYPE_C, null);
		ArgumentParser.validate(arguments);
		assertTrue(true);
	}
}