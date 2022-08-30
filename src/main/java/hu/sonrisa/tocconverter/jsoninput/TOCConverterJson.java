package hu.sonrisa.tocconverter.jsoninput;

import hu.sonrisa.tocconverter.converters.Converter;

import java.util.List;

public class TOCConverterJson {
    private int lineNumber = 0;
    private Converter converter = new Converter();

    public void convert(List<TOCItem> input) {
        convertTOCSubTree(input);
    }

    private void convertTOCSubTree(List<TOCItem> input) {
        if (input == null) {
            return;
        }
        input.forEach(item -> {
            item.title = converter.getConvertedValue(item.title);
            convertTOCSubTree(item.subTitles);
        });
    }
}
