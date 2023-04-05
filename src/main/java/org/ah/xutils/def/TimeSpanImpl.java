package org.ah.xutils.def;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;

import javax.annotation.Nonnull;

import org.ah.xutils.def.formatters.Formatter;

class TimeSpanImpl implements TimeSpan {

    private long days;
    private long hours;
    private long minutes;
    private long seconds;

    TimeSpanImpl(long millis) {
        long remaining = calculateDays(millis);
        remaining = calculateHours(remaining);
        remaining = calculateMinutes(remaining);
        calculateSeconds(remaining);
    }

    private long calculateDays(long millis) {
        days = millis / days(1);
        return millis - days(days);
    }

    private long calculateHours(long millis) {
        hours = millis / hours(1);
        return millis - hours(hours);
    }

    private long calculateMinutes(long millis) {
        minutes = millis / minutes(1);
        return millis - minutes(minutes);
    }

    private void calculateSeconds(long millis) {
        seconds = millis / seconds(1);
    }

    @Override
    public long getDays() {
        return days;
    }

    @Override
    public long getHours() {
        return hours;
    }

    @Override
    public long getMinutes() {
        return minutes;
    }

    @Override
    public long getSeconds() {
        return seconds;
    }

    @Override
    @Nonnull
    public String format(Formatter formatter) {
        return formatter.format(this);
    }
}
