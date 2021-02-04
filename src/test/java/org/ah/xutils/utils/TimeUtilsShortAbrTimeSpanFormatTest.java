package org.ah.xutils.utils;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanShortAbbreviatedFormatter;
import org.junit.jupiter.api.Test;

class TimeUtilsShortAbrTimeSpanFormatTest {
    @Test
    void test1() {
        long start = System.currentTimeMillis();
        long end = start + seconds(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("5s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test2() {
        long start = System.currentTimeMillis();
        long end = start + minutes(3);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test3() {
        long start = System.currentTimeMillis();
        long end = start + minutes(3) + seconds(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3m, 5s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test4() {
        long start = System.currentTimeMillis();
        long end = start + hours(12);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test5() {
        long start = System.currentTimeMillis();
        long end = start + hours(12) + minutes(8);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h, 8m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test6() {
        long start = System.currentTimeMillis();
        long end = start + hours(12) + seconds(6);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h, 6s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test7() {
        long start = System.currentTimeMillis();
        long end = start + hours(12) + minutes(8) + seconds(2);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h, 8m, 2s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test8() {
        long start = System.currentTimeMillis();
        long end = start + days(3);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test9() {
        long start = System.currentTimeMillis();
        long end = start + days(3) + hours(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 5h", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test10() {
        long start = System.currentTimeMillis();
        long end = start + days(3) + minutes(7);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 7m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test11() {
        long start = System.currentTimeMillis();
        long end = start + days(3) + seconds(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 1s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test12() {
        long start = System.currentTimeMillis();
        long end = start + days(3) + minutes(4) + seconds(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4m, 1s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test13() {
        long start = System.currentTimeMillis();
        long end = start + days(3) + hours(4) + seconds(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4h, 1s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test14() {
        long start = System.currentTimeMillis();
        long end = start + days(3) + hours(4) + minutes(11);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4h, 11m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test15() {
        long start = System.currentTimeMillis();
        long end = start + days(3) + hours(4) + minutes(11) + seconds(4);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4h, 11m, 4s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }
}
