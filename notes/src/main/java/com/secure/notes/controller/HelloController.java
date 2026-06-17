package com.secure.notes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayhello(){
        return "Hello";
    }
    @GetMapping("/a")
    public String  sayHi(){
        return "Hi";
    }

}
