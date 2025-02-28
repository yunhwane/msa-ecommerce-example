package com.example.ecommerceuserservice.user.application.port.out

import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId

interface LoadUserPort {
    fun getUser(userId: UserId): User?
    fun getUserByEmail(email: String): User?
}