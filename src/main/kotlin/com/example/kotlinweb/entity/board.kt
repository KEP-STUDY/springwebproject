package com.example.kotlinweb.entity
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table
data class Board (
        @Column
        var title:String
): Auditable<String>() {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null
}