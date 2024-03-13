package org.ah.xutils.def;

/**
 * Provides methods to easily convert days, hours, minutes and seconds into
 * milliseconds.
 *
 * @author armend
 */
public final class MillisecondsUtils {
    private static final int MILLISECONDS_IN_ONE_DAY = 86400000;
    private static final int MILLISECONDS_IN_ONE_HOUR = 3600000;
    private static final int MILLISECONDS_IN_ONE_MINUTE = 60000;
    private static final int MILLISECONDS_IN_ONE_SECOND = 1000;

    private MillisecondsUtils() {
        // Prevent instantiation
    }

    public static long daysToMillis(long value) {
        return value * MILLISECONDS_IN_ONE_DAY;
    }

    public static long hoursToMillis(long value) {
        return value * MILLISECONDS_IN_ONE_HOUR;
    }

    public static long minutesToMillis(long value) {
        return value * MILLISECONDS_IN_ONE_MINUTE;
    }

    public static long secondsToMillis(long value) {
        return value * MILLISECONDS_IN_ONE_SECOND;
    }
}
