package com.example.kotlinweb.board.repository

import com.example.kotlinweb.board.model.AbstractDatabase
import com.example.kotlinweb.board.model.Post
import org.springframework.stereotype.Repository

@Repository
class PostCrudRepository : PostRepository<Post> {

    override fun <Post> save(post: Post) {
        AbstractDatabase.create(post);
    }

    override fun find(): MutableList<Any> {
        return AbstractDatabase.read()
    }

    override fun findById(postId: Long): Post {
        return find().map { any -> any as Post }.first { post -> post.id == postId }
    }

    override fun <Post> delete(post: Post) {
        return AbstractDatabase.delete(post)
    }
}