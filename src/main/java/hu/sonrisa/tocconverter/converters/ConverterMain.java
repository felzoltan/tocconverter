package hu.sonrisa.tocconverter.converters;

import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.Map;

/***
 * Converts arabic number to roman number or roman number to arabic.
 * reusable, but after the first use it can be used to the
 * same direction only as the first was
 */
public class ConverterMain {
    private final Map<String, String> cache = new HashMap<>(12);
    private Converter actConverter = null;
    private String input;

    public String getConvertedValue(String p_input) {
        if (Strings.isBlank(p_input)) {
            return "";
        }
        input = p_input.trim();
        String changeValue;
        changeValue = cache.get(input);
        if (changeValue == null) {
            changeValue = getConverter().convert(input);
            cache.put(input, changeValue);
        }
        return changeValue;
    }

    private Converter getConverter() {
        if (actConverter == null) {
            // I define the direction from the first char
            actConverter = Character.isDigit(input.charAt(0)) ? new ConverterFromArabicToRoman() : new ConverterFromRomanToArabic();
        }
        return actConverter;
    }
}
