package com.example.kotlinweb.service

import com.example.kotlinweb.entity.Board
import com.example.kotlinweb.model.CreateBoardRequest
import com.example.kotlinweb.model.UpdateBoardRequest
import com.example.kotlinweb.repository.BoardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BoardService(val boardRepository: BoardRepository){
    fun findAll():List<Board> {
        return boardRepository.findAll()
    }

    fun save(createBoardRequest: CreateBoardRequest): Board {
        return boardRepository.save(Board(createBoardRequest.title))
    }

    fun getBoardById(id:Long): Board {
        return boardRepository.findByIdOrNull(id) ?: throw Exception("There is no board with that ID.")
    }

    fun update(id:Long,updateBoardRequest: UpdateBoardRequest): Board {
        val targetBoard: Board = getBoardById(id)
        return boardRepository.save(targetBoard)
    }
}