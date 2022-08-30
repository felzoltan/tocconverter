package hu.sonrisa.tocconverter;

import hu.sonrisa.tocconverter.jsoninput.TOCItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TocconverterControllerTest {
    private TocconverterController controller = new TocconverterController();

    @Test
    void convertTOCRawA2R() {
        String input = """
            1.
            1.1.
            1.2.
            2.
            2.1
            2.1.1
            2.1.1.1
            2.1.1.2
            3.        """;
        String result = """
            I.
            I.I.
            I.II.
            II.
            II.I
            II.I.I
            II.I.I.I
            II.I.I.II
            III.        """;
        assertEquals(result, controller.convertTOC(input));
    }

    @Test
    void convertTOCRawA2RError() {
        String input = """
            1.
            1.1.
            1.2x.
            2.
            2.1
            2.1.1
            2.1.1.1
            2.1.1.2
            3.        """;
        assertEquals("Syntax error in line 3", controller.convertTOC(input));
    }

    @Test
    void convertTOCRawR2A() {
        String input = """
            I.
            I.I.
            I.II.
            II.
            II.I
            II.I.I
            II.I.I.I
            II.I.I.II
            III.        """;
        String result = """
            1.
            1.1.
            1.2.
            2.
            2.1
            2.1.1
            2.1.1.1
            2.1.1.2
            3.        """;
        assertEquals(result, controller.convertTOC(input));
    }

    @Test
    void convertTOCRawR2AError() {
        String input = """
            I.
            I.I.
            I.II.
            II.
            II.I
            II.I.I
            II.I.I.I
            II.I.I.II
            III-.        """;
        assertEquals("Syntax error in line 9", controller.convertTOC(input));
    }

    @Test
    void convertTOCJsonA2R() {
        List<TOCItem> root = new ArrayList<>(3);
        root.add(new TOCItem("1"));
        root.add(new TOCItem("2"));
        root.add(new TOCItem("3"));
        TOCItem actItem = root.get(0);
        actItem.addSubTitle(new TOCItem("1"));
        actItem.addSubTitle(new TOCItem("2"));
        actItem.addSubTitle(new TOCItem("3"));
        TocconverterController.JsonTOCResult result = controller.convertTOCJson(root);
        root = result.result;
        assertEquals("I", root.get(0).title);
        assertEquals("II", root.get(1).title);
        assertEquals("III", root.get(2).title);
        actItem = root.get(0);
        assertEquals("I", actItem.subTitles.get(0).title);
        assertEquals("II", actItem.subTitles.get(1).title);
        assertEquals("III", actItem.subTitles.get(2).title);
    }

    @Test
    void convertTOCJsonA2RError() {
        List<TOCItem> root = new ArrayList<>(3);
        root.add(new TOCItem("1"));
        root.add(new TOCItem("2"));
        root.add(new TOCItem("3x"));
        TOCItem actItem = root.get(0);
        actItem.addSubTitle(new TOCItem("1"));
        actItem.addSubTitle(new TOCItem("2"));
        actItem.addSubTitle(new TOCItem("3"));
        TocconverterController.JsonTOCResult result = controller.convertTOCJson(root);
        assertEquals("Wrong arabic number:'3x'", result.errorText);
        assertTrue(result.result == null);
    }

    @Test
    void convertTOCJsonR2A() {
        List<TOCItem> root = new ArrayList<>(3);
        root.add(new TOCItem("I"));
        root.add(new TOCItem("II"));
        root.add(new TOCItem("III"));
        TOCItem actItem = root.get(0);
        actItem.addSubTitle(new TOCItem("I"));
        actItem.addSubTitle(new TOCItem("II"));
        actItem.addSubTitle(new TOCItem("III"));
        TocconverterController.JsonTOCResult result = controller.convertTOCJson(root);
        root = result.result;
        assertEquals("1", root.get(0).title);
        assertEquals("2", root.get(1).title);
        assertEquals("3", root.get(2).title);
        actItem = root.get(0);
        assertEquals("1", actItem.subTitles.get(0).title);
        assertEquals("2", actItem.subTitles.get(1).title);
        assertEquals("3", actItem.subTitles.get(2).title);
    }

    @Test
    void convertTOCJsonR2AError() {
        List<TOCItem> root = new ArrayList<>(3);
        root.add(new TOCItem("I"));
        root.add(new TOCItem("II"));
        root.add(new TOCItem("III1"));
        TOCItem actItem = root.get(0);
        actItem.addSubTitle(new TOCItem("I"));
        actItem.addSubTitle(new TOCItem("II"));
        actItem.addSubTitle(new TOCItem("III"));
        TocconverterController.JsonTOCResult result = controller.convertTOCJson(root);
        assertEquals("Wrong roman number: 'III1'", result.errorText);
        assertTrue(result.result == null);
    }
}