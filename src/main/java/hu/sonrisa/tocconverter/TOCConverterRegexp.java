package hu.sonrisa.tocconverter;

import hu.sonrisa.tocconverter.converters.ConverterFromArabicToRoman;
import hu.sonrisa.tocconverter.converters.ConverterFromRomanToArabic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TOCConverterRegexp {
    public static String convert(String p_input) {
        // I define the direction from the first char
        String input = p_input.trim();
        if (input.length() == 0) {
            return "";
        }
        boolean a2r = Character.isDigit(input.charAt(0));
//        Pattern pattern = Pattern.compile(".*([0-9]+).*");
        Pattern pattern = Pattern.compile("\\D*(\\d+)\\D*");
        Matcher matcher = pattern.matcher(input);
        ConverterFromArabicToRoman a2rConverter = new ConverterFromArabicToRoman();
        ConverterFromRomanToArabic r2aConverter = new ConverterFromRomanToArabic();
        if (matcher.matches()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                String group = matcher.group(i);
                input.replace(group, a2r ? a2rConverter.convert(group) : r2aConverter.convert(group));
            }
        }
        return input;
    }

}
