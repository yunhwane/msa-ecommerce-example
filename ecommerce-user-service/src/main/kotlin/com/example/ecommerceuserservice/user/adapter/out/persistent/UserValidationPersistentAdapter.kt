package com.example.ecommerceuserservice.user.adapter.out.persistent

import com.example.ecommerceuserservice.common.PersistentAdapter
import com.example.ecommerceuserservice.user.adapter.out.persistent.repository.UserValidationRepository
import com.example.ecommerceuserservice.user.application.port.out.ValidateUserPort

@PersistentAdapter
class UserValidationPersistentAdapter(
    private val userValidationRepository: UserValidationRepository
) : ValidateUserPort{

    override fun existsByEmail(email: String): Boolean {
        return userValidationRepository.existsByEmail(email)
    }
}