package org.ah.xutils.utils;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;
import static org.junit.Assert.assertEquals;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanShortFormatter;
import org.junit.Test;

public class TimeUtilsShortTimeSpanFormatTest {

	@Test
	public void test1() {
		long start = System.currentTimeMillis();
		long end = start + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("5 seconds", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		long end = start + minutes(3);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 minutes", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test3() {
		long start = System.currentTimeMillis();
		long end = start + minutes(3) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 minutes, 5 seconds", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test4() {
		long start = System.currentTimeMillis();
		long end = start + hours(12);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("12 hours", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test5() {
		long start = System.currentTimeMillis();
		long end = start + hours(12) + minutes(8);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("12 hours, 8 minutes", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test6() {
		long start = System.currentTimeMillis();
		long end = start + hours(12) + seconds(6);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("12 hours, 6 seconds", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test7() {
		long start = System.currentTimeMillis();
		long end = start + hours(12) + minutes(8) + seconds(2);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("12 hours, 8 minutes, 2 seconds", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test8() {
		long start = System.currentTimeMillis();
		long end = start + days(3);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days", ts.format(new TimeSpanShortFormatter()));
	}

	@Test
	public void test9() {
		long start = System.currentTimeMillis();
		long end = start + days(3) + hours(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days, 5 hours", ts.format(new TimeSpanShortFormatter()));
	}
	
	@Test
	public void test10() {
		long start = System.currentTimeMillis();
		long end = start + days(3) + minutes(7);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days, 7 minutes", ts.format(new TimeSpanShortFormatter()));
	}
	
	@Test
	public void test11() {
		long start = System.currentTimeMillis();
		long end = start + days(3) + seconds(1);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days, 1 seconds", ts.format(new TimeSpanShortFormatter()));
	}
	
	@Test
	public void test12() {
		long start = System.currentTimeMillis();
		long end = start + days(3) + minutes(4) + seconds(1);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days, 4 minutes, 1 seconds", ts.format(new TimeSpanShortFormatter()));
	}
	
	@Test
	public void test13() {
		long start = System.currentTimeMillis();
		long end = start + days(3) + hours(4) + seconds(1);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days, 4 hours, 1 seconds", ts.format(new TimeSpanShortFormatter()));
	}
	
	@Test
	public void test14() {
		long start = System.currentTimeMillis();
		long end = start + days(3) + hours(4) + minutes(11);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days, 4 hours, 11 minutes", ts.format(new TimeSpanShortFormatter()));
	}
	
	@Test
	public void test15() {
		long start = System.currentTimeMillis();
		long end = start + days(3) + hours(4) + minutes(11) + seconds(4);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("3 days, 4 hours, 11 minutes, 4 seconds", ts.format(new TimeSpanShortFormatter()));
	}
}
