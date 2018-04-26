package org.ah.xutils.def;

import org.ah.xutils.def.formatters.Formatter;
import org.ah.xutils.def.formatters.TimeSpanLongAbbreviatedFormatter;
import org.ah.xutils.def.formatters.TimeSpanLongAbbreviatedNoDelimFormatter;
import org.ah.xutils.def.formatters.TimeSpanLongFormatter;
import org.ah.xutils.def.formatters.TimeSpanShortAbbreviatedFormatter;
import org.ah.xutils.def.formatters.TimeSpanShortAbbreviatedNoDelimFormatter;
import org.ah.xutils.def.formatters.TimeSpanShortFormatter;

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
	public String format(TimeSpanFormat timeSpanFormat) {
		StringBuilder sb = new StringBuilder();
		if (timeSpanFormat == null) {
			return sb.toString();
		}
		switch (timeSpanFormat) {
		case LONG:
			sb.append(format(new TimeSpanLongFormatter()));
			break;
		case LONG_ABR:
			sb.append(format(new TimeSpanLongAbbreviatedFormatter()));
			break;
		case LONG_ABR_NODELIM:
			sb.append(format(new TimeSpanLongAbbreviatedNoDelimFormatter()));
			break;
		case SHORT:
			sb.append(format(new TimeSpanShortFormatter()));
			break;
		case SHORT_ABR:
			sb.append(format(new TimeSpanShortAbbreviatedFormatter()));
			break;
		case SHORT_ABR_NODELIM:
			sb.append(format(new TimeSpanShortAbbreviatedNoDelimFormatter()));
			break;
		default:
			format(new TimeSpanLongFormatter());
			break;
		}
		return sb.toString();
	}

	@Override
	public String format(Formatter formatter) {
		return formatter.format(this);
	}

}
