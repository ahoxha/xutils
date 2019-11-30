package org.ah.xutils.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;


class NumbersTest {

    static Collection<Double[]> parameters() {
        return Arrays.asList(new Double[][]{
                {2.3456, 2.35},
                {0.001, 0.00},
                {0.1234567, 0.12},
                {0.0099999999999, 0.01},
                {2.4, 2.4},
                {12.351, 12.35},
                {7.99, 7.99}});
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRoundOff(double input, double expected) {
        Assertions.assertEquals(expected, Numbers.roundOff(input, 2), 0.001);
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndWords")
    void testNumberToWords(NumberToWordsInput input) {
        Assertions.assertEquals(input.words, Numbers.toWords(input.number, " "));
    }

    static Stream<NumberToWordsInput> getNumbersAndWords() {
        return Stream.of(
                new NumberToWordsInput(1, "one"),
                new NumberToWordsInput(2, "two"),
                new NumberToWordsInput(3, "three"),
                new NumberToWordsInput(4, "four"),
                new NumberToWordsInput(5, "five"),
                new NumberToWordsInput(6, "six"),
                new NumberToWordsInput(7, "seven"),
                new NumberToWordsInput(8, "eight"),
                new NumberToWordsInput(9, "nine"),
                new NumberToWordsInput(10, "ten"),
                new NumberToWordsInput(11, "eleven"),
                new NumberToWordsInput(12, "twelve"),
                new NumberToWordsInput(13, "thirteen"),
                new NumberToWordsInput(14, "fourteen"),
                new NumberToWordsInput(15, "fifteen"),
                new NumberToWordsInput(16, "sixteen"),
                new NumberToWordsInput(17, "seventeen"),
                new NumberToWordsInput(18, "eighteen"),
                new NumberToWordsInput(19, "nineteen"),
                new NumberToWordsInput(20, "twenty"),
                new NumberToWordsInput(30, "thirty"),
                new NumberToWordsInput(40, "forty"),
                new NumberToWordsInput(50, "fifty"),
                new NumberToWordsInput(60, "sixty"),
                new NumberToWordsInput(70, "seventy"),
                new NumberToWordsInput(80, "eighty"),
                new NumberToWordsInput(90, "ninety"),
                new NumberToWordsInput(21, "twenty one"),
                new NumberToWordsInput(45, "forty five"),
                new NumberToWordsInput(93, "ninety three"),
                new NumberToWordsInput(100, "one hundred"),
                new NumberToWordsInput(106, "one hundred and six"),
                new NumberToWordsInput(132, "one hundred and thirty two"),
                new NumberToWordsInput(200, "two hundred"),
                new NumberToWordsInput(201, "two hundred and one"),
                new NumberToWordsInput(260, "two hundred and sixty"),
                new NumberToWordsInput(264, "two hundred and sixty four"),
                new NumberToWordsInput(1000, "one thousand"),
                new NumberToWordsInput(1000000, "one million"),
                new NumberToWordsInput(1002, "one thousand and two"),
                new NumberToWordsInput(1083, "one thousand and eighty three"),
                new NumberToWordsInput(1050, "one thousand and fifty"),
                new NumberToWordsInput(1300, "one thousand and three hundred"),
                new NumberToWordsInput(1307, "one thousand and three hundred and seven"),
                new NumberToWordsInput(1362, "one thousand and three hundred and sixty two"),
                new NumberToWordsInput(200_000_000, "two hundred million"),
                new NumberToWordsInput(231_000_056, "two hundred and thirty one million and fifty six"),
                new NumberToWordsInput(231_523_444,
						"two hundred and thirty one million and five hundred and twenty three thousand and four hundred and forty four"),
                new NumberToWordsInput(1000000000, "N/A")
        );
    }

    static class NumberToWordsInput {
        public final int number;
        public final String words;

        public NumberToWordsInput(int number, String words) {
            this.number = number;
            this.words = words;
        }

        @Override
        public String toString() {
            return number + ": " + words;
        }
    }
}
