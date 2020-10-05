package com.example.kotlinweb.board.model

import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Post(

    @Id
    @GeneratedValue(starategy = GenerationType.AUTO)
    val id: Long,
    @Column
    val title: String,
    @Column
    val writer: String,
    @Column
    val text: String
) {
    @Column
    val createDate: LocalDateTime = LocalDateTime.now()
    @Column
    var updateDate: LocalDateTime = LocalDateTime.now()
}