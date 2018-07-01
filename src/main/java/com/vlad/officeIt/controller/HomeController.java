package com.vlad.officeIt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public static final String CONTENT_ATTRIBUTE = "content";
    public static final String MESSAGE = "message";

    public static final String CONTENT = "title";

    @Value("${spring.application.name}")
    String appName;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute(CONTENT_ATTRIBUTE, CONTENT);
        model.addAttribute(MESSAGE, String.format("Welcome to %s", appName));
        return "home";
    }
}
