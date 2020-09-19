package me.harry.study.repository

import me.harry.study.model.Post
import me.harry.study.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PostRepository : ReactiveMongoRepository<Post, Long> {
}