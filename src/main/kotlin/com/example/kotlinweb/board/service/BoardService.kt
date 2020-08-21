package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Post

interface BoardService {
    fun savePost(post: Post)
    fun findPosts(): Any
    fun updatePost(post: Post)
    fun deletePost(post: Post)
}