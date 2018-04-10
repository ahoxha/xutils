package org.ah.utils;

import org.ah.def.TimeSpan;

public final class TimeUtils {

	private TimeUtils() {
		// prevent instantiation
	}

	/**
	 * Find the time span between start and end.
	 * 
	 * @param start
	 *            Start time in milliseconds.
	 * @param end
	 *            End time in milliseconds.
	 * @return A TimeSpan object that represents the duration in days, hours,
	 *         minutes and seconds (any leftover milliseconds are truncated).
	 * @throws IllegalArgumentException
	 *             If end time is smaller than start time.
	 */
	public static TimeSpan diff(long start, long end) throws IllegalArgumentException {
		if (end < start) {
			throw new IllegalArgumentException("The value for 'end' is smaller than the value for 'start'.");
		}
		return TimeSpan.create(end - start);
	}
}
