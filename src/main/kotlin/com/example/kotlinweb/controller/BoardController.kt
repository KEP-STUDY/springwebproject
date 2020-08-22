package com.example.kotlinweb.controller

import com.example.kotlinweb.model.Board
import com.example.kotlinweb.service.BoardService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(private val boardService: BoardService) {

    @PostMapping("/board")
    fun postBoard(@RequestBody body: Board): Boolean {
        return boardService.create(body)
    }
}