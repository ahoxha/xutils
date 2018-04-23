package org.ah.def.formatters;

import org.ah.def.TimeSpan;

/**
 * This interface is used to define a formatter for a {@code TimeSpan} object.
 * 
 * @author armend
 *
 */
@FunctionalInterface
public interface Formatter {
	String format(TimeSpan ts);
}
