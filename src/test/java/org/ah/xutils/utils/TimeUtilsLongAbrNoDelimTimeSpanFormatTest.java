package org.ah.xutils.utils;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanLongAbbreviatedNoDelimFormatter;
import org.junit.jupiter.api.Test;

class TimeUtilsLongAbrNoDelimTimeSpanFormatTest {
    @Test
    void testSeconds() {
        long start = System.currentTimeMillis();
        long end = start + seconds(5);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("0d 0h 0m 5s", ts.format(new TimeSpanLongAbbreviatedNoDelimFormatter()));
    }

    @Test
    void testMinutes() {
        long start = System.currentTimeMillis();
        long end = start + minutes(15);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("0d 0h 15m 0s", ts.format(new TimeSpanLongAbbreviatedNoDelimFormatter()));
    }

    @Test
    void testHours() {
        long start = System.currentTimeMillis();
        long end = start + hours(23);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("0d 23h 0m 0s", ts.format(new TimeSpanLongAbbreviatedNoDelimFormatter()));
    }

    @Test
    void testDays() {
        long start = System.currentTimeMillis();
        long end = start + days(2);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("2d 0h 0m 0s", ts.format(new TimeSpanLongAbbreviatedNoDelimFormatter()));
    }

    @Test
    void testDaysHoursMinutesSeconds() {
        long start = System.currentTimeMillis();
        long end = start + days(2) + hours(9) + minutes(43) + seconds(5);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("2d 9h 43m 5s", ts.format(new TimeSpanLongAbbreviatedNoDelimFormatter()));
    }
}
