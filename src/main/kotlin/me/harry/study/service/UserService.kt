package me.harry.study.service

import me.harry.study.model.User
import me.harry.study.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        val userRepository: UserRepository
) {

    fun createUser(user:User): User {
        return userRepository.save(user)
    }

    fun getUserByName(name: String): User {
        return userRepository.findByName(name)
    }

}