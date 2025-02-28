package com.example.ecommerceuserservice.user.adapter.out.persistent.entity

import com.example.ecommerceuserservice.user.domain.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.util.*

@Entity
class UserEntity (

    @Column(name = "email")
    val email: String,

    @Column(name = "userId")
    val userId: String = UUID.randomUUID().toString(),

    @Column(name = "password")
    val password: String,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: Role

) : BaseEntity(){
}