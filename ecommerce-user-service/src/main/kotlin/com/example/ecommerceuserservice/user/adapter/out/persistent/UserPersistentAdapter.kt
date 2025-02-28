package com.example.ecommerceuserservice.user.adapter.out.persistent

import com.example.ecommerceuserservice.common.PersistentAdapter
import com.example.ecommerceuserservice.user.adapter.out.persistent.repository.UserRepository
import com.example.ecommerceuserservice.user.adapter.out.persistent.repository.UserValidationRepository
import com.example.ecommerceuserservice.user.application.port.out.LoadUserPort
import com.example.ecommerceuserservice.user.application.port.out.SaveUserPort
import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId


@PersistentAdapter
class UserPersistentAdapter(
    private val userRepository: UserRepository,
    private val userValidationRepository: UserValidationRepository
) : LoadUserPort, SaveUserPort{

    override fun getUser(userId: UserId): User? {
        return userRepository.getUser(id = userId)
    }

    override fun save(user: User): UserId {
        return userRepository.save(user)
    }

}