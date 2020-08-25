package org.ah.xutils.utils;

import org.junit.jupiter.api.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;

class StringsTest {

    @Test
    void testDecodeBase64WithNonEmptyString() {
        String plain = "test";
        String encoded = Strings.encodeToBase64String(plain);
        assertEquals(plain, Strings.decodeBase64(encoded), "Wrong value");
    }

    @Test
    void testEncodeToBase64StringWithNonEmptyString() {
        String plain = "cosmic microwave background radiation";
        Encoder enc = Base64.getEncoder();
        assertEquals(enc.encodeToString(plain.getBytes(UTF_8)), Strings.encodeToBase64String(plain));
    }

    @Test
    void testEncodeToBase64StringFromBytes() {
        byte[] bytes = "test".getBytes(UTF_8);
        Encoder enc = Base64.getEncoder();

        assertEquals(enc.encodeToString(bytes), Strings.encodeToBase64String(bytes));
    }

    @Test
    void testToCamelCase1() {
        assertEquals("addNameAndSurname", Strings.toCamelCase("NAME_AND_SURNAME", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase2() {
        assertEquals("addName", Strings.toCamelCase("name", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase3() {
        assertEquals("addFirstName", Strings.toCamelCase("FIRST_NAME", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase4() {
        assertEquals("addNameAndSurnameAndMiddleName",
                Strings.toCamelCase("NAME_AND_SURNAME_AND_MIDDLE_NAME", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase5() {
        assertEquals("addAbCdAndA", Strings.toCamelCase("AB_cD_and_a", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase6() {
        assertEquals("addAbcDef", Strings.toCamelCase("_ABC_DEF", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase7() {
        assertEquals("addAbcDef", Strings.toCamelCase("ABC_DEF_", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase8() {
        assertEquals("addAbcDef", Strings.toCamelCase("_ABC_DEF_", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase9() {
        assertEquals("addABCD", Strings.toCamelCase("A_b_c_D", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase10() {
        assertEquals("CelsiusToFahrenheitConverter",
                Strings.toCamelCase("CELSIUS_TO_FAHRENHEIT_CONVERTER", ""), "Wrong value");
    }

    @Test
    void testToCamelCase11() {
        assertEquals("A", Strings.toCamelCase("a", ""), "Wrong value");
    }

    @Test
    void testToCamelCase12() {
        assertEquals("Test", Strings.toCamelCase("tESt", ""), "Wrong value");
    }

    @Test
    void testToCamelCase13() {
        assertEquals("", Strings.toCamelCase(null, ""), "Wrong value");
    }

    @Test
    void testToCamelCase14() {
        assertEquals("", Strings.toCamelCase("", ""), "Wrong value");
    }

    @Test
    void testToCamelCase15() {
        assertEquals("", Strings.toCamelCase("", "add"), "Wrong value");
    }

    @Test
    void testToCamelCase16() {
        assertEquals("", Strings.toCamelCase(null, null), "Wrong value");
    }

    @Test
    void testToCamelCase18() {
        assertEquals("", Strings.toCamelCase("test", null), "Wrong value");
    }

    @Test
    void testToCamelCaseWithoutPrefix1() {
        assertEquals("CosmicMicrowaveBackgroundRadiation",
                Strings.toCamelCase("COSMIC_MICROWAVE_BACKGROUND_RADIATION"));
    }

    @Test
    void testToCamelCaseWithoutPrefixWithSpace() {
        assertEquals("FirstName", Strings.toCamelCase("first name"));
    }

    @Test
    void testToCamelCaseWithoutPrefixWithHyphen() {
        assertEquals("LastName", Strings.toCamelCase("last-name"));
    }

    @Test
    void testToCamelCaseWithoutPrefixWithSpaceAndHyphen() {
        assertEquals("MyCustomClass", Strings.toCamelCase("my custom -class"));
    }

    @Test
    void testCamelCaseWithoutPrefixWithColon() {
        assertEquals("MyCustomClass", Strings.toCamelCase("my:custom:class"));
    }

    @Test
    void testCamelCaseWithoutPrefixWithSemicolon() {
        assertEquals("MyCustomClass", Strings.toCamelCase("My;custoM;class"));
    }

    @Test
    void testCamelCaseWithoutPrefixWithSemicolon1() {
        assertEquals("MyCustomClass", Strings.toCamelCase("My;custoM;class;"));
    }

    @Test
    void testCamleCaseWithoutPrefixWithEqualSign() {
        assertEquals("MyCustomClass", Strings.toCamelCase("my=custom=class"));
    }
}
