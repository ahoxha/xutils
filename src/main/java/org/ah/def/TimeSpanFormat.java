package org.ah.def;

/**
 * This enum defines several formats for a TimeSpan representation of a period
 * of time, for example:
 * <ul>
 * <li>2 days, 3 hours, 12 minutes, 4 seconds</li>
 * <li>12d, 4h, 0m, 0s</li>
 * <li>12d, 4h</li>
 * </ul>
 * 
 * @author armend
 *
 */
public enum TimeSpanFormat {
	/**
	 * The full representation of TimeSpan, it shows 0-valued units as well:
	 * <p>
	 * 4 days, 0 hours, 0 minutes, 5 seconds
	 */
	LONG,
	/**
	 * The full representation of TimeSpan, it shows 0-valued units as well.
	 * Words are abbreviated (d - for days, h - for hours, m - for minutes, s -
	 * for seconds):
	 * <p>
	 * 4d, 0h, 0m, 5s
	 */
	LONG_ABR,
	/**
	 * The full representation of TimeSpan, it shows 0's as well. Words are
	 * abbreviated (d - for days, h - for hours, m - for minutes, s - for
	 * seconds), but there is no delimiter in between:
	 * <p>
	 * 4d 0h 0m 5s
	 */
	LONG_ABR_NODELIM,
	/**
	 * 4 days, 5 seconds
	 */
	SHORT,
	/**
	 * 4d, 5s
	 */
	SHORT_ABR,
	/**
	 * 4d 5s
	 */
	SHORT_ABR_NODELIM,
	/**
	 * Same as LONG.
	 */
	DEFAULT
}
