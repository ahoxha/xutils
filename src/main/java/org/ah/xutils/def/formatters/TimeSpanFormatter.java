package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

@FunctionalInterface
public interface TimeSpanFormatter {
    String format(TimeSpan ts);
}
