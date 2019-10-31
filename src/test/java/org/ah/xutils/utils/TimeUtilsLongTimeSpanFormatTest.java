package org.ah.xutils.utils;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanLongFormatter;
import org.junit.jupiter.api.Test;

import static org.ah.xutils.def.InMilliseconds.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeUtilsLongTimeSpanFormatTest {

	@Test
	void testSeconds() {
		long start = System.currentTimeMillis();
		long end = start + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 days, 0 hours, 0 minutes, 5 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	void testMinutes() {
		long start = System.currentTimeMillis();
		long end = start + minutes(4);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 days, 0 hours, 4 minutes, 0 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	void testHours() {
		long start = System.currentTimeMillis();
		long end = start + hours(9);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 days, 9 hours, 0 minutes, 0 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	void testDays() {
		long start = System.currentTimeMillis();
		long end = start + days(2);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 0 hours, 0 minutes, 0 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	void testDaysHoursMinutesSeconds() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 9 hours, 4 minutes, 5 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	void testDefaultTimeSpanFormat() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 9 hours, 4 minutes, 5 seconds", ts.format());
	}

	@Test
	void testDefaultTimeSpanFormatZeroDays() {
		long start = System.currentTimeMillis();
		long end = start + days(0) + hours(9) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 days, 9 hours, 4 minutes, 5 seconds", ts.format());
	}

	@Test
	void testDefaultTimeSpanFormatZeroHours() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(0) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 0 hours, 4 minutes, 5 seconds", ts.format());
	}

	@Test
	void testDefaultTimeSpanFormatZeroMinutes() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(0) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 9 hours, 0 minutes, 5 seconds", ts.format());
	}

	@Test
	void testDefaultTimeSpanFormatZeroSeconds() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(4) + seconds(0);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 9 hours, 4 minutes, 0 seconds", ts.format());
	}
}
