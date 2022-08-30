package hu.sonrisa.tocconverter.converters;

import hu.sonrisa.tocconverter.BusinesException;

public class ConverterFromRomanToArabic {
    private final InputSplitter splitter = new InputSplitter();

    public String convert(String romanNumber) {
        splitter.setInput(romanNumber.trim().toUpperCase());
        char actChar = splitter.getNextChar();
        int value = 0;
        char prevChar = 0;
        while (actChar != 0) {
            switch (actChar) {
                case 'I':
                    value++;
                    break;
                case 'V':
                    if (prevChar == 'I') {
                        value += 3;
                    } else {
                        value += 5;
                    }
                    break;
                case 'X':
                    if (prevChar == 'I') {
                        value += 8;
                    } else {
                        value += 10;
                    }
                    break;
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
                default:
                    throw new BusinesException(1, "Wrong roman number: '" + romanNumber + "'");
            }
            prevChar = actChar;
            actChar = splitter.getNextChar();
        }
        if (prevChar == 0) {
            return "";
        }
        return String.format("%d", value);
    }

}
