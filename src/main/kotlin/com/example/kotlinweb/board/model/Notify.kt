package com.example.kotlinweb.board.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Notify(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var postId: String,

    @Column
    val message: String

) {
    companion object {
        fun of(postId: String, message: String): Notify {
            return Notify(null, postId, message)
        }
    }

    @Column
    @CreationTimestamp
    lateinit var createDate: LocalDateTime

    @Column
    @UpdateTimestamp
    lateinit var updateDate: LocalDateTime

}