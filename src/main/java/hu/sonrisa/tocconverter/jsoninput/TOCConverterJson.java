package hu.sonrisa.tocconverter.jsoninput;

import hu.sonrisa.tocconverter.converters.ConverterMain;

import java.util.List;

public class TOCConverterJson {
    private int lineNumber = 0;
    private ConverterMain converter = new ConverterMain();

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
