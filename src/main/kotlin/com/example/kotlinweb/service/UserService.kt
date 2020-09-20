package com.example.kotlinweb.service

import com.example.kotlinweb.model.User
import com.example.kotlinweb.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.ZonedDateTime
import kotlin.random.Random

@Service
class UserService(
        private val userRepository: UserRepository
){

    fun login(id: String, password: String):User{
        val user = findUser(id)
        if(user.password != password) throw RuntimeException("not found user")
        user.token = Random(ZonedDateTime.now().toInstant().toEpochMilli()).nextBits(12).toString()
        return user
    }

    fun logout(id: String):User{
        val user =findUser(id)
        user.token = null
        return user
    }

    fun register(user: User){
        userRepository.save(user)
    }

    fun getUserByToken(token:String):User{
        return userRepository.findByToken(token) ?: throw RuntimeException("not found user");
    }

    private fun findUser(id:String):User{
        return userRepository.findByIdOrNull(id) ?: throw RuntimeException("not found user")
    }
}