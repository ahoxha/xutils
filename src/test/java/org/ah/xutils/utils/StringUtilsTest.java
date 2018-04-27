package org.ah.xutils.utils;

import java.util.Base64;
import java.util.Objects;
import java.util.Base64.Encoder;

import org.ah.xutils.utils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

	@Test
	public void testDecodeBase64WithNonEmptyString() {
		String plain = "test";
		String encoded = StringUtils.encodeToBase64String(plain);
		assertEquals("Wrong value", plain, StringUtils.decodeBase64(encoded));
	}

	@Test
	public void testEncodeToBase64StringWithNonEmptyString() {
		String plain = "cosmic microwave background radiation";
		Encoder enc = Base64.getEncoder();
		assertTrue(Objects.equals(enc.encodeToString(plain.getBytes()), StringUtils.encodeToBase64String(plain)));
	}

	@Test
	public void testToCamelCase1() {
		assertEquals("Wrong value", "addNameAndSurname", StringUtils.toCamelCase("NAME_AND_SURNAME", "add"));
	}

	@Test
	public void testToCamelCase2() {
		assertEquals("Wrong value", "addName", StringUtils.toCamelCase("name", "add"));
	}

	@Test
	public void testToCamelCase3() {
		assertEquals("Wrong value", "addFirstName", StringUtils.toCamelCase("FIRST_NAME", "add"));
	}

	@Test
	public void testToCamelCase4() {
		assertEquals("Wrong value", "addNameAndSurnameAndMiddleName",
				StringUtils.toCamelCase("NAME_AND_SURNAME_AND_MIDDLE_NAME", "add"));
	}

	@Test
	public void testToCamelCase5() {
		assertEquals("Wrong value", "addAbCdAndA", StringUtils.toCamelCase("AB_cD_and_a", "add"));
	}

	@Test
	public void testToCamelCase6() {
		assertEquals("Wrong value", "addAbcDef", StringUtils.toCamelCase("_ABC_DEF", "add"));
	}

	@Test
	public void testToCamelCase7() {
		assertEquals("Wrong value", "addAbcDef", StringUtils.toCamelCase("ABC_DEF_", "add"));
	}

	@Test
	public void testToCamelCase8() {
		assertEquals("Wrong value", "addAbcDef", StringUtils.toCamelCase("_ABC_DEF_", "add"));
	}

	@Test
	public void testToCamelCase9() {
		assertEquals("Wrong value", "addABCD", StringUtils.toCamelCase("A_b_c_D", "add"));
	}

	@Test
	public void testToCamelCase10() {
		assertEquals("Wrong value", "CelsiusToFahrenheitConverter",
				StringUtils.toCamelCase("CELSIUS_TO_FAHRENHEIT_CONVERTER", ""));
	}

	@Test
	public void testToCamelCase11() {
		assertEquals("Wrong value", "A", StringUtils.toCamelCase("a", ""));
	}

	@Test
	public void testToCamelCase12() {
		assertEquals("Wrong value", "Test", StringUtils.toCamelCase("tESt", ""));
	}

	@Test
	public void testToCamelCase13() {
		assertEquals("Wrong value", "", StringUtils.toCamelCase(null, ""));
	}

	@Test
	public void testToCamelCase14() {
		assertEquals("Wrong value", "", StringUtils.toCamelCase("", ""));
	}

	@Test
	public void testToCamelCase15() {
		assertEquals("Wrong value", "", StringUtils.toCamelCase("", "add"));
	}

	@Test
	public void testToCamelCase16() {
		assertEquals("Wrong value", "", StringUtils.toCamelCase(null, null));
	}

	@Test
	public void testToCamelCase18() {
		assertEquals("Wrong value", "", StringUtils.toCamelCase("test", null));
	}

	@Test
	public void testToCamelCaseWithoutPrefix1() {
		assertEquals("CosmicMicrowaveBackgroundRadiation",
				StringUtils.toCamelCase("COSMIC_MICROWAVE_BACKGROUND_RADIATION"));
	}
	
	@Test
	public void testToCamelCaseWithoutPrefixWithSpace() {
		assertEquals("FirstName",StringUtils.toCamelCase("first name"));
	}
	
	@Test
	public void testToCamelCaseWithoutPrefixWithHyphen(){
		assertEquals("LastName", StringUtils.toCamelCase("last-name"));
	}
	
	@Test
	public void testToCamelCaseWithoutPrefixWithSpaceAndHyphen(){
		assertEquals("MyCustomClass", StringUtils.toCamelCase("my custom -class"));
	}
	
	@Test
	public void testCamelCaseWithoutPrefixWithColon(){
		assertEquals("MyCustomClass", StringUtils.toCamelCase("my:custom:class"));
	}
	
	@Test
	public void testCamelCaseWithoutPrefixWithSemicolon(){
		assertEquals("MyCustomClass", StringUtils.toCamelCase("My;custoM;class"));
	}
	
	@Test
	public void testCamelCaseWithoutPrefixWithSemicolon1(){
		assertEquals("MyCustomClass", StringUtils.toCamelCase("My;custoM;class;"));
	}
	
	@Test
	public void testCamleCaseWithoutPrefixWithEqualSign(){
		assertEquals("MyCustomClass", StringUtils.toCamelCase("my=custom=class"));
	}
}
