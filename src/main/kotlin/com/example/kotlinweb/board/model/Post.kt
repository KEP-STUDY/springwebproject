package com.example.kotlinweb.board.model

import java.time.LocalDateTime

class Post(
    val id: Long, val title: String, val writer: String, val text: String
) {
    val createDate: LocalDateTime = LocalDateTime.now()
    var updateDate: LocalDateTime = LocalDateTime.now()
}