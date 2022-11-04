package com.trendyol.meetup.api.infrastructure.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String redirectToSwaggerUi(){
        return "redirect:/swagger-ui.html";
    }

}
