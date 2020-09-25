package com.example.kotlinweb.service

import com.example.kotlinweb.entity.Board
import com.example.kotlinweb.entity.User
import com.example.kotlinweb.model.CreateUserRequest
import com.example.kotlinweb.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository){
    fun findAll():List<User> {
        return userRepository.findAll()
    }

    fun save(createUserRequest: CreateUserRequest): User {
        return userRepository.save(User(null,createUserRequest.name, mutableListOf<Board>()))
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