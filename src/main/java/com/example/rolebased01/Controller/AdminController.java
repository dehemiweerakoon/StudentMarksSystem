package com.example.rolebased01.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class AdminController {

    @GetMapping("/hello/get")
    public String index() {
        return "Hello World";
    }
    @GetMapping("/admin/item")
    public String item() {
        return "Admin Item";
    }
}
