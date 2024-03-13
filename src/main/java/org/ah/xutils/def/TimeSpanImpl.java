package org.ah.xutils.def;

import static org.ah.xutils.def.MillisecondsUtils.daysToMillis;
import static org.ah.xutils.def.MillisecondsUtils.hoursToMillis;
import static org.ah.xutils.def.MillisecondsUtils.minutesToMillis;
import static org.ah.xutils.def.MillisecondsUtils.secondsToMillis;

import javax.annotation.Nonnull;

import org.ah.xutils.def.formatters.TimeSpanFormatter;

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
        days = millis / daysToMillis(1);
        return millis - daysToMillis(days);
    }

    private long calculateHours(long millis) {
        hours = millis / hoursToMillis(1);
        return millis - hoursToMillis(hours);
    }

    private long calculateMinutes(long millis) {
        minutes = millis / minutesToMillis(1);
        return millis - minutesToMillis(minutes);
    }

    private void calculateSeconds(long millis) {
        seconds = millis / secondsToMillis(1);
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
    public String format(@Nonnull TimeSpanFormatter formatter) {
        return formatter.format(this);
    }
}
