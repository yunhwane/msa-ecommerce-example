package com.example.ecommerceuserservice.user.application.port.`in`

import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId

interface UserUseCase {
    fun getUser(id: UserId): User
    fun save(command: UserSaveCommand): UserId
}