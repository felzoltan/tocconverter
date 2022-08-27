package hu.sonrisa.tocconverter.converters;

public class InputInverseSplitter {
    private final char[] input;
    private final int maxLength;
    private int position;

    public InputInverseSplitter(String input) {
        this.input = input.toCharArray();
        maxLength = this.input.length - 1;
        position = maxLength;
    }

    public char getNextChar() {
        if (position < 0) {
            return 0;
        }
        return input[position--];
    }

    public int getLastPosition() {
        if (position == maxLength) {
            return maxLength;
        }
        return position + 1;
    }
}
