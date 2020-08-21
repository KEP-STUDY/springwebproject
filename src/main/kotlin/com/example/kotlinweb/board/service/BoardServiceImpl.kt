package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl(private val postRepository: PostRepository<Post>) : BoardService {

    override fun savePost(post: Post) {
        postRepository.save(post)
    }

    override fun findPosts(): Any {
        return postRepository.find()
    }

    override fun updatePost(post: Post) {
        var foundPost: Post = postRepository.findById(post.id) as Post
        foundPost?.let {
            postRepository.delete(post)
            postRepository.save(post)
        }
    }

    override fun deletePost(post: Post) {
        var foundPost: Post = postRepository.findById(post.id) as Post
        foundPost?.let {
            postRepository.delete(post)
        }
    }
}