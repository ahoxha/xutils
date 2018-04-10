package org.ah.def;

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
		if(timeSpanFormat == null) {
			return sb.toString();
		}
		switch (timeSpanFormat) {
		case LONG:
			sb.append(days).append(" days, ")
			.append(hours).append(" hours, ")
			.append(minutes).append(" minutes, ")
			.append(seconds).append(" seconds");
			break;
		case LONG_ABR:
			sb.append(days).append(" d, ")
			.append(hours).append(" h, ")
			.append(minutes).append(" m, ")
			.append(seconds).append(" s");
			break;
		case LONG_ABR_NODELIM:
			sb.append(days).append("d ")
			.append(hours).append("h ")
			.append(minutes).append("m ")
			.append(seconds).append("s");
			break;
		case SHORT:
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
			break;
		case SHORT_ABR:
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
			break;
		case SHORT_ABR_NODELIM:
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
			break;
		default:
			sb.append(days).append(" days, ")
			.append(hours).append(" hours, ")
			.append(minutes).append(" minutes, ")
			.append(seconds).append(" seconds");
			break;
		}
		return sb.toString();
	}

}
