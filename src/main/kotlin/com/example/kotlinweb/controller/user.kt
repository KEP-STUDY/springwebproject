package com.example.kotlinweb.controller

import com.example.kotlinweb.entity.User
import com.example.kotlinweb.model.CreateUserRequest
import com.example.kotlinweb.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class UserController(private val userService: UserService){
    @GetMapping("/user")
    fun findAll(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.findAll())
    }
    @GetMapping("/user/{id}")
    fun findOne(@PathVariable id:Long):ResponseEntity<User>{
        return ResponseEntity.ok(userService.getUserById(id))
    }
    @PostMapping("/user")
    fun create(@RequestBody requestBody: CreateUserRequest):ResponseEntity<User>{
      return ResponseEntity.ok(userService.save(requestBody))
    }

    @PatchMapping("/user")
    fun update():ResponseEntity<User>{
        return ResponseEntity.ok(userService.update())
    }

}