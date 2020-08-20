package me.harry.study.repository

import me.harry.study.model.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long> {

    fun findByUserId(id:Long):List<Board>?
}