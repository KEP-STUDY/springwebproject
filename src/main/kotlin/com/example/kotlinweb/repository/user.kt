package com.example.kotlinweb.repository

import com.example.kotlinweb.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User,Long>{

}