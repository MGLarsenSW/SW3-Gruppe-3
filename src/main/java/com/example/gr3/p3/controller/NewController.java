package com.example.gr3.p3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {

    @RequestMapping("/new")
    public String getNewControl() {
        return "Hello World";
    }

}
