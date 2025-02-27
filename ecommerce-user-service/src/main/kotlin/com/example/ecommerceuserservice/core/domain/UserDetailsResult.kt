package com.example.ecommerceuserservice.core.domain

data class UserDetailsResult (
    val userId: String,
    val email: String,
    val role: Role,
){
}