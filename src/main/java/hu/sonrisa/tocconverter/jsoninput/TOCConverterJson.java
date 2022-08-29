package hu.sonrisa.tocconverter.jsoninput;

import hu.sonrisa.tocconverter.converters.Converter;

import java.util.List;

public class TOCConverterJson {
    private Converter converter = new Converter();

    public static void convert(List<TOCItem> input) {
        input.parallelStream().forEach(item -> {
            new TOCConverterJson().convertTOCSubTree(item);
        });
    }

    private void convertTOCSubTree(TOCItem input) {
        if (input == null) {
            return;
        }
        input.title = converter.getConvertedValue(input.title);
        if (input.subTitles == null) {
            return;
        }
        input.subTitles.forEach(item -> {
            convertTOCSubTree(item);
        });
    }
}
