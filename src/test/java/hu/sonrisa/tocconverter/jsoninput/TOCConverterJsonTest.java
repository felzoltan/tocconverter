package hu.sonrisa.tocconverter.jsoninput;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TOCConverterJsonTest {

    @Test
    void convertA2R() {
        TOCConverterJson conv = new TOCConverterJson();
        List<TOCItem> root = new ArrayList<>(3);
        root.add(new TOCItem("1"));
        root.add(new TOCItem("2"));
        root.add(new TOCItem("3"));
        TOCItem actItem = root.get(0);
        actItem.addSubTitle(new TOCItem("1"));
        actItem.addSubTitle(new TOCItem("2"));
        actItem.addSubTitle(new TOCItem("3"));
        conv.convert(root);
        assertEquals("I", root.get(0).title);
        assertEquals("II", root.get(1).title);
        assertEquals("III", root.get(2).title);
        actItem = root.get(0);
        assertEquals("I", actItem.subTitles.get(0).title);
        assertEquals("II", actItem.subTitles.get(1).title);
        assertEquals("III", actItem.subTitles.get(2).title);
    }

    @Test
    void convertEmptyInput() {
        TOCConverterJson conv = new TOCConverterJson();
        conv.convert(null);
    }

    @Test
    void convertR2A() {
        TOCConverterJson conv = new TOCConverterJson();
        List<TOCItem> root = new ArrayList<>(3);
        root.add(new TOCItem("I"));
        root.add(new TOCItem("II"));
        root.add(new TOCItem("III"));
        TOCItem actItem = root.get(0);
        actItem.addSubTitle(new TOCItem("I"));
        actItem.addSubTitle(new TOCItem("II"));
        actItem.addSubTitle(new TOCItem("III"));
        conv.convert(root);
        assertEquals("1", root.get(0).title);
        assertEquals("2", root.get(1).title);
        assertEquals("3", root.get(2).title);
        actItem = root.get(0);
        assertEquals("1", actItem.subTitles.get(0).title);
        assertEquals("2", actItem.subTitles.get(1).title);
        assertEquals("3", actItem.subTitles.get(2).title);
    }
}