package hu.sonrisa.tocconverter.rawtextinput;

import hu.sonrisa.tocconverter.BusinesException;
import hu.sonrisa.tocconverter.converters.Converter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TOCConverterSplittinkLines {
    private int lineNumber = 0;

    public String convert(String p_input) {
        String input = p_input.trim();
        // I define the direction from the first char
        if (input.length() == 0) {
            return "";
        }
        Converter converter = new Converter();
        StringBuilder sb = new StringBuilder();
        input.lines().forEach(line -> {
            lineNumber++;
            if (!sb.isEmpty()) {
                sb.append("\n");
            }
            String newLine = Arrays.stream(line.split("[.]"))
                .map(elem -> {
                    try {
                        return converter.getConvertedValue(elem);
                    } catch (BusinesException ex) {
                        throw new BusinesException(3, "Syntax error in line " + lineNumber);
                    }
                })
                .collect(Collectors.joining("."));
            sb.append(newLine);
            if (line.endsWith(".")) {
                sb.append(".");
            }
        });
        return sb.toString();
    }

}
