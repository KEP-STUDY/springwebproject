package com.kong.dashboard.controller

import com.kong.dashboard.repository.UserRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("/user")
class UserController{

    @ApiOperation(value = "find all user")
    @GetMapping()
    fun findAllUser():ResponseEntity<UserRepository>{
        return ResponseEntity.ok(UserRepository())
    }
}