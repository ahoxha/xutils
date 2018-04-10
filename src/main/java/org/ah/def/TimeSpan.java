package org.ah.def;

/**
 * Represents a period of time in days, hours, minutes, and seconds.
 * 
 * @author armend
 *
 */
public interface TimeSpan {
	/**
	 * Returns the number of days in this time span.
	 * 
	 */
	long getDays();

	/**
	 * Returns the number of hours in this time span.
	 */
	long getHours();

	/**
	 * Returns the number of minutes in this time span.
	 */
	long getMinutes();

	/**
	 * Returns the number of seconds in this time span.
	 */
	long getSeconds();

	/**
	 * Returns a formatted string of this TimeSpan.
	 * 
	 * @param timeSpanFormat
	 * @return
	 */
	String format(TimeSpanFormat timeSpanFormat);

	/**
	 * Converts the milliseconds into days, hours, minutes and seconds. Any left
	 * over milliseconds are truncated.
	 * 
	 * @param millis
	 *            Number of milliseconds.
	 * @return A {@link TimeSpan} object that represents a period of time.
	 */
	static TimeSpan create(long milliseconds) {
		return TimeSpanImpl.create(milliseconds);
	}
}
