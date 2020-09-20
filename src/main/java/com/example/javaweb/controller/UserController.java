package com.example.javaweb.controller;

import com.example.javaweb.model.User;
import com.example.javaweb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody HashMap<String, Object> map) {
        return new ResponseEntity<>(userService.insert(map), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> find(@PathVariable long id) {
        User user = userService.find(id);
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody HashMap<String, Object> map) {
        User user = userService.update(id, map);
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
