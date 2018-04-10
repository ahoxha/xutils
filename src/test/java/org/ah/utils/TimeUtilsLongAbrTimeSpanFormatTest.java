package org.ah.utils;

import static org.ah.def.InMilliseconds.days;
import static org.ah.def.InMilliseconds.hours;
import static org.ah.def.InMilliseconds.minutes;
import static org.ah.def.InMilliseconds.seconds;
import static org.junit.Assert.assertEquals;

import org.ah.def.TimeSpan;
import org.ah.def.TimeSpanFormat;
import org.junit.Test;

public class TimeUtilsLongAbrTimeSpanFormatTest {
	@Test
	public void testSeconds() {
		long start = System.currentTimeMillis();
		long end = start + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 d, 0 h, 0 m, 5 s", ts.format(TimeSpanFormat.LONG_ABR));
	}

	@Test
	public void testMinutes() {
		long start = System.currentTimeMillis();
		long end = start + minutes(12);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 d, 0 h, 12 m, 0 s", ts.format(TimeSpanFormat.LONG_ABR));
	}

	@Test
	public void testHours() {
		long start = System.currentTimeMillis();
		long end = start + hours(10);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("0 d, 10 h, 0 m, 0 s", ts.format(TimeSpanFormat.LONG_ABR));
	}

	@Test
	public void testDays() {
		long start = System.currentTimeMillis();
		long end = start + days(12);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("12 d, 0 h, 0 m, 0 s", ts.format(TimeSpanFormat.LONG_ABR));
	}

	@Test
	public void testDaysHoursMinutesSeconds() {
		long start = System.currentTimeMillis();
		long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
		TimeSpan ts = TimeUtils.diff(start, end);
		assertEquals("2 d, 9 h, 4 m, 5 s", ts.format(TimeSpanFormat.LONG_ABR));
	}

}
