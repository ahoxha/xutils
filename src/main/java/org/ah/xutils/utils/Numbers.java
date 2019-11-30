package org.ah.xutils.utils;

/**
 * Provides utility methods to manipulate numbers.
 * 
 * @author armend
 *
 */
public final class Numbers {
	private Numbers() {
		// prevent instantiation
	}

	/**
	 * Rounds a decimal point number to a certain number of digits, as indicated
	 * by the {@code decimals} parameter. If the number contains fewer than
	 * {@code decimals} digits, then the original number is returned.
	 * 
	 * @param d
	 *            The number to be rounded off.
	 * @param decimals
	 *            The number of digits after the decimal point that {@code d}
	 *            should be rounded to.
	 * @return A {@code double} value of {@code d} rounded off to
	 *         {@code decimals} digits.
	 */
	public static double roundOff(double d, int decimals) {
		double p = Math.pow(10, decimals);
		return Math.round(d * p) / p;
	}
}
