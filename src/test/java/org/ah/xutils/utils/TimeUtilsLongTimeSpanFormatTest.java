package org.ah.xutils.utils;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;
import static org.junit.Assert.assertEquals;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanLongFormatter;
import org.ah.xutils.utils.TimeUtils;
import org.junit.Test;

public class TimeUtilsLongTimeSpanFormatTest {

	@Test
	public void testSeconds() {
		long start = System.currentTimeMillis();
		long end = start + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 days, 0 hours, 0 minutes, 5 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	public void testMinutes() {
		long start = System.currentTimeMillis();
		long end = start + minutes(4);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 days, 0 hours, 4 minutes, 0 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	public void testHours() {
		long start = System.currentTimeMillis();
		long end = start + hours(9);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 days, 9 hours, 0 minutes, 0 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	public void testDays() {
		long start = System.currentTimeMillis();
		long end = start + days(2);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 0 hours, 0 minutes, 0 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	public void testDaysHoursMinutesSeconds() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 9 hours, 4 minutes, 5 seconds", ts.format(new TimeSpanLongFormatter()));
	}

	@Test
	public void testDefaultTimeSpanFormat() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 days, 9 hours, 4 minutes, 5 seconds", ts.format(new TimeSpanLongFormatter()));
	}
}
