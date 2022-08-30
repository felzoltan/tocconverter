package hu.sonrisa.tocconverter.converters;

import hu.sonrisa.tocconverter.BusinesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConverterTest {

    @Test
    void getConvertedValueArabicToRoman() {
        Converter converter = new Converter();
        assertEquals("I", converter.getConvertedValue("1"));
        assertEquals("I", converter.getConvertedValue("1"));
        assertEquals("II", converter.getConvertedValue("2"));
        assertEquals("III", converter.getConvertedValue("3"));
        assertEquals("IV", converter.getConvertedValue("4"));
        assertEquals("V", converter.getConvertedValue("5"));
        assertEquals("VI", converter.getConvertedValue("6"));
        assertEquals("VII", converter.getConvertedValue("7"));
        assertEquals("VIII", converter.getConvertedValue("8"));
        assertEquals("IX", converter.getConvertedValue("9"));
        assertEquals("X", converter.getConvertedValue("10"));
        assertEquals("XX", converter.getConvertedValue("20"));
        assertEquals("XXX", converter.getConvertedValue("30"));
        assertEquals("XL", converter.getConvertedValue("40"));
        assertEquals("L", converter.getConvertedValue("50"));
        assertEquals("LX", converter.getConvertedValue("60"));
        assertEquals("LXX", converter.getConvertedValue("70"));
        assertEquals("LXXX", converter.getConvertedValue("80"));
        assertEquals("XC", converter.getConvertedValue("90"));
        assertEquals("C", converter.getConvertedValue("100"));
        assertEquals("CCI", converter.getConvertedValue("201"));
        assertEquals("", converter.getConvertedValue(""));
    }

    @Test
    void getConvertedValueArabicToRomanError() {
        Converter conv = new Converter();
        BusinesException ex = assertThrows(BusinesException.class, () -> conv.getConvertedValue("11x"));
        assertEquals("Wrong arabic number:'11x'", ex.getMessage());
    }

    @Test
    void getConvertedValue_ChangeDirectionError() {
        Converter conv = new Converter();
        assertEquals("XI", conv.getConvertedValue("11"));
        BusinesException ex = assertThrows(BusinesException.class, () -> conv.getConvertedValue("X"));
        assertEquals("Wrong arabic number:'X'", ex.getMessage());
        Converter conv2 = new Converter();
        assertEquals("10", conv2.getConvertedValue("X"));
        ex = assertThrows(BusinesException.class, () -> conv2.getConvertedValue("11"));
        assertEquals("Wrong roman number: '11'", ex.getMessage());
    }

    @Test
    void getConvertedValueRomanToArabic() {
        Converter converter = new Converter();
        assertEquals("1", converter.getConvertedValue("I"));
        assertEquals("2", converter.getConvertedValue("II"));
        assertEquals("3", converter.getConvertedValue("III"));
        assertEquals("4", converter.getConvertedValue("IV"));
        assertEquals("5", converter.getConvertedValue("V"));
        assertEquals("6", converter.getConvertedValue("VI"));
        assertEquals("7", converter.getConvertedValue("VII"));
        assertEquals("8", converter.getConvertedValue("VIII"));
        assertEquals("9", converter.getConvertedValue("IX"));
        assertEquals("10", converter.getConvertedValue("X"));
        assertEquals("20", converter.getConvertedValue("XX"));
        assertEquals("30", converter.getConvertedValue("XXX"));
        assertEquals("40", converter.getConvertedValue("XL"));
        assertEquals("50", converter.getConvertedValue("L"));
        assertEquals("60", converter.getConvertedValue("LX"));
        assertEquals("70", converter.getConvertedValue("LXX"));
        assertEquals("80", converter.getConvertedValue("LXXX"));
        assertEquals("90", converter.getConvertedValue("XC"));
        assertEquals("100", converter.getConvertedValue("C"));
        assertEquals("201", converter.getConvertedValue("CCI"));
        assertEquals("", converter.getConvertedValue(""));
    }

    @Test
    void getConvertedValueRomanToArabicError() {
        Converter conv = new Converter();
        BusinesException ex = assertThrows(BusinesException.class, () -> conv.getConvertedValue("II-"));
        assertEquals("Wrong roman number: 'II-'", ex.getMessage());
    }
}