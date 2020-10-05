package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.repository.PostCrudRepository
import com.example.kotlinweb.board.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl(private val postCrudRepository: PostCrudRepository) : BoardService {

    override fun savePost(post: Post) {
        postCrudRepository.save(post)
    }

    override fun findPosts(): Any {
        return postCrudRepository.findAll()
    }

    override fun updatePost(post: Post) {
        var foundPost: Post = postCrudRepository.findByIdOrNull(post.id) as Post
        if(foundPost != null) {
            foundPost = post
        }
    }

    override fun deletePost(post: Post) {
        var foundPost: Post = postCrudRepository.findById(post.id) as Post
        foundPost?.let {
            postCrudRepository.delete(post)
        }
    }
}