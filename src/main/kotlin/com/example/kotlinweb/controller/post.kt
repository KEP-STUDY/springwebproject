package com.example.kotlinweb.controller

import com.example.kotlinweb.entity.Post
import com.example.kotlinweb.model.CreatePostRequest
import com.example.kotlinweb.model.UpdatePostRequest
import com.example.kotlinweb.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class PostController(private val postService: PostService){
    @GetMapping("/post")
    fun findAll(): ResponseEntity<List<Post>> {
        return ResponseEntity.ok(postService.findAll())
    }
    @GetMapping("/post/{id}")
    fun findOne(@PathVariable id:Long):ResponseEntity<Post>{
        return ResponseEntity.ok(postService.getPostById(id))
    }
    @PostMapping("/post")
    fun create(@RequestBody requestBody: CreatePostRequest):ResponseEntity<Post>{
        return ResponseEntity.ok(postService.save(requestBody))
    }

    @PatchMapping("/post/{id}")
    fun update(@PathVariable id:Long, @RequestBody requestBody: UpdatePostRequest):ResponseEntity<Post>{
        return ResponseEntity.ok(postService.update(id,requestBody))
    }

}