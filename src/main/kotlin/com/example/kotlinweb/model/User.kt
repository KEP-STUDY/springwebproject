package com.example.kotlinweb.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
        @Id
        val id: String,
        val password: String,
        val name: String,
        var token: String? = null
)