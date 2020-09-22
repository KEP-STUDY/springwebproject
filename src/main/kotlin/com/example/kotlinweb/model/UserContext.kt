package com.example.kotlinweb.model

object UserContext{

    private val exception = ThreadLocal<Exception>()
    private val user = ThreadLocal<User>()

    fun setUser(user:User) = this.user.set(user)

    fun getUser() = this.user.get()

    fun removeUser() = user.remove()

    fun removeException() = exception.remove()

    fun removeAll() {
        removeUser()
        removeException()
    }
}