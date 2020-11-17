package com.example.kotlinweb.board.repository

import com.example.kotlinweb.board.model.Notify
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotifyRepository : JpaRepository<Notify, Long> {

}