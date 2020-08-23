package com.example.kotlinweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@SpringBootApplication
class KotlinwebApplication

fun main(args: Array<String>) {
    runApplication<KotlinwebApplication>(*args)
}
