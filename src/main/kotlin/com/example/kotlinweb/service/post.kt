package com.example.kotlinweb.service

import com.example.kotlinweb.entity.Post
import com.example.kotlinweb.model.CreatePostRequest
import com.example.kotlinweb.model.UpdatePostRequest
import com.example.kotlinweb.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService(val postRepository: PostRepository){
    fun findAll():List<Post> {
        return postRepository.findAll()
    }

    fun save(createPostRequest: CreatePostRequest): Post {
        return postRepository.save(Post(createPostRequest.title))
    }

    fun getPostById(id:Long): Post {
        return postRepository.findByIdOrNull(id) ?: throw Exception("There is no post with that ID.")
    }

    fun update(id:Long,updatePostRequest: UpdatePostRequest): Post {
        val targetPost: Post = getPostById(id)
        return postRepository.save(targetPost)
    }
}