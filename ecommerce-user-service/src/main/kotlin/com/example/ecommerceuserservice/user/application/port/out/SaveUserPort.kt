package com.example.ecommerceuserservice.user.application.port.out

import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId

interface SaveUserPort {
    fun save(user: User): UserId
}