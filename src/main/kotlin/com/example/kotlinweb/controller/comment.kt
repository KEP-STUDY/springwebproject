package com.example.kotlinweb.controller

import com.example.kotlinweb.entity.Comment
import com.example.kotlinweb.model.CreateCommentRequest
import com.example.kotlinweb.model.UpdateCommentRequest
import com.example.kotlinweb.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class CommentController(private val commentService: CommentService){
    @GetMapping("/comment")
    fun findAll(): ResponseEntity<List<Comment>> {
        return ResponseEntity.ok(commentService.findAll())
    }
    @GetMapping("/comment/{id}")
    fun findOne(@PathVariable id:Long):ResponseEntity<Comment>{
        return ResponseEntity.ok(commentService.getCommentById(id))
    }
    @PostMapping("/comment")
    fun create(@RequestBody requestBody: CreateCommentRequest):ResponseEntity<Comment>{
        return ResponseEntity.ok(commentService.save(requestBody))
    }

    @PatchMapping("/comment/{id}")
    fun update(@PathVariable id:Long, @RequestBody requestBody: UpdateCommentRequest):ResponseEntity<Comment>{
        return ResponseEntity.ok(commentService.update(id,requestBody))
    }

}