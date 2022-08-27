package hu.sonrisa.tocconverter.converters;

import hu.sonrisa.tocconverter.BusinesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConverterFromArabicToRomanTest {
    ConverterFromArabicToRoman converter = new ConverterFromArabicToRoman();

    @Test
    void convert() {
        assertEquals("I", converter.convert("1"));
        assertEquals("II", converter.convert("2"));
        assertEquals("III", converter.convert("3"));
        assertEquals("IV", converter.convert("4"));
        assertEquals("V", converter.convert("5"));
        assertEquals("VI", converter.convert("6"));
        assertEquals("VII", converter.convert("7"));
        assertEquals("VIII", converter.convert("8"));
        assertEquals("IX", converter.convert("9"));
        assertEquals("X", converter.convert("10"));
        assertEquals("XX", converter.convert("20"));
        assertEquals("XXX", converter.convert("30"));
        assertEquals("XL", converter.convert("40"));
        assertEquals("L", converter.convert("50"));
        assertEquals("LX", converter.convert("60"));
        assertEquals("LXX", converter.convert("70"));
        assertEquals("LXXX", converter.convert("80"));
        assertEquals("XC", converter.convert("90"));
        assertEquals("C", converter.convert("100"));
        assertEquals("CCI", converter.convert("201"));
    }

    @Test
    void convertWrongInput() {
        assertThrows(BusinesException.class, () -> converter.convert("11Y22"), "Wrong arabic number. Pos:3");
    }
}