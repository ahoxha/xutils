package org.ah.xutils.def;

import static org.ah.xutils.def.MillisecondsUtils.daysToMillis;
import static org.ah.xutils.def.MillisecondsUtils.hoursToMillis;
import static org.ah.xutils.def.MillisecondsUtils.minutesToMillis;
import static org.ah.xutils.def.MillisecondsUtils.secondsToMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MillisecondsUtilsTest {

    private static final int FOUR_DAYS = 4 * 24 * 60 * 60 * 1000;
    private static final int TWELVE_HOURS = 12 * 60 * 60 * 1000;
    private static final int TWENTY_THREE_MINUTES = 23 * 60 * 1000;
    private static final int EIGHTEEN_SECONDS = 18 * 1000;

    @Test
    void testDays() {
        assertEquals(FOUR_DAYS, daysToMillis(4));
    }

    @Test
    void testHours() {
        assertEquals(TWELVE_HOURS, hoursToMillis(12));
    }

    @Test
    void testMinutes() {
        assertEquals(TWENTY_THREE_MINUTES, minutesToMillis(23));
    }

    @Test
    void testSeconds() {
        assertEquals(EIGHTEEN_SECONDS, secondsToMillis(18));
    }
}
