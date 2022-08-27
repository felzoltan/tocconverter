package hu.sonrisa.tocconverter.converters;

import hu.sonrisa.tocconverter.BusinesException;

public class ConverterFromRomanToArabic {
    private InputSplitter splitter;
    private char actChar;

    public String convert(String romanNumber) {
        splitter = new InputSplitter(romanNumber.toUpperCase());
        int value = 0;
        getNextChar();
        char prevChar = 0;
        while (actChar != 0) {
            switch (actChar) {
                case 'M':
                    if (prevChar == 'C') {
                        value += 800;
                    } else {
                        value += 1000;
                    }
                    break;
                case 'D':
                    if (prevChar == 'C') {
                        value += 300;
                    } else {
                        value += 500;
                    }
                    break;
                case 'C':
                    if (prevChar == 'X') {
                        value += 80;
                    } else {
                        value += 100;
                    }
                    break;
                case 'L':
                    if (prevChar == 'X') {
                        value += 30;
                    } else {
                        value += 50;
                    }
                    break;
                case 'X':
                    if (prevChar == 'I') {
                        value += 8;
                    } else {
                        value += 10;
                    }
                    break;
                case 'V':
                    if (prevChar == 'I') {
                        value += 3;
                    } else {
                        value += 5;
                    }
                    break;
                case 'I':
                    value++;
                    break;
                default:
                    throw new BusinesException(1, "Wrong roman number. Pos:" + splitter.getLastPosition() + 1);
            }
            prevChar = actChar;
            getNextChar();
        }
        return String.format("%d", value);
    }

    private void getNextChar() {
        actChar = splitter.getNextChar();
    }
}
