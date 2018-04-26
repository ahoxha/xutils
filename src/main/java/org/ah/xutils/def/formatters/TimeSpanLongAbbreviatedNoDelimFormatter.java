package org.ah.xutils.def.formatters;

import org.ah.xutils.def.TimeSpan;

public class TimeSpanLongAbbreviatedNoDelimFormatter implements Formatter{
	@Override
	public String format(TimeSpan ts) {
		return new StringBuilder()
				.append(ts.getDays()).append("d ")
				.append(ts.getHours()).append("h ")
				.append(ts.getMinutes()).append("m ")
				.append(ts.getSeconds()).append("s")
				.toString();
	}
}
