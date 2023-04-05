package org.ah.xutils.def;

import javax.annotation.Nonnull;

import org.ah.xutils.def.formatters.Formatter;
import org.ah.xutils.def.formatters.TimeSpanLongFormatter;

/**
 * Represents a period of time in days, hours, minutes, and seconds.
 *
 * @author armend
 */
public interface TimeSpan {
    /**
     * Returns the number of days in this time span.
     */
    long getDays();

    /**
     * Returns the number of hours in this time span.
     */
    long getHours();

    /**
     * Returns the number of minutes in this time span.
     */
    long getMinutes();

    /**
     * Returns the number of seconds in this time span.
     */
    long getSeconds();

    /**
     * Returns a formatted string of this TimeSpan.
     *
     * @param formatter
     * @return
     */
    @Nonnull
    String format(@Nonnull Formatter formatter);

    /**
     * Formats the TimeSpan using
     * {@link org.ah.xutils.def.formatters.TimeSpanLongFormatter}.
     *
     * @return
     */
    default @Nonnull
    String format() {
        return format(new TimeSpanLongFormatter());
    }

    /**
     * Converts the milliseconds into days, hours, minutes and seconds. Any left
     * over milliseconds are truncated.
     *
     * @param milliseconds Number of milliseconds.
     * @return A {@link TimeSpan} object that represents a period of time.
     */
    static TimeSpan create(long milliseconds) {
        return new TimeSpanImpl(milliseconds);
    }
}
