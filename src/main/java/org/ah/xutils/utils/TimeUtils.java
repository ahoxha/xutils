package org.ah.xutils.utils;

import org.ah.xutils.def.TimeSpan;

public final class TimeUtils {

    private TimeUtils() {}

    /**
     * Find the time span between start and end.
     *
     * @param start Start time in milliseconds.
     * @param end   End time in milliseconds.
     * @return A TimeSpan object that represents the duration in days, hours,
     * minutes and seconds (any leftover milliseconds are truncated).
     * @throws IllegalArgumentException If end time is smaller than start time.
     */
    public static TimeSpan diff(long start, long end) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        if (end < start) {
            throw new IllegalArgumentException("The value for 'end' is smaller than the value for 'start'.");
        }
        return TimeSpan.create(end - start);
    }

    public static TimeSpan toTimeSpan(long millis) {
        return diff(0, millis);
    }
}
