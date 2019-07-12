package io.samin005.springbootpostgresdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String sayWelcome() {
        return "Welcome!";
    }
}
