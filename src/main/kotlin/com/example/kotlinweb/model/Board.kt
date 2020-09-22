package com.example.kotlinweb.model

import javax.persistence.*

@Entity
class Board(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null,
        var title:String,
        var content:String,
        @ManyToOne
        @JoinColumn(name = "userId")
        val user:User
)