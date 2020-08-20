package me.harry.study.service

import me.harry.study.model.Board
import me.harry.study.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
        val boardRepository: BoardRepository,
        val userService: UserService
) {
    fun createBoard(board:Board):Board {
        return boardRepository.save(board)
    }

    fun getBoards(name: String):List<Board> {
        val userByName = userService.getUserByName(name)
        return userByName.boards
    }

}