package org.ah.utils;

import static org.ah.def.InMilliseconds.days;
import static org.ah.def.InMilliseconds.hours;
import static org.ah.def.InMilliseconds.minutes;
import static org.ah.def.InMilliseconds.seconds;
import static org.junit.Assert.assertEquals;

import org.ah.def.TimeSpan;
import org.ah.def.TimeSpanFormat;
import org.ah.xutils.TimeUtils;
import org.junit.Test;

public class TimeUtilsLongAbrNoDelimTimeSpanFormatTest {
	@Test
	public void testSeconds() {
		long start = System.currentTimeMillis();
		long end = start + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0d 0h 0m 5s", ts.format(TimeSpanFormat.LONG_ABR_NODELIM));
	}
	
	@Test
	public void testMinutes() {
		long start = System.currentTimeMillis();
		long end = start + minutes(15);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0d 0h 15m 0s", ts.format(TimeSpanFormat.LONG_ABR_NODELIM));
	}
	
	@Test
	public void testHours() {
		long start = System.currentTimeMillis();
		long end = start + hours(23);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0d 23h 0m 0s", ts.format(TimeSpanFormat.LONG_ABR_NODELIM));
	}
	
	@Test
	public void testDays() {
		long start = System.currentTimeMillis();
		long end = start + days(2);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2d 0h 0m 0s", ts.format(TimeSpanFormat.LONG_ABR_NODELIM));
	}

	@Test
	public void testDaysHoursMinutesSeconds() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(43) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2d 9h 43m 5s", ts.format(TimeSpanFormat.LONG_ABR_NODELIM));
	}
}
