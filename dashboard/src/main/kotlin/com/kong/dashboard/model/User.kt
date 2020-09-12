package com.kong.dashboard.model

import javax.persistence.*

@Entity
@Table(name = "user")
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null,

        @Column(name = "name")
        val name:String,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user")
        val boards: MutableList<Board> = mutableListOf()
)