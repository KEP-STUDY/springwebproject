package com.example.kotlinweb.entity

import javax.persistence.*


@Entity
@Table
data class User (
        @Column
        var name: String
): Auditable<String>() {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user", fetch = FetchType.LAZY)
        var boards: MutableList<Board> = mutableListOf()
}