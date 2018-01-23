package com.pizza.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/products")
public class TestController {
    @GetMapping
    public String mainPage() {
        return "products";
    }
}
