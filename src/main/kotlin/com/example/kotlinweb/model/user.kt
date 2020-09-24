package com.example.kotlinweb.model

import javax.persistence.*


@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null,

        @Column(name = "name")
        var name:String,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user", fetch=FetchType.LAZY )
        var boards: MutableList<Board> = mutableListOf()
) {
        constructor():this(null,"", mutableListOf<Board>())
}