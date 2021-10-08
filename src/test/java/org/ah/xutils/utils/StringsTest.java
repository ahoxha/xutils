package org.ah.xutils.utils;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.ah.xutils.utils.StringsTest.ArgumentsUtil.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
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

    @ParameterizedTest(name = "''{0}'' must be converted into ''{1}''")
    @MethodSource("getInputArgumentsWithoutPrefix")
    void testToCamelCaseWithoutPrefix(String input, String expectedOutput) {
        assertEquals(expectedOutput, Strings.toCamelCase(input));
    }

    private static Stream<Arguments> getInputArgumentsWithPrefix() {
        return Stream.of( //
                given("NAME_AND_SURNAME") //
                        .withPrefix("add") //
                        .thenExpect("addNameAndSurname"), //
                given("name") //
                        .withPrefix("add") //
                        .thenExpect("addName"), //
                given("FIRST_NAME") //
                        .withPrefix("add") //
                        .thenExpect("addFirstName"), //
                given("NAME_AND_SURNAME_AND_MIDDLE_NAME") //
                        .withPrefix("add") //
                        .thenExpect("addNameAndSurnameAndMiddleName"),//
                given("AB_cD_and_a") //
                        .withPrefix("add") //
                        .thenExpect("addAbCdAndA"), //
                given("_ABC_DEF") //
                        .withPrefix("add") //
                        .thenExpect("addAbcDef"), //
                given("ABC_DEF_") //
                        .withPrefix("add") //
                        .thenExpect("addAbcDef"), //
                given("_ABC_DEF_") //
                        .withPrefix("add") //
                        .thenExpect("addAbcDef"), //
                given("A_b_c_D") //
                        .withPrefix("add") //
                        .thenExpect("addABCD"), //
                given("CELSIUS_TO_FAHRENHEIT_CONVERTER") //
                        .withPrefix("") //
                        .thenExpect("CelsiusToFahrenheitConverter"), //
                given("a") //
                        .withPrefix("") //
                        .thenExpect("A"), //
                given("tESt") //
                        .withPrefix("") //
                        .thenExpect("Test"), //
                given(null) //
                        .withPrefix("") //
                        .thenExpect(""), //
                given("") //
                        .withPrefix("") //
                        .thenExpect(""), //
                given("") //
                        .withPrefix("add") //
                        .thenExpect(""), //
                given(null) //
                        .withPrefix(null) //
                        .thenExpect(""), //
                given("test") //
                        .withPrefix(null) //
                        .thenExpect("") //
        );
    }

    private static Stream<Arguments> getInputArgumentsWithoutPrefix() {
        return Stream.of( //
                given("COSMIC_MICROWAVE_BACKGROUND_RADIATION") //
                        .thenExpect("CosmicMicrowaveBackgroundRadiation"), //
                given("first name") //
                        .thenExpect("FirstName"), //
                given("last-name") //
                        .thenExpect("LastName"), //
                given("my custom -class") //
                        .thenExpect("MyCustomClass"), //
                given("my:custom:class") //
                        .thenExpect("MyCustomClass"), //
                given("My;custoM;class") //
                        .thenExpect("MyCustomClass"), //
                given("My;custoM;class;") //
                        .thenExpect("MyCustomClass"), //
                given("my=custom=class") //
                        .thenExpect("MyCustomClass") //
        );
    }

    public static class ArgumentsUtil {
        private final List<String> objects;

        private ArgumentsUtil(List<String> ob) {
            this.objects = ob;
        }

        public static ArgumentsUtil given(String obj) {
            List<String> list = new ArrayList<>();
            list.add(obj);
            return new ArgumentsUtil(list);
        }

        public ArgumentsUtil withPrefix(String obj) {
            objects.add(obj);
            return this;
        }

        public Arguments thenExpect(String result) {
            objects.add(result);
            return Arguments.of(objects.toArray());
        }
    }
}
