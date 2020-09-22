package com.example.kotlinweb.repository

import com.example.kotlinweb.model.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long>{}