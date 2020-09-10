package me.harry.study.service

import me.harry.study.model.Board
import me.harry.study.payload.BoardRequest
import me.harry.study.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
        val boardRepository: BoardRepository,
        val userService: UserService
) {
    fun createBoard(boardRequest:BoardRequest, name:String):Board {
        val userByName = userService.getUserByName(name)
        val board = Board(
                title = boardRequest.title,
                content = boardRequest.content,
                user = userByName)
        return boardRepository.save(board)
    }

    fun getBoards(name: String):List<Board> {
        val userByName = userService.getUserByName(name)
        return userByName.boards
    }

}