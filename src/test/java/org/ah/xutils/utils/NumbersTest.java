package org.ah.xutils.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;


class NumbersTest {

	static Collection<Double[]> parameters() {
		return Arrays.asList(new Double[][] {
				{ 2.3456, 2.35 },
				{ 0.001, 0.00 },
				{ 0.1234567, 0.12 },
				{ 0.0099999999999, 0.01 },
				{ 2.4, 2.4 },
				{ 12.351, 12.35 },
				{ 7.99, 7.99 } });
	}

	@ParameterizedTest
	@MethodSource("parameters")
	void testRoundOff(double input, double expected) {
		Assertions.assertEquals(expected, Numbers.roundOff(input,2), 0.001);
	}
}
