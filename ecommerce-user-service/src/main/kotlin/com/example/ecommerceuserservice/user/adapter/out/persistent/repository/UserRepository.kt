package com.example.ecommerceuserservice.user.adapter.out.persistent.repository

import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId


interface UserRepository {
    fun save(user: User): UserId
    fun getUser(id: UserId): User?
    fun getUserByEmail(email: String): User?
}