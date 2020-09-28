package com.example.kotlinweb.entity

import javax.persistence.*

@Entity
@Table
data class Post (
        @Column
        var title:String
): Auditable<String>() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}