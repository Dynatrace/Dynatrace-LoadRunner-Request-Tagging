package com.dynatrace.loadrunner.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.google.common.collect.Sets;

public class TechnologyTest {

	@Test
	public void byArgument() {
		assertEquals(Technology.C, Technology.byArgument(Argument.TYPE_C));
		assertEquals(Technology.JS, Technology.byArgument(Argument.TYPE_JS));
		assertNull(Technology.byArgument(Argument.PATH));
	}

	@Test
	public void testFrom() {
		assertEquals(Technology.C, Technology.from(Sets.newHashSet()));
		assertEquals(Technology.JS, Technology.from(Sets.newHashSet(Argument.TYPE_JS)));
		assertEquals(Technology.C, Technology.from(Sets.newHashSet(Argument.TYPE_C)));
		assertEquals(Technology.JS, Technology.from(Sets.newHashSet(Argument.TYPE_JS, Argument.TYPE_C)));
	}
}