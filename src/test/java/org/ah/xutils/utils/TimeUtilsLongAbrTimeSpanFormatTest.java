package org.ah.xutils.utils;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanLongAbbreviatedFormatter;
import org.junit.jupiter.api.Test;

import static org.ah.xutils.def.InMilliseconds.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeUtilsLongAbrTimeSpanFormatTest {
    @Test
    void testSeconds() {
        long start = System.currentTimeMillis();
        long end = start + seconds(5);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("0 d, 0 h, 0 m, 5 s", ts.format(new TimeSpanLongAbbreviatedFormatter()));
    }

    @Test
    void testMinutes() {
        long start = System.currentTimeMillis();
        long end = start + minutes(12);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("0 d, 0 h, 12 m, 0 s", ts.format(new TimeSpanLongAbbreviatedFormatter()));
    }

    @Test
    void testHours() {
        long start = System.currentTimeMillis();
        long end = start + hours(10);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("0 d, 10 h, 0 m, 0 s", ts.format(new TimeSpanLongAbbreviatedFormatter()));
    }

    @Test
    void testDays() {
        long start = System.currentTimeMillis();
        long end = start + days(12);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("12 d, 0 h, 0 m, 0 s", ts.format(new TimeSpanLongAbbreviatedFormatter()));
    }

    @Test
    void testDaysHoursMinutesSeconds() {
        long start = System.currentTimeMillis();
        long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals("2 d, 9 h, 4 m, 5 s", ts.format(new TimeSpanLongAbbreviatedFormatter()));
    }

}
