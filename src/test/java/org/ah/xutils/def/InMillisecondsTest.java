package org.ah.xutils.def;

import org.junit.Test;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;
import static org.junit.Assert.assertEquals;

public class InMillisecondsTest {
	@Test
	public void testDays() {
		assertEquals(4 * 24 * 60 * 60 * 1000, days(4));
	}

	@Test
	public void testHours() {
		assertEquals(12 * 60 * 60 * 1000, hours(12));
	}

	@Test
	public void testMinutes() {
		assertEquals(23 * 60 * 1000, minutes(23));
	}

	@Test
	public void testSeconds() {
		assertEquals(18 * 1000, seconds(18));
	}
}
