package com.example.kotlinweb.service

import com.example.kotlinweb.entity.Comment
import com.example.kotlinweb.model.CreateCommentRequest
import com.example.kotlinweb.model.UpdateCommentRequest
import com.example.kotlinweb.repository.CommentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CommentService(val commentRepository: CommentRepository){
    fun findAll():List<Comment> {
        return commentRepository.findAll()
    }

    fun save(createCommentRequest: CreateCommentRequest): Comment {
        return commentRepository.save(Comment(createCommentRequest.title))
    }

    fun getCommentById(id:Long): Comment {
        return commentRepository.findByIdOrNull(id) ?: throw Exception("There is no comment with that ID.")
    }

    fun update(id:Long,updateCommentRequest: UpdateCommentRequest): Comment {
        val targetComment: Comment = getCommentById(id)
        return commentRepository.save(targetComment)
    }
}