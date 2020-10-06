package com.example.kotlinweb.board.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column
    var title: String,
    @Column
    val writer: String,
    @Column
    var text: String
) {
    @Column
    @CreationTimestamp
    lateinit var createDate: LocalDateTime

    @Column
    @UpdateTimestamp
    lateinit var updateDate: LocalDateTime
}