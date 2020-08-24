package com.example.kotlinweb.service

import com.example.kotlinweb.db.BlogDB
import com.example.kotlinweb.db.Content
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Service @Autowired constructor(
        val blogDB: BlogDB
) {
    fun addContent(content: Content) {
        blogDB.blogList.add(content)
    }
    fun updateContent(content: Content){
        val updateItem = blogDB.blogList.filter { it.id == content.id }
//        updateItem = content
    }
    fun deleteContent(id : Int){
        val deleteItem = blogDB.blogList.filter { it.id == id }
        blogDB.blogList.remove(deleteItem)
    }
}