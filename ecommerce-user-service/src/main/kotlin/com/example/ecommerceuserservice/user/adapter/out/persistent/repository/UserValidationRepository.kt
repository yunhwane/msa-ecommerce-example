package com.example.ecommerceuserservice.user.adapter.out.persistent.repository

interface UserValidationRepository {
    fun existsByEmail(email: String): Boolean
}