package com.example.kotlinweb.board.event

import com.example.kotlinweb.board.model.Post
import javax.persistence.*


class PostEntityListener {

    @PostLoad
    fun postLoad(post: Post?) {
        println("post load: $post")
    }

    @PrePersist
    fun prePersist(post: Post?) {
        println("pre persist: $post")
    }

    @PostPersist
    fun postPersist(post: Post?) {
        println("post persist: $post")
    }

    @PreUpdate
    fun preUpdate(post: Post?) {
        println("pre update: $post")
    }

    @PostUpdate
    fun postUpdate(post: Post?) {
        println("post update: $post")
    }

    @PreRemove
    fun preRemove(post: Post?) {
        println("pre remove: $post")
    }

    @PostRemove
    fun postRemove(post: Post?) {
        println("post remove: $post")
    }
}