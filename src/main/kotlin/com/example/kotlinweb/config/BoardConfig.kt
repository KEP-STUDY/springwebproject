package com.example.kotlinweb.config

import com.example.kotlinweb.model.Board
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BoardConfig{


    @Bean
    fun boardList():MutableList<Board>{
        return mutableListOf();
    }

}