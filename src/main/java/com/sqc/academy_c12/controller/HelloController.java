package com.sqc.academy_c12.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "Da Nang") String address) {
        return "Hello " + name + ", " + address + "!";
    }
}
