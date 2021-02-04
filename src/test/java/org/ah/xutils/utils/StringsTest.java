package org.ah.xutils.utils;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest(name = "String: ''{0}'' with prefix: ''{1}'' must be converted into: ''{2}''")
    @MethodSource("getInputArgumentsWithPrefix")
    void testToCamelCaseWithPrefix(String input, String prefix, String expectedOutput) {
        assertEquals(expectedOutput, Strings.toCamelCase(input, prefix));
    }

    private static Stream<Arguments> getInputArgumentsWithPrefix() {
        return Stream.of( //
                of("NAME_AND_SURNAME", "add", "addNameAndSurname"), //
                of("name", "add", "addName"), //
                of("FIRST_NAME", "add", "addFirstName"), //
                of("NAME_AND_SURNAME_AND_MIDDLE_NAME", "add", "addNameAndSurnameAndMiddleName"),//
                of("AB_cD_and_a", "add", "addAbCdAndA"), //
                of("_ABC_DEF", "add", "addAbcDef"), //
                of("ABC_DEF_", "add", "addAbcDef"), //
                of("_ABC_DEF_", "add", "addAbcDef"), //
                of("A_b_c_D", "add", "addABCD"), //
                of("CELSIUS_TO_FAHRENHEIT_CONVERTER", "", "CelsiusToFahrenheitConverter"), //
                of("a", "", "A"), //
                of("tESt", "", "Test"), //
                of(null, "", ""), //
                of("", "", ""), //
                of("", "add", ""), //
                of(null, null, ""), //
                of("test", null, "") //
        );
    }

    @ParameterizedTest(name = "''{0}'' must be converted into ''{1}''")
    @MethodSource("getInputArgumentsWithoutPrefix")
    void testToCamelCaseWithoutPrefix(String input, String expectedOutput) {
        assertEquals(expectedOutput, Strings.toCamelCase(input));
    }

    private static Stream<Arguments> getInputArgumentsWithoutPrefix() {
        return Stream.of( //
                of("COSMIC_MICROWAVE_BACKGROUND_RADIATION", "CosmicMicrowaveBackgroundRadiation"), //
                of("first name", "FirstName"), //
                of("last-name", "LastName"), //
                of("my custom -class", "MyCustomClass"), //
                of("my:custom:class", "MyCustomClass"), //
                of("My;custoM;class", "MyCustomClass"), //
                of("My;custoM;class;", "MyCustomClass"), //
                of("my=custom=class", "MyCustomClass") //
        );
    }
}
