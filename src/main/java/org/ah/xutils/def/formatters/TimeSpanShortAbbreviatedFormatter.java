package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

/**
 * 4d, 5s
 *
 * @author armend
 */
public class TimeSpanShortAbbreviatedFormatter implements TimeSpanFormatter {
    @Override
    public String format(TimeSpan ts) {
        StringBuilder sb = new StringBuilder();
        if (ts.getDays() > 0) {
            sb.append(ts.getDays()).append("d, ");
        }
        if (ts.getHours() > 0) {
            sb.append(ts.getHours()).append("h, ");
        }
        if (ts.getMinutes() > 0) {
            sb.append(ts.getMinutes()).append("m, ");
        }
        if (ts.getSeconds() > 0) {
            sb.append(ts.getSeconds()).append("s");
        }
        if (sb.lastIndexOf(",") == sb.length() - 2) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.toString();
    }
}
