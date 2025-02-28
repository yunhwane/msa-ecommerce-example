package com.example.ecommerceuserservice.user.application.port.`in`

data class UserSaveCommand (
    val email: String,
    val password: String,
){
}