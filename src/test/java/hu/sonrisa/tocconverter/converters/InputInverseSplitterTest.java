package hu.sonrisa.tocconverter.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputInverseSplitterTest {

    @Test
    void getNextChar() {
        InputInverseSplitter s = new InputInverseSplitter();
        s.setInput("APPLE");
        assertEquals('E', s.getNextChar());
        assertEquals('L', s.getNextChar());
        assertEquals('P', s.getNextChar());
        assertEquals('P', s.getNextChar());
        assertEquals('A', s.getNextChar());
        assertEquals(0, s.getNextChar());
        s.setInput("PLUM");
        assertEquals('M', s.getNextChar());
        assertEquals('U', s.getNextChar());
        assertEquals('L', s.getNextChar());
        assertEquals('P', s.getNextChar());
        assertEquals(0, s.getNextChar());
    }
}