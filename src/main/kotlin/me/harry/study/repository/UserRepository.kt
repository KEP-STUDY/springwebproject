package me.harry.study.repository

import me.harry.study.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByName(name: String): User
}