package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

/**
 * The full representation of TimeSpan, it shows 0's as well. Words are
 * abbreviated (d - for days, h - for hours, m - for minutes, s - for seconds),
 * but there is no delimiter in between:
 * <p>
 * 4d 0h 0m 5s
 *
 * @author armend
 */
public class TimeSpanLongAbbreviatedNoDelimFormatter implements TimeSpanFormatter {
    @Override
    public String format(TimeSpan ts) {
        return ts.getDays() + "d " + ts.getHours() + "h " + ts.getMinutes() + "m " + ts.getSeconds() + "s";
    }
}
