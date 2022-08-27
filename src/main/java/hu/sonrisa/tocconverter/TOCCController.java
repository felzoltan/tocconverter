package hu.sonrisa.tocconverter;

import hu.sonrisa.tocconverter.converters.ConverterFromArabicToRoman;
import hu.sonrisa.tocconverter.converters.ConverterFromRomanToArabic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class TOCCController {

    public static String convertInputWithRegexp(String p_input) {
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

    public static String convertInputWithSplittingLines(String p_input) {
        String input = p_input.trim();
        // I define the direction from the first char
        if (input.length() == 0) {
            return "";
        }
        boolean a2r = Character.isDigit(input.charAt(0));
        ConverterFromArabicToRoman a2rConverter = new ConverterFromArabicToRoman();
        ConverterFromRomanToArabic r2aConverter = new ConverterFromRomanToArabic();
        StringBuilder sb = new StringBuilder();
        input.lines().forEach(line -> {
            if (!sb.isEmpty()) {
                sb.append("\n");
            }
            String newLine = Arrays.stream(line.split("[.]"))
                .map(elem -> a2r ? a2rConverter.convert(elem) : r2aConverter.convert(elem))
                .collect(Collectors.joining("."));
            sb.append(newLine);
            if (line.endsWith(".")) {
                sb.append(".");
            }
        });
        return sb.toString();
    }

    @PostMapping("/tocconvert")
    public String convertTOC(@RequestBody String p_input) {
        return convertInputWithSplittingLines(p_input);
    }
}
