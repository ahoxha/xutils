package org.ah.xutils.utils;

/**
 * Provides utility methods to manipulate numbers.
 *
 * @author armend
 */
public final class Numbers {

    private Numbers() {
    }

    /**
     * Rounds a decimal point number to a certain number of digits, as indicated
     * by the {@code decimals} parameter. If the number contains fewer than
     * {@code decimals} digits, then the original number is returned.
     *
     * @param d        The number to be rounded off.
     * @param decimals The number of digits after the decimal point that {@code d}
     *                 should be rounded to.
     * @return A {@code double} value of {@code d} rounded off to
     * {@code decimals} digits.
     */
    public static double roundOff(double d, int decimals) {
        double p = Math.pow(10, decimals);
        return Math.round(d * p) / p;
    }

    /**
     * Converts an integer number into its word representation, for example: 10 is converted to 'ten'.
     *
     * @param number    The number to be converted.
     * @param delimiter A string that is put between words, usually a space, but it can be any string. Examples: 'twenty one', 'twenty-one', 'twenty_one'.
     */
    public static String toWords(int number, String delimiter) {
        String numInWords = "N/A";
        if (number >= 0 && number <= 20) {
            numInWords = NumberAsWord.get(number);
        } else if (number < 100) {
            int tens = (number / 10) * 10;
            numInWords = NumberAsWord.get(tens);
            int ones = number - tens;
            if (ones > 0) {
                numInWords += delimiter + NumberAsWord.get(ones);
            }
        } else if (number < 1000) {
            int hundreds = number / 100;
            numInWords = NumberAsWord.get(hundreds) + delimiter + NumberAsWord.get(100);
            int rest = number - hundreds * 100;
            if (rest < 20 && rest > 0) {
                numInWords += delimiter + "and" + delimiter + NumberAsWord.get(rest);
            } else {
                int tenth = ((number - hundreds * 100) / 10) * 10;
                if (tenth > 0) {
                    numInWords += delimiter + "and" + delimiter + NumberAsWord.get(tenth);
                }
                int basic = number - hundreds * 100 - tenth;
                if (basic > 0) {
                    numInWords += delimiter + NumberAsWord.get(basic);
                }
            }
        } else if (number < 1_000_000) {
            int thousands = number / 1000;
            numInWords = toWords(thousands, delimiter) + delimiter + NumberAsWord.get(1000) +
                    (number - thousands * 1000 > 0 ? delimiter + "and" + delimiter : "")
                    + toWords(number - thousands * 1000, delimiter);
        } else if (number < 1_000_000_000) {
            int millions = number / 1_000_000;
            numInWords = toWords(millions, delimiter) + delimiter + NumberAsWord.get(1_000_000) +
                    (number - millions * 1_000_000 > 0 ? delimiter + "and" + delimiter : "")
                    + toWords(number - millions * 1_000_000, delimiter);
        }
        return numInWords;
    }
}
