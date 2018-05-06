package org.ah.xutils.utils;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberUtilsTest {
	@Parameter(0)
	public double input;

	@Parameter(1)
	public double expected;

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] { { 2.3456, 2.35 }, { 0.001, 0.00 }, { 0.1234567, 0.12 },
				{ 0.0099999999999, 0.01 }, { 2.4, 2.4 }, { 12.351, 12.35 }, { 7.99, 7.99 } });
	}

	@Test
	public void testRoundOff() {
		assertEquals(expected, NumberUtils.roundOff(input, 2), 0.001);
	}
}
