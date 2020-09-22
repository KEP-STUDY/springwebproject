package com.example.kotlinweb.controller

import com.example.kotlinweb.model.Board
import com.example.kotlinweb.model.request.BoardRequest
import com.example.kotlinweb.model.response.Response
import com.example.kotlinweb.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(
        private val boardService: BoardService
){

    @PostMapping("/board")
    fun postBoard(@RequestBody boardRequest:BoardRequest): Response<Board> {
        return Response(HttpStatus.CREATED, "create", boardService.createBoard(boardRequest));
    }

    @GetMapping("/board")
    fun findAllBoard(): Response<List<Board>> {
        return Response(HttpStatus.OK, "findAll", boardService.findAllBoard())
    }

    @GetMapping("/board/{id}")
    fun findBoard(@PathVariable id:Long): Response<Board> {
        return Response(HttpStatus.OK, "find", boardService.findBoard(id))
    }

    @DeleteMapping("/board/{id}")
    fun deleteBoard(@PathVariable id:Long): Response<Boolean> {
        return Response(HttpStatus.OK, "delete", boardService.deleteBoard(id))
    }

    @PutMapping("/board/{id}")
    fun update(@PathVariable id:Long, @RequestBody boardRequest:BoardRequest): Response<Board> {
        return Response(HttpStatus.OK, "update", boardService.updateBoard(id, boardRequest))
    }
}