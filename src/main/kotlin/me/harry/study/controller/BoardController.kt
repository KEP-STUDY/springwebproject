package me.harry.study.controller

import me.harry.study.model.Board
import me.harry.study.payload.BoardRequest
import me.harry.study.service.BoardService
import me.harry.study.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController(
        val boardService: BoardService
) {

    @PostMapping
    fun createBoard(@RequestBody boardRequest: BoardRequest, @RequestParam name:String):String {
        boardService.createBoard(boardRequest, name)
        return "성고옹!"
    }

    @GetMapping
    fun getBoards(@RequestParam name:String): List<Board> {
        return boardService.getBoards(name)
    }

}