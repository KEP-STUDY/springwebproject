package com.example.kotlinweb.service

import com.example.kotlinweb.model.Board
import org.springframework.stereotype.Service

@Service
class BoardService(
        private val boardList: MutableList<Board>
) {
    fun create(board: Board): Boolean {
        boardList.add(board).also { println("create Board:$board") }
        return true
    }

    fun getBoard(): List<Board> = boardList.also { println("get Board : $boardList") }

    fun delete() = boardList.clear().also { println("clear Board : $boardList") }

    fun updateItem(board: Board) = boardList.forEach {
        if (it.id == board.id) {
            boardList.remove(it)
            boardList.add(board)
            return@forEach
        }
    }
}