package com.dynatrace.loadrunner.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArgumentTest {

	@Test
	public void byName() {
		assertEquals(Argument.INSERT, Argument.byName(Argument.INSERT.getName()));
		assertEquals(Argument.DELETE, Argument.byName("delete"));
		assertEquals(Argument.DELETE, Argument.byName("Delete"));
		assertEquals(Argument.DELETE, Argument.byName(" DeLeTe "));
	}
}