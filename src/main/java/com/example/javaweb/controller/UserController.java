package com.example.javaweb.controller;

import model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/join")
    public User createUser(@RequestParam String name, @RequestParam String email, @RequestParam String gender) {
        return new User(name, email, gender);
    }
}
