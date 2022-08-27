package hu.sonrisa.tocconverter.converters;

import hu.sonrisa.tocconverter.BusinesException;

public class ConverterFromArabicToRoman {

    private final CharSequence[] ones = {"III", "XXX", "CCC", "MMM"};
    private final char[] fives = {'V', 'L', 'D'};
    private final char[] tens = {'X', 'C', 'M'};

    public String convert(String arabicNumber) {
        InputInverseSplitter splitter = new InputInverseSplitter(arabicNumber);
        char actChar = splitter.getNextChar();
        int position = 0;
        int actValue = 0;
        StringBuilder result = new StringBuilder();
        while (actChar != 0) {
            switch (actChar) {
                case '0':
                    break;
                case '1', '2', '3':
                    if (position > 3) {
                        throw new BusinesException(2, "Too big number");
                    }
                    result.append(ones[position].subSequence(0, actChar - '0'));
                    break;
                case '4':
                    if (position > 2) {
                        throw new BusinesException(2, "Too big number");
                    }
                    result.append(fives[position]);
                    result.append(ones[position].subSequence(0, 1));
                    break;
                case '5':
                    if (position > 2) {
                        throw new BusinesException(2, "Too big number");
                    }
                    result.append(fives[position]);
                    break;
                case '6', '7', '8':
                    if (position > 2) {
                        throw new BusinesException(2, "Too big number");
                    }
                    result.append(ones[position].subSequence(0, actChar - '5'));
                    result.append(fives[position]);
                    break;
                case '9':
                    if (position > 2) {
                        throw new BusinesException(2, "Too big number");
                    }
                    result.append(tens[position]);
                    result.append(ones[position].subSequence(0, 1));
                    break;
                default:
                    throw new BusinesException(1, "Wrong arabic number. Pos:" + splitter.getLastPosition() + 1);
            }
            actChar = splitter.getNextChar();
            position++;
        }

        return result.reverse().toString();
    }

}
