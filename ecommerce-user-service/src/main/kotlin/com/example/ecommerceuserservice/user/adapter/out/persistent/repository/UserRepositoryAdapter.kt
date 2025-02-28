package com.example.ecommerceuserservice.user.adapter.out.persistent.repository

import com.example.ecommerceuserservice.common.PersistentAdapter
import com.example.ecommerceuserservice.user.adapter.out.persistent.entity.UserEntity
import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId

@PersistentAdapter
class UserRepositoryAdapter(
    private val jpaUserRepository: JpaUserRepository,
    private val queryDslUserRepository: QueryDslUserRepository
) : UserRepository {


    override fun save(user: User): UserId {
        val userEntity = UserEntity(
            email = user.email,
            password = user.password,
            role = user.role
        )
        val saveUserEntity = jpaUserRepository.save(userEntity)
        return UserId(saveUserEntity.userId)
    }

    override fun getUser(id: UserId): User? {
        val userEntity = queryDslUserRepository.getUser(id)
        return userEntity?.let {
            User(
                id = UserId(it.userId),
                email = it.email,
                password = it.password,
                role = it.role
            )
        }
    }
}