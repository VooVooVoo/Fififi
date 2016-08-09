package it.morfoza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Wojt on 2016-08-09.
 */
@Controller
public class CalcController {
    @RequestMapping("/")
    public String philosophy() {
        return "Philosophy";
    }

    @RequestMapping("/calc")
    public String calculator() {
        return "calculator_form";
    }
}
