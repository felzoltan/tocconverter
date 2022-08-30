package hu.sonrisa.tocconverter.converters;

public class InputSplitter {
    private char[] input;
    private int position = 0;

    public InputSplitter() {
    }

    public void setInput(String input) {
        this.input = input.toCharArray();
        position = 0;
    }

    public char getNextChar() {
        if (position >= input.length) {
            return 0;
        }
        return input[position++];
    }
}
