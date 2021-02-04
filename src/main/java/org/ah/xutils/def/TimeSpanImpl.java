package org.ah.xutils.def;

import org.ah.xutils.def.formatters.Formatter;

import static org.ah.xutils.def.InMilliseconds.days;
import static org.ah.xutils.def.InMilliseconds.hours;
import static org.ah.xutils.def.InMilliseconds.minutes;
import static org.ah.xutils.def.InMilliseconds.seconds;

import javax.annotation.Nonnull;

class TimeSpanImpl implements TimeSpan {

    private long days;
    private long hours;
    private long minutes;
    private long seconds;

    private TimeSpanImpl(long millis) {
        days = millis / days(1);
        millis = millis - days(days);
        if (millis > 0) {
            hours = millis / hours(1);
            millis = millis - hours(hours);
            if (millis > 0) {
                minutes = millis / minutes(1);
                millis = millis - minutes(minutes);
                if (millis > 0) {
                    seconds = millis / seconds(1);
                }
            }
        }
    }

    public static TimeSpan create(long millis) {
        return new TimeSpanImpl(millis);
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
