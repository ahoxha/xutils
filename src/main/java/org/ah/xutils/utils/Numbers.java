package org.ah.xutils.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides utility methods to manipulate numbers.
 *
 * @author armend
 */
public final class Numbers {
    static Map<Integer, String> basics = new HashMap<>();
    static Map<Integer, String> tens = new HashMap<>();
    static String hundred = "hundred";
    static String thousand = "thousand";
    static String million = "million";

    static {
        populateBasics();
        populateTens();
    }

    private static void populateTens() {
        tens.put(10, "ten");
        tens.put(20, "twenty");
        tens.put(30, "thirty");
        tens.put(40, "forty");
        tens.put(50, "fifty");
        tens.put(60, "sixty");
        tens.put(70, "seventy");
        tens.put(80, "eighty");
        tens.put(90, "ninety");
    }

    private static void populateBasics() {
        basics.put(0, "");
        basics.put(1, "one");
        basics.put(2, "two");
        basics.put(3, "three");
        basics.put(4, "four");
        basics.put(5, "five");
        basics.put(6, "six");
        basics.put(7, "seven");
        basics.put(8, "eight");
        basics.put(9, "nine");
        basics.put(10, "ten");
        basics.put(11, "eleven");
        basics.put(12, "twelve");
        basics.put(13, "thirteen");
        basics.put(14, "fourteen");
        basics.put(15, "fifteen");
        basics.put(16, "sixteen");
        basics.put(17, "seventeen");
        basics.put(18, "eighteen");
        basics.put(19, "nineteen");
        basics.put(20, "twenty");
    }

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
        String res = "N/A";
        if (number >= 0 && number <= 20) {
            res = basics.get(number);
        } else if (number < 100) {
            int tens = (number / 10) * 10;
            res = Numbers.tens.get(tens);
            int ones = number - tens;
            if (ones > 0) {
                res += delimiter + basics.get(ones);
            }
        } else if (number < 1000) {
            int hundreds = number / 100;
            res = basics.get(hundreds) + delimiter + hundred;
            int rest = number - hundreds * 100;
            if (rest < 20 && rest > 0) {
                res += delimiter + "and" + delimiter + basics.get(rest);
            } else {
                int tenth = ((number - hundreds * 100) / 10) * 10;
                if (tenth > 0) {
                    res += delimiter + "and" + delimiter + tens.get(tenth);
                }
                int basic = number - hundreds * 100 - tenth;
                if (basic > 0) {
                    res += delimiter + basics.get(basic);
                }
            }
        } else if (number < 1_000_000) {
            int thousands = number / 1000;
            res = toWords(thousands, delimiter) + delimiter + thousand + (number - thousands * 1000 > 0 ? delimiter + "and" + delimiter : "")
                    + toWords(number - thousands * 1000, delimiter);
        } else if (number < 1_000_000_000) {
            int millions = number / 1000000;
            res = toWords(millions, delimiter) + delimiter + million + (number - millions * 1000000 > 0 ? delimiter + "and" + delimiter : "")
                    + toWords(number - millions * 1000000, delimiter);
        }
        return res;
    }
}
