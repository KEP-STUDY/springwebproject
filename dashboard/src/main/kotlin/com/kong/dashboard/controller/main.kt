package com.kong.dashboard.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("/")
class ContentsController {

    @ApiOperation(value = "Say Hello")
    @GetMapping()
    fun index(): ResponseEntity<String> {
        val hello = "Hello World!"
        return ResponseEntity.ok(hello)
    }
}