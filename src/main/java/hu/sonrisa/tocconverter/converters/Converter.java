package hu.sonrisa.tocconverter.converters;

import java.util.HashMap;
import java.util.Map;

/***
 * Converts arabic number to roman number or roman number to arabic.
 * reusable, but after the first use it can be used to the
 * same direction only as the first was
 */
public class Converter {
    private final Map<String, String> cache = new HashMap<>(12);
    private final ConverterFromArabicToRoman a2rConverter = new ConverterFromArabicToRoman();
    private final ConverterFromRomanToArabic r2aConverter = new ConverterFromRomanToArabic();
    private Direction direction = Direction.UNDEF;
    private String input;

    public String getConvertedValue(String p_input) {
        input = p_input.trim();
        if (input.length() == 0) {
            return "";
        }
        String changeValue;
        changeValue = cache.get(input);
        if (changeValue == null) {
            changeValue = isDirectionA2R() ? a2rConverter.convert(input) : r2aConverter.convert(input);
            cache.put(input, changeValue);
        }
        return changeValue;
    }

    private boolean isDirectionA2R() {
        if (direction == Direction.UNDEF) {
            // I define the direction from the first char
            direction = Character.isDigit(input.charAt(0)) ? Direction.A2R : Direction.R2A;
        }
        return direction == Direction.A2R;
    }

    private enum Direction {UNDEF, A2R, R2A}
}
