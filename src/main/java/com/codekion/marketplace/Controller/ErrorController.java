package com.codekion.marketplace.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/errorPage")
    public String errorPage() {
        return "pages/errorPage";
    }

}
