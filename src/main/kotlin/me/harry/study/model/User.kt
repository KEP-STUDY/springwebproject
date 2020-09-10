package me.harry.study.model

import me.harry.study.payload.UserJoinRequest
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "user")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,

    @Column(name = "name")
    var name:String,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user")
    val boards: MutableList<Board> = mutableListOf()
)