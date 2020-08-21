package com.example.kotlinweb.board.repository

interface PostRepository<T> {
    fun <T> save(t: T)
    fun find(): Any
    fun findById(t: Long): Any
    fun <T> delete(t: T)
}