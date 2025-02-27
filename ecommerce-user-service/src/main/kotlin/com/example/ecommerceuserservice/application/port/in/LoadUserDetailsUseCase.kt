package com.example.ecommerceuserservice.application.port.`in`

import com.example.ecommerceuserservice.core.domain.UserDetailsResult
import com.example.ecommerceuserservice.core.domain.UserId

interface LoadUserDetailsUseCase {
    fun loadUserDetails(userId: UserId): UserDetailsResult
}