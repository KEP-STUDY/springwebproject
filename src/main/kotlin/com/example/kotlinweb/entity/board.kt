package com.example.kotlinweb.entity
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Board (
        @Column
        var title:String
): Auditable<String>() {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null

        var content: String? =null

        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        var user: User? = null
}