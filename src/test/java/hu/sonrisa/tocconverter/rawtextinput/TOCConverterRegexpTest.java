package hu.sonrisa.tocconverter.rawtextinput;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TOCConverterRegexpTest {

    //@Disabled("There is a chance to repair it")
    @Test
    void convertInputWithRegexp() {
        String input = """
            1.
            1.1.
            1.2.
            2.
            2.1
            2.1.1
            2.1.1.1
            2.1.1.2
            3.        """;
        String result = """
            I.
            I.I.
            I.II.
            II.
            II.I
            II.I.I
            II.I.I.I
            II.I.I.II
            III.        """;
        assertEquals(result, TOCConverterRegexp.convert(input));
    }

    //@Disabled("There is a chance to repair it")
    @Test
    void convertInputWithRegexpOneLine() {
        String input = "1.1.";
        String result = "I.I.";
        assertEquals(result, TOCConverterRegexp.convert(input));
    }
}