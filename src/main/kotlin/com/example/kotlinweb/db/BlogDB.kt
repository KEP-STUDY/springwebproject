package com.example.kotlinweb.db

import org.springframework.stereotype.Component

@Component
class BlogDB {
    val blogList : MutableList<Content> = mutableListOf()

}