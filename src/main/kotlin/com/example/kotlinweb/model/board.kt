package com.example.kotlinweb.model
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Board (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null,

        val title:String,

        val content: String,

        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        val user: User? = null
)