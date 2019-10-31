package org.ah.xutils.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;

class StringUtilsTest {

    @Test
    void testDecodeBase64WithNonEmptyString() {
        String plain = "test";
        String encoded = StringUtils.encodeToBase64String(plain);
        assertEquals(plain, StringUtils.decodeBase64(encoded), "Wrong value");
    }

    @Test
    void testEncodeToBase64StringWithNonEmptyString() {
        String plain = "cosmic microwave background radiation";
        Encoder enc = Base64.getEncoder();
        assertEquals(enc.encodeToString(plain.getBytes(StandardCharsets.UTF_8)), StringUtils.encodeToBase64String(plain));
    }

    @Test
    void testToCamelCase1() {
        assertEquals("addNameAndSurname", StringUtils.toCamelCase("NAME_AND_SURNAME", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase2() {
        assertEquals("addName", StringUtils.toCamelCase("name", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase3() {
        assertEquals("addFirstName", StringUtils.toCamelCase("FIRST_NAME", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase4() {
        assertEquals("addNameAndSurnameAndMiddleName",
                StringUtils.toCamelCase("NAME_AND_SURNAME_AND_MIDDLE_NAME", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase5() {
        assertEquals("addAbCdAndA", StringUtils.toCamelCase("AB_cD_and_a", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase6() {
        assertEquals("addAbcDef", StringUtils.toCamelCase("_ABC_DEF", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase7() {
        assertEquals("addAbcDef", StringUtils.toCamelCase("ABC_DEF_", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase8() {
        assertEquals("addAbcDef", StringUtils.toCamelCase("_ABC_DEF_", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase9() {
        assertEquals("addABCD", StringUtils.toCamelCase("A_b_c_D", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase10() {
        assertEquals("CelsiusToFahrenheitConverter",
                StringUtils.toCamelCase("CELSIUS_TO_FAHRENHEIT_CONVERTER", ""), "Wrong value");
    }

    @Test
    void testToCamelCase11() {
        assertEquals("A", StringUtils.toCamelCase("a", ""), "Wrong value");
    }

    @Test
    void testToCamelCase12() {
        assertEquals("Test", StringUtils.toCamelCase("tESt", ""), "Wrong value");
    }

    @Test
    void testToCamelCase13() {
        assertEquals("", StringUtils.toCamelCase(null, ""), "Wrong value");
    }

    @Test
    void testToCamelCase14() {
        assertEquals("", StringUtils.toCamelCase("", ""), "Wrong value");
    }

    @Test
    void testToCamelCase15() {
        assertEquals("", StringUtils.toCamelCase("", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase16() {
        assertEquals("", StringUtils.toCamelCase(null, null), "Wrong value");
    }

    @Test
    void testToCamelCase18() {
        assertEquals("", StringUtils.toCamelCase("test", null), "Wrong value");
    }

    @Test
    void testToCamelCaseWithoutPrefix1() {
        assertEquals("CosmicMicrowaveBackgroundRadiation",
                StringUtils.toCamelCase("COSMIC_MICROWAVE_BACKGROUND_RADIATION"));
    }

    @Test
    void testToCamelCaseWithoutPrefixWithSpace() {
        assertEquals("FirstName", StringUtils.toCamelCase("first name"));
    }

    @Test
    void testToCamelCaseWithoutPrefixWithHyphen() {
        assertEquals("LastName", StringUtils.toCamelCase("last-name"));
    }

    @Test
    void testToCamelCaseWithoutPrefixWithSpaceAndHyphen() {
        assertEquals("MyCustomClass", StringUtils.toCamelCase("my custom -class"));
    }

    @Test
    void testCamelCaseWithoutPrefixWithColon() {
        assertEquals("MyCustomClass", StringUtils.toCamelCase("my:custom:class"));
    }

    @Test
    void testCamelCaseWithoutPrefixWithSemicolon() {
        assertEquals("MyCustomClass", StringUtils.toCamelCase("My;custoM;class"));
    }

    @Test
    void testCamelCaseWithoutPrefixWithSemicolon1() {
        assertEquals("MyCustomClass", StringUtils.toCamelCase("My;custoM;class;"));
    }

    @Test
    void testCamleCaseWithoutPrefixWithEqualSign() {
        assertEquals("MyCustomClass", StringUtils.toCamelCase("my=custom=class"));
    }
}
