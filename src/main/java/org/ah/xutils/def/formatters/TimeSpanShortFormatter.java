package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

/**
 * 4 days, 5 seconds
 *
 * @author armend
 */
public class TimeSpanShortFormatter implements TimeSpanFormatter {

    @Override
    public String format(TimeSpan ts) {
        StringBuilder sb = new StringBuilder();
        if (ts.getDays() > 0) {
            sb.append(ts.getDays()).append(" days, ");
        }
        if (ts.getHours() > 0) {
            sb.append(ts.getHours()).append(" hours, ");
        }
        if (ts.getMinutes() > 0) {
            sb.append(ts.getMinutes()).append(" minutes, ");
        }
        if (ts.getSeconds() > 0) {
            sb.append(ts.getSeconds()).append(" seconds");
        }
        if (sb.lastIndexOf(",") == sb.length() - 2) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.toString();
    }
}
