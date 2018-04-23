package org.ah.def.formatters;

import org.ah.def.TimeSpan;

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
		return new StringBuilder()
				.append(ts.getDays())
				.append(" days, ")
				.append(ts.getHours()).append(" hours, ")
				.append(ts.getMinutes()).append(" minutes, ")
				.append(ts.getSeconds()).append(" seconds")
				.toString();
	}
}
