package hu.sonrisa.tocconverter.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputSplitterTest {

    @Test
    void getNextChar() {
        InputSplitter s = new InputSplitter();
        s.setInput("APPLE");
        assertEquals('A', s.getNextChar());
        assertEquals('P', s.getNextChar());
        assertEquals('P', s.getNextChar());
        assertEquals('L', s.getNextChar());
        assertEquals('E', s.getNextChar());
        assertEquals(0, s.getNextChar());
        s.setInput("PLUM");
        assertEquals('P', s.getNextChar());
        assertEquals('L', s.getNextChar());
        assertEquals('U', s.getNextChar());
        assertEquals('M', s.getNextChar());
        assertEquals(0, s.getNextChar());
    }
}