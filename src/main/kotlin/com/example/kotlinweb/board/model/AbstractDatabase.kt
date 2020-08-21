package com.example.kotlinweb.board.model

class AbstractDatabase(

) {
    companion object {
        var posts: MutableList<Any> = mutableListOf()

        fun create(obj: Any?) {
            obj?.let {
                posts.add(obj)
            }
        }

        fun delete(obj: Any?) {
            obj?.let {
                obj as Post
                posts.removeAt(obj.id.toInt() - 1)
            }
        }

        fun read(): MutableList<Any> {
            return posts;
        }
    }
}