package org.ah.xutils.utils;

import org.ah.xutils.def.TimeSpan;
import org.junit.jupiter.api.Test;

import static org.ah.xutils.def.MillisecondsUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {
    @Test
    void test1() {
        long start = System.currentTimeMillis();
        long end = start + secondsToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals(5, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(0, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(0, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(0, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void test2() {
        long start = System.currentTimeMillis();
        long end = start + minutesToMillis(4);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals(0, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(4, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(0, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(0, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void test3() {
        long start = System.currentTimeMillis();
        long end = start + hoursToMillis(9);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals(0, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(0, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(9, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(0, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void test4() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(2);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals(0, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(0, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(0, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(2, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void test5() {
        long start = System.currentTimeMillis();
        long end = start + daysToMillis(2) + hoursToMillis(9) + minutesToMillis(4) + secondsToMillis(5);

        TimeSpan ts = TimeUtils.diff(start, end);

        assertEquals(5, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(4, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(9, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(2, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void testEndSmallerThanStart() {
        try {
            TimeUtils.diff(secondsToMillis(5), secondsToMillis(3));
            fail("It should have thrown an IllegalArgumentException: end is smaller than start.");
        } catch (IllegalArgumentException e) {
            assertEquals("The value for 'end' is smaller than the value for 'start'.", e.getMessage());
        }
    }

    @Test
    void testTruncateExtraMillis() {
        TimeSpan ts = TimeUtils.diff(0, secondsToMillis(3) + 520);

        assertEquals(3, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(0, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(0, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(0, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void testZeroTimeSpan() {
        TimeSpan ts = TimeUtils.diff(daysToMillis(4), daysToMillis(4));

        assertEquals(0, ts.getSeconds(), "Wrong value for seconds: " + ts.getSeconds());
        assertEquals(0, ts.getMinutes(), "Wrong value for minutes: " + ts.getMinutes());
        assertEquals(0, ts.getHours(), "Wrong value for hours: " + ts.getHours());
        assertEquals(0, ts.getDays(), "Wrong value for days: " + ts.getDays());
    }

    @Test
    void testFormatterCustom() {
        TimeSpan ts = TimeUtils.diff(0, daysToMillis(4) + hoursToMillis(2) + minutesToMillis(12));

        assertEquals("4:2:12:0", ts.format((t) -> t.getDays() + ":" + t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds()));
    }

    @Test
    void testToTimeSpanWithZeroValue() {
        TimeSpan timeSpan = TimeUtils.toTimeSpan(0);

        assertEquals(0, timeSpan.getDays());
        assertEquals(0, timeSpan.getHours());
        assertEquals(0, timeSpan.getMinutes());
        assertEquals(0, timeSpan.getSeconds());
    }

    @Test
    void testToTimeSpanWithNonZeroValue() {
        long millis = daysToMillis(3) + hoursToMillis(2) + minutesToMillis(23) + secondsToMillis(13);

        TimeSpan timeSpan = TimeUtils.toTimeSpan(millis);

        assertEquals(3, timeSpan.getDays());
        assertEquals(2, timeSpan.getHours());
        assertEquals(23, timeSpan.getMinutes());
        assertEquals(13, timeSpan.getSeconds());
    }

    @Test
    void testToTimeSpanWithNonZeroSeconds() {
        TimeSpan timeSpan = TimeUtils.toTimeSpan(secondsToMillis(34));

        assertEquals(0, timeSpan.getDays());
        assertEquals(0, timeSpan.getHours());
        assertEquals(0, timeSpan.getMinutes());
        assertEquals(34, timeSpan.getSeconds());
    }

    @Test
    void testToTimeSpanWithNonZeroMinutes() {
        TimeSpan timeSpan = TimeUtils.toTimeSpan(minutesToMillis(12));

        assertEquals(0, timeSpan.getDays());
        assertEquals(0, timeSpan.getHours());
        assertEquals(12, timeSpan.getMinutes());
        assertEquals(0, timeSpan.getSeconds());
    }

    @Test
    void testToTimeSpanWithNonZeroHours() {
        TimeSpan timeSpan = TimeUtils.toTimeSpan(hoursToMillis(12));

        assertEquals(0, timeSpan.getDays());
        assertEquals(12, timeSpan.getHours());
        assertEquals(0, timeSpan.getMinutes());
        assertEquals(0, timeSpan.getSeconds());
    }

    @Test
    void testToTimeSpanWithNonZeroDays() {
        TimeSpan timeSpan = TimeUtils.toTimeSpan(daysToMillis(8));

        assertEquals(8, timeSpan.getDays());
        assertEquals(0, timeSpan.getHours());
        assertEquals(0, timeSpan.getMinutes());
        assertEquals(0, timeSpan.getSeconds());
    }

    @Test
    void testToTimeSpanWithNonZeroHoursMoreThanOneDay() {
        TimeSpan timeSpan = TimeUtils.toTimeSpan(hoursToMillis(27));

        assertEquals(1, timeSpan.getDays());
        assertEquals(3, timeSpan.getHours());
        assertEquals(0, timeSpan.getMinutes());
        assertEquals(0, timeSpan.getSeconds());
    }

    @Test
    void testDiffWithNegativeValue() {
        try {
            TimeUtils.diff(-34356, -1234);
            fail("Negative values should not be allowed.");
        } catch (IllegalArgumentException exception) {
            assertNotNull(exception);
        }
    }

    @Test
    void testToTimeSpanWithNegativeValue() {
        try {
            TimeUtils.toTimeSpan(-100);
            fail("Negative values should not be allowed.");
        } catch (IllegalArgumentException exception) {
            assertNotNull(exception);
        }
    }
}
