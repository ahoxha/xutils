package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

/**
 * This interface is used to define a formatter for a {@code TimeSpan} object.
 *
 * @author armend
 */
@FunctionalInterface
public interface Formatter {
    String format(TimeSpan ts);
}
