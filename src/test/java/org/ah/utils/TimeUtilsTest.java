package org.ah.utils;

import static org.ah.def.InMilliseconds.days;
import static org.ah.def.InMilliseconds.hours;
import static org.ah.def.InMilliseconds.minutes;
import static org.ah.def.InMilliseconds.seconds;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.ah.def.TimeSpan;
import org.ah.xutils.TimeUtils;
import org.junit.Test;

public class TimeUtilsTest {
	@Test
	public void test1() {
		long start = System.currentTimeMillis();
		long end = start + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("Wrong value for seconds: " + ts.getSeconds(), 5, ts.getSeconds());
		assertEquals("Wrong value for minutes: " + ts.getMinutes(), 0, ts.getMinutes());
		assertEquals("Wrong value for hours: " + ts.getHours(), 0, ts.getHours());
		assertEquals("Wrong value for days: " + ts.getDays(), 0, ts.getDays());
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		long end = start + minutes(4);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("Wrong value for seconds: " + ts.getSeconds(), 0, ts.getSeconds());
		assertEquals("Wrong value for minutes: " + ts.getMinutes(), 4, ts.getMinutes());
		assertEquals("Wrong value for hours: " + ts.getHours(), 0, ts.getHours());
		assertEquals("Wrong value for days: " + ts.getDays(), 0, ts.getDays());
	}

	@Test
	public void test3() {
		long start = System.currentTimeMillis();
		long end = start + hours(9);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("Wrong value for seconds: " + ts.getSeconds(), 0, ts.getSeconds());
		assertEquals("Wrong value for minutes: " + ts.getMinutes(), 0, ts.getMinutes());
		assertEquals("Wrong value for hours: " + ts.getHours(), 9, ts.getHours());
		assertEquals("Wrong value for days: " + ts.getDays(), 0, ts.getDays());
	}

	@Test
	public void test4() {
		long start = System.currentTimeMillis();
		long end = start + days(2);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("Wrong value for seconds: " + ts.getSeconds(), 0, ts.getSeconds());
		assertEquals("Wrong value for minutes: " + ts.getMinutes(), 0, ts.getMinutes());
		assertEquals("Wrong value for hours: " + ts.getHours(), 0, ts.getHours());
		assertEquals("Wrong value for days: " + ts.getDays(), 2, ts.getDays());
	}

	@Test
	public void test5() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("Wrong value for seconds: " + ts.getSeconds(), 5, ts.getSeconds());
		assertEquals("Wrong value for minutes: " + ts.getMinutes(), 4, ts.getMinutes());
		assertEquals("Wrong value for hours: " + ts.getHours(), 9, ts.getHours());
		assertEquals("Wrong value for days: " + ts.getDays(), 2, ts.getDays());
	}

	@Test
	public void testEndSmallerThanStart() {
		try {
			TimeUtils.diff(seconds(5), seconds(3));
			fail("It should have thrown an IllegalArgumentException: end is smaller than start.");
		} catch (IllegalArgumentException e) {
			assertTrue("The value for 'end' is smaller than the value for 'start'.".equals(e.getMessage()));
		}
	}

	@Test
	public void testNoTimeFormat() {
		TimeSpan ts = TimeUtils.diff(0, seconds(1));
		assertEquals("", ts.format(null));
	}

	@Test
	public void testTruncateExtraMillis() {
		TimeSpan ts = TimeUtils.diff(0, seconds(3) + 520);
		assertEquals("Wrong value for seconds: " + ts.getSeconds(), 3, ts.getSeconds());
		assertEquals("Wrong value for minutes: " + ts.getMinutes(), 0, ts.getMinutes());
		assertEquals("Wrong value for hours: " + ts.getHours(), 0, ts.getHours());
		assertEquals("Wrong value for days: " + ts.getDays(), 0, ts.getDays());
	}

	@Test
	public void testZeroTimeSpan() {
		TimeSpan ts = TimeUtils.diff(days(4), days(4));
		assertEquals("Wrong value for seconds: " + ts.getSeconds(), 0, ts.getSeconds());
		assertEquals("Wrong value for minutes: " + ts.getMinutes(), 0, ts.getMinutes());
		assertEquals("Wrong value for hours: " + ts.getHours(), 0, ts.getHours());
		assertEquals("Wrong value for days: " + ts.getDays(), 0, ts.getDays());
	}
}
