package org.ah.def;

import org.ah.def.formatters.Formatter;
import org.ah.def.formatters.TimeSpanLongAbbreviatedFormatter;
import org.ah.def.formatters.TimeSpanLongFormatter;

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

	private void formatLongAbrNoDelim(StringBuilder sb, long days, long hours, long minutes, long seconds) {
		sb.append(days).append("d ").append(hours).append("h ").append(minutes).append("m ").append(seconds)
				.append("s");
	}

	private void formatShort(StringBuilder sb, long days, long hours, long minutes, long seconds) {
		if (days > 0) {
			sb.append(days).append(" days, ");
		}
		if (hours > 0) {
			sb.append(hours).append(" hours, ");
		}
		if (minutes > 0) {
			sb.append(minutes).append(" minutes, ");
		}
		if (seconds > 0) {
			sb.append(seconds).append(" seconds");
		}
		if (sb.lastIndexOf(",") == sb.length() - 2) {
			sb.replace(sb.length() - 2, sb.length(), "");
		}
	}

	private void formatShortAbr(StringBuilder sb, long days, long hours, long minutes, long seconds) {
		if (days > 0) {
			sb.append(days).append("d, ");
		}
		if (hours > 0) {
			sb.append(hours).append("h, ");
		}
		if (minutes > 0) {
			sb.append(minutes).append("m, ");
		}
		if (seconds > 0) {
			sb.append(seconds).append("s");
		}
		if (sb.lastIndexOf(",") == sb.length() - 2) {
			sb.replace(sb.length() - 2, sb.length(), "");
		}
	}

	private void formatShortAbrNoDelim(StringBuilder sb, long days, long hours, long minutes, long seconds) {
		if (days > 0) {
			sb.append(days).append("d ");
		}
		if (hours > 0) {
			sb.append(hours).append("h ");
		}
		if (minutes > 0) {
			sb.append(minutes).append("m ");
		}
		if (seconds > 0) {
			sb.append(seconds).append("s");
		}
		if (sb.lastIndexOf(" ") == sb.length() - 1) {
			sb.replace(sb.length() - 1, sb.length(), "");
		}
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
			formatLongAbrNoDelim(sb, days, hours, minutes, seconds);
			break;
		case SHORT:
			formatShort(sb, days, hours, minutes, seconds);
			break;
		case SHORT_ABR:
			formatShortAbr(sb, days, hours, minutes, seconds);
			break;
		case SHORT_ABR_NODELIM:
			formatShortAbrNoDelim(sb, days, hours, minutes, seconds);
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
