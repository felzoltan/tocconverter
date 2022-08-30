package hu.sonrisa.tocconverter.converters;

public class InputInverseSplitter {
    private char[] input;
    private int maxLength;
    private int position;

    public InputInverseSplitter() {
    }

    public void setInput(String input) {
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
}
