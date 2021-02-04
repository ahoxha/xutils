package org.ah.xutils.def;

/**
 * Provides methods to easily convert days, hours, minutes and seconds into
 * milliseconds.
 *
 * @author armend
 */
public final class InMilliseconds {

    private static final int MILLISECONDS_IN_ONE_DAY = 86400000;
    private static final int MILLISECONDS_IN_ONE_HOUR = 3600000;
    private static final int MILLISECONDS_IN_ONE_MINUTE = 60000;
    private static final int MILLISECONDS_IN_ONE_SECOND = 1000;

    private InMilliseconds() {
        // Prevent instantiation
    }

    /**
     * Converts days into milliseconds.
     *
     * @param value Number of days.
     * @return Number of milliseconds in {@code value} days.
     */
    public static long days(long value) {
        return value * MILLISECONDS_IN_ONE_DAY;
    }

    /**
     * Converts hours into milliseconds.
     *
     * @param value Number of hours.
     * @return Number of milliseconds in {@code value} hours.
     */
    public static long hours(long value) {
        return value * MILLISECONDS_IN_ONE_HOUR;
    }

    /**
     * Converts minutes into milliseconds.
     *
     * @param value Number of minutes.
     * @return Number of milliseconds in {@code value} minutes.
     */
    public static long minutes(long value) {
        return value * MILLISECONDS_IN_ONE_MINUTE;
    }

    /**
     * Converts seconds into milliseconds.
     *
     * @param value Number of seconds.
     * @return Number of milliseconds in {@code value} seconds.
     */
    public static long seconds(long value) {
        return value * MILLISECONDS_IN_ONE_SECOND;
    }
}
