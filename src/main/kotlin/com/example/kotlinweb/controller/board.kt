package com.example.kotlinweb.controller

import com.example.kotlinweb.entity.Board
import com.example.kotlinweb.model.CreateBoardRequest
import com.example.kotlinweb.model.UpdateBoardRequest
import com.example.kotlinweb.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class BoardController(private val boardService: BoardService){
    @GetMapping("/board")
    fun findAll(): ResponseEntity<List<Board>> {
        return ResponseEntity.ok(boardService.findAll())
    }
    @GetMapping("/board/{id}")
    fun findOne(@PathVariable id:Long):ResponseEntity<Board>{
        return ResponseEntity.ok(boardService.getBoardById(id))
    }
    @PostMapping("/board")
    fun create(@RequestBody requestBody: CreateBoardRequest):ResponseEntity<Board>{
        return ResponseEntity.ok(boardService.save(requestBody))
    }

    @PatchMapping("/board/{id}")
    fun update(@PathVariable id:Long, @RequestBody requestBody: UpdateBoardRequest):ResponseEntity<Board>{
        return ResponseEntity.ok(boardService.update(id,requestBody))
    }

}