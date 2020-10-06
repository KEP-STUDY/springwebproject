package com.example.kotlinweb.board.repository

import com.example.kotlinweb.board.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostCrudRepository : JpaRepository<Post, Long> {

}