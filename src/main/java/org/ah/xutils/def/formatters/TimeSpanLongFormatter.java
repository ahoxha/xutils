package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

/**
 * The full representation of TimeSpan, it shows 0-valued units as well:
 * <p>
 * 4 days, 0 hours, 0 minutes, 5 seconds
 *
 * @author armend
 */
public class TimeSpanLongFormatter implements Formatter {

    @Override
    public String format(TimeSpan ts) {
        return ts.getDays() + " days, " + ts.getHours() + " hours, " + ts.getMinutes() + " minutes, " + ts.getSeconds() + " seconds";
    }
}
