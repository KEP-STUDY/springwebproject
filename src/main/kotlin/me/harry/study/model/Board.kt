package me.harry.study.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Board (
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       val id:Long? = null,

       val title:String,

       val content: String,

       @ManyToOne
       @JoinColumn(name = "user_id")
       @JsonIgnore
       val user: User? = null
)