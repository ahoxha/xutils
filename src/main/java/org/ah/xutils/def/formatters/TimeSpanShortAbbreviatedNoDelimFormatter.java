package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

/**
 * 4d 5s
 *
 * @author armend
 */
public class TimeSpanShortAbbreviatedNoDelimFormatter implements Formatter {
    @Override
    public String format(TimeSpan ts) {
        StringBuilder sb = new StringBuilder();
        if (ts.getDays() > 0) {
            sb.append(ts.getDays()).append("d ");
        }
        if (ts.getHours() > 0) {
            sb.append(ts.getHours()).append("h ");
        }
        if (ts.getMinutes() > 0) {
            sb.append(ts.getMinutes()).append("m ");
        }
        if (ts.getSeconds() > 0) {
            sb.append(ts.getSeconds()).append("s");
        }

        return sb.toString().trim();
    }
}
