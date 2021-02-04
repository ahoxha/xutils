package org.ah.xutils.def;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InMillisecondsTest {

    private static final int FOUR_DAYS = 4 * 24 * 60 * 60 * 1000;
    private static final int TWELVE_HOURS = 12 * 60 * 60 * 1000;
    private static final int TWENTY_THREE_MINUTES = 23 * 60 * 1000;
    private static final int EIGHTEEN_SECONDS = 18 * 1000;

    @Test
    void testDays() {
        assertEquals(FOUR_DAYS, days(4));
    }

    @Test
    void testHours() {
        assertEquals(TWELVE_HOURS, hours(12));
    }

    @Test
    void testMinutes() {
        assertEquals(TWENTY_THREE_MINUTES, minutes(23));
    }

    @Test
    void testSeconds() {
        assertEquals(EIGHTEEN_SECONDS, seconds(18));
    }
}
