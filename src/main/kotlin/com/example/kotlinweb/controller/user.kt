package com.example.kotlinweb.controller

import com.example.kotlinweb.model.User
import com.example.kotlinweb.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UserController(private val userService: UserService){
    @GetMapping("/user")
    fun findAll(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.findAll())
    }

    @PostMapping("/user")
    fun create():ResponseEntity<User>{
      return ResponseEntity.ok(userService.save())
    }

    @PatchMapping("/user")
    fun update():ResponseEntity<User>{
        return ResponseEntity.ok(userService.update())
    }

}