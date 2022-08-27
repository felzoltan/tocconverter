package hu.sonrisa.tocconverter.converters;

public class InputSplitter {
    private final char[] input;
    private int position = 0;

    public InputSplitter(String input) {
        this.input = input.toCharArray();
    }

    public char getNextChar() {
        if (position >= input.length) {
            return 0;
        }
        return input[position++];
    }

    public int getLastPosition() {
        if (position == 0) {
            return 0;
        }
        return position - 1;
    }
}
