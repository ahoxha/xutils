package org.ah.xutils.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.Collection;

class NumbersTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/round_off_number_test_cases.csv", numLinesToSkip = 1)
    void testRoundOff(double input, double expected) {
        assertEquals(expected, Numbers.roundOff(input, 2), 0.001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/number_to_words_test_cases.csv", numLinesToSkip = 1)
    void testNumberToWords(int number, String words) {
        assertEquals(words, Numbers.toWords(number, " "));
    }
}
