package hu.sonrisa.tocconverter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TOCCController {

    @PostMapping("/tocconvert")
    public String convertTOC(@RequestBody String p_input) {
        TOCConverterSplittinkLines converter = new TOCConverterSplittinkLines();
        try {
            return converter.convert(p_input);
        } catch (BusinesException ex) {
            return ex.getMessage();
        }
    }
}
