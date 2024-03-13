package org.ah.xutils.utils;

import static org.ah.xutils.def.MillisecondsUtils.daysToMillis;
import static org.ah.xutils.def.MillisecondsUtils.hoursToMillis;
import static org.ah.xutils.def.MillisecondsUtils.minutesToMillis;
import static org.ah.xutils.def.MillisecondsUtils.secondsToMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanShortAbbreviatedFormatter;
import org.junit.jupiter.api.Test;

class TimeUtilsShortAbrTimeSpanFormatTest {
    @Test
    void test1() {
        long start = System.currentTimeMillis();
        long end = start + secondsToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("5s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test2() {
        long start = System.currentTimeMillis();
        long end = start + minutesToMillis(3);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test3() {
        long start = System.currentTimeMillis();
        long end = start + minutesToMillis(3) + secondsToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3m, 5s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test4() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test5() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12) + minutesToMillis(8);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h, 8m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test6() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12) + secondsToMillis(6);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h, 6s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test7() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12) + minutesToMillis(8) + secondsToMillis(2);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12h, 8m, 2s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test8() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test9() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 5h", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test10() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + minutesToMillis(7);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 7m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test11() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + secondsToMillis(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 1s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test12() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + minutesToMillis(4) + secondsToMillis(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4m, 1s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test13() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(4) + secondsToMillis(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4h, 1s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test14() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(4) + minutesToMillis(11);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4h, 11m", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }

    @Test
    void test15() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(4) + minutesToMillis(11) + secondsToMillis(4);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3d, 4h, 11m, 4s", ts.format(new TimeSpanShortAbbreviatedFormatter()));
    }
}
