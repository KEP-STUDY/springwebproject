package com.example.kotlinweb.service

import com.example.kotlinweb.model.Board
import org.springframework.stereotype.Service

@Service
class BoardService(
        private val boardList: MutableList<Board>
) {
    fun create(board: Board): Boolean {
        boardList.add(board)
        println("Board 생성 :$board")
        return true
    }
}