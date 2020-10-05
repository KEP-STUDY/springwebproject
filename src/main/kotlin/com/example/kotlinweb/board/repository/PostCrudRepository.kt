package com.example.kotlinweb.board.repository

import com.example.kotlinweb.board.model.AbstractDatabase
import com.example.kotlinweb.board.model.Post
import org.springframework.data.domain.Example
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.Id

@Repository
interface PostCrudRepository : JpaRepository<Post, Long> {

}