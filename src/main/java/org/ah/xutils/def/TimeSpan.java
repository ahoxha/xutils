package org.ah.xutils.def;

import javax.annotation.Nonnull;

import org.ah.xutils.def.formatters.TimeSpanFormatter;
import org.ah.xutils.def.formatters.TimeSpanLongFormatter;

/**
 * Represents a period of time in days, hours, minutes, and seconds.
 *
 * @author armend
 */
public interface TimeSpan {

    long getDays();

    long getHours();

    long getMinutes();

    long getSeconds();

    @Nonnull
    String format(@Nonnull TimeSpanFormatter formatter);

    /**
     * Formats the TimeSpan using
     * {@link org.ah.xutils.def.formatters.TimeSpanLongFormatter}.
     */
    default @Nonnull String format() {
        return format(new TimeSpanLongFormatter());
    }

    /**
     * Converts the milliseconds into days, hours, minutes and seconds. Any leftover milliseconds are truncated.
     *
     * @param milliseconds Number of milliseconds.
     * @return A {@link TimeSpan} object that represents a period of time.
     */
    static TimeSpan create(long milliseconds) {
        return new TimeSpanImpl(milliseconds);
    }
}
