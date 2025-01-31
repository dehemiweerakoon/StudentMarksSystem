package com.example.rolebased01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {
    @GetMapping("/item")
    public String item() {
        return "Hello World";
    }
}
