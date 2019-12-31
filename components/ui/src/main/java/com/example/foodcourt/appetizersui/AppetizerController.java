package com.example.foodcourt.appetizersui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AppetizerController {
    private AppetizerClient appetizerClient;

    public AppetizerController(AppetizerClient appetizerClient) {
        this.appetizerClient = appetizerClient;
    }

    @GetMapping("/appetizers")
    public String allAppetizers(Map<String, Object> model) {
        model.put("appetizers", appetizerClient.getAll() );
        return "appetizers";
    }
}
