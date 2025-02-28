package com.example.ecommerceuserservice.user.application.port.out

interface ValidateUserPort {
    fun existsByEmail(email: String): Boolean
}