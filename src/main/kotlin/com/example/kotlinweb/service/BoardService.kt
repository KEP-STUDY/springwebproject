package com.example.kotlinweb.service

import com.example.kotlinweb.model.Board
import org.springframework.stereotype.Service

@Service
class BoardService(
        private val boardList:MutableList<Board>
){

    fun createBoard(board:Board):Board{
        boardList.add(board)
        return board
    }

    fun findBoard(id:Int):Board{
        return boardList[id-1]
    }
    fun findAllBoard():List<Board>{
        return boardList
    }

    fun deleteBoard(id:Int):Boolean{
        val board = boardList[id-1]
        return boardList.remove(board)
    }

    fun updateBoard(id:Int, board: Board):Board{
        boardList[id-1] = board;
        return board;
    }

}