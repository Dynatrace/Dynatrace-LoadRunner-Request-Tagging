package com.dynatrace.loadrunner.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.Test;

import com.google.common.collect.Sets;

public class ModeTest {

	@Test
	public void byArgument() {
		assertEquals(Mode.INSERT, Mode.byArgument(Argument.INSERT));
		assertEquals(Mode.DELETE, Mode.byArgument(Argument.DELETE));
		assertNull(Mode.byArgument(Argument.PATH));
	}

	@Test
	public void testFrom() {
		try {
			Mode.from(new HashSet<>());
			fail();
		} catch (IllegalStateException e) {
			assertTrue(true);
		}
		assertEquals(Mode.INSERT, Mode.from(Sets.newHashSet(Argument.INSERT)));
		assertEquals(Mode.DELETE, Mode.from(Sets.newHashSet(Argument.DELETE)));
		// in following case we're not sure about the result, so the validation should be done elsewhere
		Mode mode = Mode.from(Sets.newHashSet(Argument.INSERT, Argument.DELETE));
		assertTrue(Mode.INSERT.equals(mode) || Mode.DELETE.equals(mode));
	}

}