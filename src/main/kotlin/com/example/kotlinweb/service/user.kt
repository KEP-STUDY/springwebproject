package com.example.kotlinweb.service

import com.example.kotlinweb.model.Board
import com.example.kotlinweb.model.User
import com.example.kotlinweb.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository){
    fun findAll():List<User> {
        return userRepository.findAll()
    }

    fun save(): User {
        return userRepository.save(User(null,"hi", mutableListOf<Board>()))
    }

    fun getUserById(id:Long):User{
        return userRepository.findByIdOrNull(id) ?: throw Exception("There is no user with that ID.")
    }

    fun update(): User {
        val targetUser:User = getUserById(1)
        targetUser.name="Change"
        return userRepository.save(targetUser)
    }
}