package com.example.kotlinweb.entity
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Board (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null,

        var title:String,

        var content: String,

        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        var user: User? = null
)