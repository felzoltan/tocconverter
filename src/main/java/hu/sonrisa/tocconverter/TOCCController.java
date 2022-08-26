package hu.sonrisa.tocconverter;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TOCCController {

    @PostMapping("/tocconvert")
    public String convertTOC(@RequestBody String input){
        return "Hi";
    }
}
