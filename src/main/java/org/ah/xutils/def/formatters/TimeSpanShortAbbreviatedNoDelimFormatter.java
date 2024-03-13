package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

/**
 * 4d 5s
 *
 * @author armend
 */
public class TimeSpanShortAbbreviatedNoDelimFormatter implements TimeSpanFormatter {
    @Override
    public String format(TimeSpan ts) {
        return String.join("",
                concat(ts.getDays(), "d "),
                concat(ts.getHours(), "h "),
                concat(ts.getMinutes(), "m "),
                concat(ts.getSeconds(), "s"))
                .trim();
    }

    private String concat(long value, String c) {
        return value > 0 ? value + c : "";
    }
}
