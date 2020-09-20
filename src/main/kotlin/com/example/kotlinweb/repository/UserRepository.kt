package com.example.kotlinweb.repository

import com.example.kotlinweb.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String>{
    fun findByToken(token:String):User?
}