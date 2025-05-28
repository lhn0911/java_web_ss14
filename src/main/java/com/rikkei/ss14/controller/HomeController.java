package com.rikkei.ss14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/translate")
    public String home() {
        return "home";
    }
}
