package hu.sonrisa.tocconverter.converters;

import hu.sonrisa.tocconverter.BusinesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConverterFromRomanToArabicTest {

    ConverterFromRomanToArabic converter = new ConverterFromRomanToArabic();


    @Test
    void convert() {
        assertEquals("1", converter.convert("I"));
        assertEquals("2", converter.convert("II"));
        assertEquals("3", converter.convert("III"));
        assertEquals("4", converter.convert("IV"));
        assertEquals("5", converter.convert("V"));
        assertEquals("6", converter.convert("VI"));
        assertEquals("7", converter.convert("VII"));
        assertEquals("8", converter.convert("VIII"));
        assertEquals("9", converter.convert("IX"));
        assertEquals("10", converter.convert("X"));
        assertEquals("20", converter.convert("XX"));
        assertEquals("30", converter.convert("XXX"));
        assertEquals("40", converter.convert("XL"));
        assertEquals("50", converter.convert("L"));
        assertEquals("60", converter.convert("LX"));
        assertEquals("70", converter.convert("LXX"));
        assertEquals("80", converter.convert("LXXX"));
        assertEquals("90", converter.convert("XC"));
        assertEquals("100", converter.convert("C"));
        assertEquals("201", converter.convert("CCI"));
    }

    @Test
    void convertWrongInput() {
        assertThrows(BusinesException.class, () -> converter.convert("CCIY"), "Wrong roman number. Pos:4");
    }
}