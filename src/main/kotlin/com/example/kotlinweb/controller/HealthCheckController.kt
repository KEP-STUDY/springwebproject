package com.example.kotlinweb.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HealthCheckController{

    @GetMapping(value = ["/health_check.html"])
    fun getStatus():ResponseEntity<String>{
        return ResponseEntity("Health", HttpStatus.OK)
    }
}
