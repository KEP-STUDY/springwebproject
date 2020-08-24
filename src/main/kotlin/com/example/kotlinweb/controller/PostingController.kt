package com.example.kotlinweb.controller

import com.example.kotlinweb.db.Content
import com.example.kotlinweb.service.Service
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1")
class PostingController(
        val service: Service
) {
    @PostMapping("/post")
    fun addPostToBlog(
            @RequestBody content: Content
    ) {
        service.addContent(content)
    }

    @GetMapping("/get")
    fun getPostedBlogList(): List<Content> {
        return service.blogDB.blogList
    }

    @PutMapping("/update")
    fun updateBlogList(
            @RequestBody content: Content
    ) {
        service.updateContent(content)
    }

    @DeleteMapping("/delete")
    fun deletePostedBlogList(
            @RequestBody id: Int
    ) {
        service.deleteContent(id)
    }

}