package com.example.kotlinweb.entity


import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@EntityListeners(value = [AuditingEntityListener::class])
@MappedSuperclass
abstract class Auditable<U>{
    @CreatedBy
    var createdBy: U? = null

    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @CreatedDate
    var createdAt: LocalDateTime? = null

    @LastModifiedBy
    var updateBy: U? = null

    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @LastModifiedDate
    var updatedAt: LocalDateTime? = null
}