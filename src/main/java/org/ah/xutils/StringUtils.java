package org.ah.xutils;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

	private StringUtils() {
		// prevent instantiation
	}

	public static String decodeBase64(String encodedString) {
		Decoder dec = Base64.getDecoder();
		return new String(dec.decode(encodedString.getBytes()));
	}

	public static String encodeToBase64String(String text) {
		Encoder enc = Base64.getEncoder();
		return enc.encodeToString(text.getBytes());
	}

	public static String encodeToBase64String(byte[] bytes) {
		Encoder enc = Base64.getEncoder();
		return enc.encodeToString(bytes);
	}

	/**
	 * Converts a UTF-8 string into CamelCase, it is useful when converting enum
	 * names into CamelCase strings, for example FIRST_NAME will be converted to
	 * FristName, NAME will be converted to Name etc. If you provide a prefix,
	 * it will be prepended to the CamelCase result. For example:
	 * toCamelCase("FIRST_NAME", "add") returns addFirstName. This is useful to
	 * convert enum names into method names.
	 * 
	 * @param str
	 *            the string to me converted.
	 * @param prefix
	 *            the string that precedes the result.
	 * @return a string in CamelCase format preceded by the prefix. If either
	 *         str or prefix is null, an empty string is returned.If str is
	 *         empty, regardles of the prefix's value, an empty string is
	 *         returned.
	 */
	public static String toCamelCase(String str, String prefix) {
		if (str == null || prefix == null) {
			return "";
		}
		if (str.isEmpty()) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		Pattern p = Pattern.compile("([A-Za-z]*)[_ -.:;=]([A-Za-z]+)");
		Matcher matcher = p.matcher(str);
		while (matcher.find()) {
			for (int i = 1; i <= matcher.groupCount(); i++) {
				if (!matcher.group(i).isEmpty()) {
					sb.append(matcher.group(i).substring(0, 1).toUpperCase())
							.append(matcher.group(i).substring(1).toLowerCase());
				}
			}
		}

		if (Objects.equals(sb.toString(), prefix)) {
			str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * Converts a UTF-8 string into CamelCase, it is useful when converting enum
	 * names into CamelCase strings, for example FIRST_NAME will be converted to
	 * FristName, NAME will be converted to Name etc.
	 * 
	 * @param str
	 *            the string to me converted.
	 * @return a string in CamelCase format preceded. If str is null or empty,
	 *         an empty string will be returned.
	 */
	public static String toCamelCase(String str) {
		return toCamelCase(str, "");
	}
}
