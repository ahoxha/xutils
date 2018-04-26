package org.ah.xutils.def;

import org.ah.xutils.def.formatters.Formatter;

class TimeSpanImpl implements TimeSpan {

	private long days;
	private long hours;
	private long minutes;
	private long seconds;

	private TimeSpanImpl(long millis) {
		days = millis / 1000 / 60 / 60 / 24;
		millis = millis - InMilliseconds.days(days);
		if (millis > 0) {
			hours = millis / 1000 / 60 / 60;
			millis = millis - InMilliseconds.hours(hours);
			if (millis > 0) {
				minutes = millis / 1000 / 60;
				millis = millis - InMilliseconds.minutes(minutes);
				if (millis > 0) {
					seconds = millis / 1000;
				}
			}
		}
	}

	public static TimeSpan create(long millis) {
		return new TimeSpanImpl(millis);
	}

	@Override
	public long getDays() {
		return days;
	}

	@Override
	public long getHours() {
		return hours;
	}

	@Override
	public long getMinutes() {
		return minutes;
	}

	@Override
	public long getSeconds() {
		return seconds;
	}

	@Override
	public String format(Formatter formatter) {
		return formatter.format(this);
	}

}
