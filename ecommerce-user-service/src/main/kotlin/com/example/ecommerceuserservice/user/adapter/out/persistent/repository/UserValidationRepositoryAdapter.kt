package com.example.ecommerceuserservice.user.adapter.out.persistent.repository

import com.example.ecommerceuserservice.common.PersistentAdapter


@PersistentAdapter
class UserValidationRepositoryAdapter(
    private val queryDslUserRepository: QueryDslUserRepository
) : UserValidationRepository{

    override fun existsByEmail(email: String): Boolean {
        return queryDslUserRepository.existsByEmail(email)
    }


}