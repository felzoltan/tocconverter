package hu.sonrisa.tocconverter.converters;

import java.util.HashMap;
import java.util.Map;

public class Converter {
    private Map<String, String> cache = new HashMap<>(12);
    private ConverterFromArabicToRoman a2rConverter = new ConverterFromArabicToRoman();
    private ConverterFromRomanToArabic r2aConverter = new ConverterFromRomanToArabic();
    private Direction direction = Direction.UNDEF;

    public String getConvertedValue(String p_input) {
        String input = p_input.trim();
        // I define the direction from the first char
        if (input.length() == 0) {
            return "";
        }
        if (direction == Direction.UNDEF) {
            direction = Character.isDigit(input.charAt(0)) ? Direction.A2R : Direction.R2A;
        }
        String changeValue;
        changeValue = cache.get(input);
        if (changeValue == null) {
            changeValue = direction == Direction.A2R ? a2rConverter.convert(input) : r2aConverter.convert(input);
            cache.put(input, changeValue);
        }
        return changeValue;
    }

    private enum Direction {UNDEF, A2R, R2A}
}
