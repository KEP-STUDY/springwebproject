package com.example.kotlinweb.controller

import com.example.kotlinweb.model.Board
import com.example.kotlinweb.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(private val boardService: BoardService) {

    @PostMapping("/board")
    fun postBoard(@RequestBody body: Board): Boolean = boardService.create(body)

    @GetMapping("/getBoardList")
    fun getBoardList(): List<Board> = boardService.getBoard()

    @DeleteMapping("/boardClear")
    fun deleteBoardList() = boardService.delete()

    @PutMapping("/boardUpdate")
    fun updateBoard(@RequestBody body: Board) = boardService.updateItem(body)
}