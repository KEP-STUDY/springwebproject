package com.example.javaweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {


    @GetMapping("/health_check.html")
    public String healthCheck(){
        return "Health";
    }
}
