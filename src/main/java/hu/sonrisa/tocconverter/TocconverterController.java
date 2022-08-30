package hu.sonrisa.tocconverter;

import hu.sonrisa.tocconverter.jsoninput.TOCConverterJson;
import hu.sonrisa.tocconverter.jsoninput.TOCItem;
import hu.sonrisa.tocconverter.rawtextinput.TOCConverterSplittinkLines;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TocconverterController {

    @PostMapping("/tocconvert")
    public String convertTOC(@RequestBody String p_input) {
        TOCConverterSplittinkLines converter = new TOCConverterSplittinkLines();
        try {
            return converter.convert(p_input);
        } catch (BusinesException ex) {
            return ex.getMessage();
        }
    }

    @PostMapping("/tocconvertjson")
    public JsonTOCResult convertTOCJson(@RequestBody List<TOCItem> p_input) {
        try {
            new TOCConverterJson().convert(p_input);
            return new JsonTOCResult("", p_input);
        } catch (BusinesException ex) {
            return new JsonTOCResult(ex.getMessage(), null);
        }
    }

    private class JsonTOCResult {
        public String errorText;
        public List<TOCItem> result;

        public JsonTOCResult(String errorText, List<TOCItem> result) {
            this.errorText = errorText;
            this.result = result;
        }
    }
}
