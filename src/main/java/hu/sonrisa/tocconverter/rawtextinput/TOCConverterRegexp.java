package hu.sonrisa.tocconverter.rawtextinput;

import hu.sonrisa.tocconverter.converters.ConverterMain;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TOCConverterRegexp {
    public static String convert(String p_input) {
        // I define the direction from the first char
        String input = p_input.trim();
        if (input.length() == 0) {
            return "";
        }
        boolean a2r = Character.isDigit(input.charAt(0));
        Pattern pattern = Pattern.compile("[\\r\\n\\s[.]]");
        String[] numbers = pattern.split(input);
        Map<String, String> replace = new HashMap<>();
        ConverterMain converter = new ConverterMain();
        Arrays.stream(numbers).filter(item -> item != null && item.compareTo("") > 0).forEach(item -> {
            if (!replace.containsKey(item)) {
                replace.put(item, converter.getConvertedValue(item));
            }
        });
        LinkedList<String> orderedReplaceStrings = replace.keySet().stream()
            .sorted(String::compareTo)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toCollection(LinkedList<String>::new));
        for (String item : orderedReplaceStrings) {
            input = input.replaceAll(item, replace.get(item));
        }
        return input;
    }

}
