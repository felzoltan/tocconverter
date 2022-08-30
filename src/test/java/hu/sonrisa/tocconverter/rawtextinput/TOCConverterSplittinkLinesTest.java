package hu.sonrisa.tocconverter.rawtextinput;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TOCConverterSplittinkLinesTest {

    private TOCConverterSplittinkLines con = new TOCConverterSplittinkLines();

    @Test
    void convertInputWithSplittingLines() {
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
        assertEquals(result, con.convert(input));
    }

    @Test
    void convertInputWithSplittingLinesEmptyInput() {
        assertEquals("", con.convert(""));
    }

    @Test
    void convertInputWithSplittingLinesWithWhiteSpaces() {
        String input = """
            I.
            I.I.
            I.II.
            II.
            II.I
            II.I.I
            II.I.I.I
            II.I.I.II
            III.""";
        String result = """
            1.
            1.1.
            1.2.
            2.
            2.1
            2.1.1 
            2.1.1.1
            2.1.1.2
            3.""";
        assertEquals(result, con.convert(input));
    }
}