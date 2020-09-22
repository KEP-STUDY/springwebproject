package com.example.kotlinweb.service

import com.example.kotlinweb.model.Board
import com.example.kotlinweb.model.UserContext
import com.example.kotlinweb.model.request.BoardRequest
import com.example.kotlinweb.repository.BoardRepository
import com.example.kotlinweb.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.transaction.Transactional

@Service
class BoardService(
        private val boardRepository: BoardRepository
){

    fun createBoard(boardRequest:BoardRequest):Board{
        val board = Board(null, boardRequest.title, boardRequest.content, UserContext.getUser())
        return boardRepository.save(board)
    }

    fun findBoard(id:Long):Board{
        return boardRepository.findByIdOrNull(id) ?: throw RuntimeException("not found board")
    }
    fun findAllBoard():List<Board>{
        return boardRepository.findAll()
    }

    fun deleteBoard(id:Long):Boolean{
        boardRepository.deleteById(id)
        return true
    }

    @Transactional
    fun updateBoard(id:Long, boardRequest: BoardRequest):Board{
        val board = boardRepository.findByIdOrNull(id) ?: throw RuntimeException("not found board")
        board.title = boardRequest.title
        board.content = boardRequest.content
        return board
    }

}