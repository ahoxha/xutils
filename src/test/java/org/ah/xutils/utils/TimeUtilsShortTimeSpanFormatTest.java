package org.ah.xutils.utils;

import static org.ah.xutils.def.MillisecondsUtils.daysToMillis;
import static org.ah.xutils.def.MillisecondsUtils.hoursToMillis;
import static org.ah.xutils.def.MillisecondsUtils.minutesToMillis;
import static org.ah.xutils.def.MillisecondsUtils.secondsToMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ah.xutils.def.TimeSpan;
import org.ah.xutils.def.formatters.TimeSpanShortFormatter;
import org.junit.jupiter.api.Test;

class TimeUtilsShortTimeSpanFormatTest {

    @Test
    void test1() {
        long start = System.currentTimeMillis();
        long end = start + secondsToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("5 seconds", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test2() {
        long start = System.currentTimeMillis();
        long end = start + minutesToMillis(3);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 minutes", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test3() {
        long start = System.currentTimeMillis();
        long end = start + minutesToMillis(3) + secondsToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 minutes, 5 seconds", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test4() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12 hours", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test5() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12) + minutesToMillis(8);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12 hours, 8 minutes", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test6() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12) + secondsToMillis(6);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12 hours, 6 seconds", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test7() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(12) + minutesToMillis(8) + secondsToMillis(2);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("12 hours, 8 minutes, 2 seconds", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test8() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test9() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days, 5 hours", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test10() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + minutesToMillis(7);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days, 7 minutes", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test11() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + secondsToMillis(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days, 1 seconds", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test12() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + minutesToMillis(4) + secondsToMillis(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days, 4 minutes, 1 seconds", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test13() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(4) + secondsToMillis(1);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days, 4 hours, 1 seconds", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test14() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(4) + minutesToMillis(11);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days, 4 hours, 11 minutes", ts.format(new TimeSpanShortFormatter()));
    }

    @Test
    void test15() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(3) + hoursToMillis(4) + minutesToMillis(11) + secondsToMillis(4);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals("3 days, 4 hours, 11 minutes, 4 seconds", ts.format(new TimeSpanShortFormatter()));
    }
}
