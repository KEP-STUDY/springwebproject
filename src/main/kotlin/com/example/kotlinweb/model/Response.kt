package com.example.kotlinweb.model

import org.springframework.http.HttpStatus

class Response<T>(
        val code:HttpStatus,
        val message:String,
        val data: T
)