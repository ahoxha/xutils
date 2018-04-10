package org.ah.def;

/**
 * Provides methods to easily convert days, hours, minutes and seconds into
 * milliseconds.
 * 
 * @author armend
 *
 */
public final class InMilliseconds {
	private InMilliseconds() {
		// Prevent instantiation
	}

	/**
	 * Converts days into milliseconds.
	 * 
	 * @param value
	 *            Number of days.
	 * @return Number of milliseconds in 'value' days.
	 */
	public static long days(long value) {
		return value * 24 * 60 * 60 * 1000;
	}

	/**
	 * Converts hours into milliseconds.
	 * 
	 * @param value
	 *            Number of hours.
	 * @return Number of milliseconds in 'value' hours.
	 */
	public static long hours(long value) {
		return value * 60 * 60 * 1000;
	}

	/**
	 * Converts minutes into milliseconds.
	 * 
	 * @param value
	 *            Number of minutes.
	 * @return Number of milliseconds in 'value' minutes.
	 */
	public static long minutes(long value) {
		return value * 60 * 1000;
	}

	/**
	 * Converts seconds into milliseconds.
	 * 
	 * @param value
	 *            Number of seconds.
	 * @return Number of milliseconds in 'value' seconds.
	 */
	public static long seconds(long value) {
		return value * 1000;
	}
}
