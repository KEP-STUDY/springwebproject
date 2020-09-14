package com.kong.dashboard.entity

import javax.persistence.*

@Entity
@Table(name = "user")
data class UserEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null,

        @Column(name = "name")
        val name:String,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user")
        val boards: MutableList<BoardEntity> = mutableListOf()
)