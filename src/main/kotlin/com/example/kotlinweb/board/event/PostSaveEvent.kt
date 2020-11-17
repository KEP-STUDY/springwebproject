package com.example.kotlinweb.board.event

data class PostSaveEvent(
    private val postId: Long,
    private val message: String
) {
    fun getPostId(): Long {
        return postId
    }

    fun getMessage(): String {
        return message
    }
}