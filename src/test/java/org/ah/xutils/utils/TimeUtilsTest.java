package org.ah.xutils.utils;

import org.ah.xutils.def.TimeSpan;
import org.junit.jupiter.api.Test;

import static org.ah.xutils.def.InMilliseconds.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TimeUtilsTest {
    @Test
    void test1() {
        long start = System.currentTimeMillis();
        long end = start + seconds(5);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals(5, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(0, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(0, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(0, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void test2() {
        long start = System.currentTimeMillis();
        long end = start + minutes(4);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals(0, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(4, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(0, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(0, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void test3() {
        long start = System.currentTimeMillis();
        long end = start + hours(9);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals( 0, ts.getSeconds(),"Wrong value for seconds: " + ts.getSeconds());
        assertEquals( 0, ts.getMinutes(),"Wrong value for minutes: " + ts.getMinutes());
        assertEquals( 9, ts.getHours(),"Wrong value for hours: " + ts.getHours());
        assertEquals( 0, ts.getDays(),"Wrong value for days: " + ts.getDays());
    }

    @Test
    void test4() {
        long start = System.currentTimeMillis();
        long end = start + days(2);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals( 0, ts.getSeconds(),"Wrong value for seconds: " + ts.getSeconds());
        assertEquals( 0, ts.getMinutes(),"Wrong value for minutes: " + ts.getMinutes());
        assertEquals( 0, ts.getHours(),"Wrong value for hours: " + ts.getHours());
        assertEquals( 2, ts.getDays(),"Wrong value for days: " + ts.getDays());
    }

    @Test
    void test5() {
        long start = System.currentTimeMillis();
        long end = start + days(2) + hours(9) + minutes(4) + seconds(5);
        TimeSpan ts = TimeUtils.diff(start, end);
        assertEquals( 5, ts.getSeconds(),"Wrong value for seconds: " + ts.getSeconds());
        assertEquals( 4, ts.getMinutes(),"Wrong value for minutes: " + ts.getMinutes());
        assertEquals( 9, ts.getHours(),"Wrong value for hours: " + ts.getHours());
        assertEquals( 2, ts.getDays(),"Wrong value for days: " + ts.getDays());
    }

    @Test
    void testEndSmallerThanStart() {
        try {
            TimeUtils.diff(seconds(5), seconds(3));
            fail("It should have thrown an IllegalArgumentException: end is smaller than start.");
        } catch (IllegalArgumentException e) {
            assertEquals("The value for 'end' is smaller than the value for 'start'.", e.getMessage());
        }
    }

    @Test
    void testTruncateExtraMillis() {
        TimeSpan ts = TimeUtils.diff(0, seconds(3) + 520);
        assertEquals( 3, ts.getSeconds(),"Wrong value for seconds: " + ts.getSeconds());
        assertEquals( 0, ts.getMinutes(),"Wrong value for minutes: " + ts.getMinutes());
        assertEquals( 0, ts.getHours(),"Wrong value for hours: " + ts.getHours());
        assertEquals( 0, ts.getDays(),"Wrong value for days: " + ts.getDays());
    }

    @Test
    void testZeroTimeSpan() {
        TimeSpan ts = TimeUtils.diff(days(4), days(4));
        assertEquals( 0, ts.getSeconds(),"Wrong value for seconds: " + ts.getSeconds());
        assertEquals( 0, ts.getMinutes(),"Wrong value for minutes: " + ts.getMinutes());
        assertEquals( 0, ts.getHours(),"Wrong value for hours: " + ts.getHours());
        assertEquals( 0, ts.getDays(),"Wrong value for days: " + ts.getDays());
    }

    @Test
    void testFormatterCustom() {
        TimeSpan ts = TimeUtils.diff(0, days(4) + hours(2) + minutes(12));
        assertEquals("4:2:12:0", ts.format((t) -> t.getDays() + ":" + t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds()));
    }
}
