package com.example.javaweb.controller;

import com.example.javaweb.model.User;
import com.example.javaweb.service.BoardService;
import com.example.javaweb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Object>  create(@RequestBody HashMap<String, Object> map) {
        User user = userService.create(map);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
