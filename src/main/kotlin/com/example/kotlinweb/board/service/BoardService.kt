package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.repository.PostCrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class BoardService(private val postCrudRepository: PostCrudRepository) {

    fun savePost(post: Post) {
        postCrudRepository.save(post)
    }

    @Transactional(readOnly = true)
    fun findPostById(id: Long): Post? {
        return postCrudRepository.findByIdOrNull(id)
    }

    @Transactional(readOnly = true)
    fun findPosts(): MutableList<Post> {
        return postCrudRepository.findAll()
    }

    @Transactional
    fun updatePost(post: Post) {
        print(post.toString())
        var foundPost: Post = postCrudRepository.findByIdOrNull(post.id) as Post
        foundPost.text = post.text
        foundPost.title = post.title
    }

    @Transactional
    fun deletePost(post: Post) {
        var foundPost: Post = postCrudRepository.findById(post.id) as Post
        foundPost?.let {
            postCrudRepository.delete(post)
        }
    }
}