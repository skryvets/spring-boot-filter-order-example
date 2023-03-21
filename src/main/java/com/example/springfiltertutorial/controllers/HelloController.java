package com.example.springfiltertutorial.controllers;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/")
    public Map<String, Boolean> sayHello() {
        return Map.of("success", true);
    }
}
