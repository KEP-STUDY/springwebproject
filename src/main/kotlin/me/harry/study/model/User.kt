package me.harry.study.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
class User (
    @Id
    val id:Long,
    val name:String
)