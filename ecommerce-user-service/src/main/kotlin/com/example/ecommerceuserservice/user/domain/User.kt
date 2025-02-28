package com.example.ecommerceuserservice.user.domain

data class User (
    val id: UserId? = null,
    val email: String,
    val role: Role,
    val password: String,
){
}