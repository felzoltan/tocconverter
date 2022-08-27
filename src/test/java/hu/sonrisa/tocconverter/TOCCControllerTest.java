package hu.sonrisa.tocconverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TOCCControllerTest {

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
        assertEquals(result, TOCCController.convertInputWithRegexp(input));
    }

    @Test
    void convertInputWithRegexpOneLine() {
        String input = "1.1.";
        String result = "I.I.";
        assertEquals(result, TOCCController.convertInputWithRegexp(input));
    }

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
        assertEquals(result, TOCCController.convertInputWithSplittingLines(input));
    }

    @Test
    void convertInputWithSplittingLinesWithWhiteSpaces() {
        String input = """
            1.
            1.1.
            1. 2.
            2.
            2.1
            2.1.1 
            2.1.1.1
            2.1.1.2
            3.
                    """;
        String result = """
            I.
            I.I.
            I.II.
            II.
            II.I
            II.I.I
            II.I.I.I
            II.I.I.II
            III.""";
        assertEquals(result, TOCCController.convertInputWithSplittingLines(input));
    }


}