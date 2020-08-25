package com.example.javaweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/")
    public String WritePost(char title, char writer, String content){
        return "Hello, world";
    }
}
