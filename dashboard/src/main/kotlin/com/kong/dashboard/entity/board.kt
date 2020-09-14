package com.kong.dashboard.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "board")
data class BoardEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null,

        val title:String,

        val content: String,

        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        val user: UserEntity? = null
)