package me.harry.study.repository

import me.harry.study.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface UserRepository : ReactiveMongoRepository<User, Long> {
}