package com.example.ecommerceuserservice.user.adapter.out.persistent.repository

import com.example.ecommerceuserservice.user.adapter.out.persistent.entity.QUserEntity.userEntity
import com.example.ecommerceuserservice.user.adapter.out.persistent.entity.UserEntity
import com.example.ecommerceuserservice.user.domain.UserId
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository


@Repository
class QueryDslUserRepository (
    private val jpaQueryFactory: JPAQueryFactory
){

    fun getUser(id: UserId): UserEntity? {
        return jpaQueryFactory.selectFrom(userEntity)
            .where(userEntity.userId.eq(id.userId))
            .fetchOne();
    }

    fun existsByEmail(email: String): Boolean {
        return jpaQueryFactory.selectFrom(userEntity)
            .where(userEntity.email.eq(email))
            .fetchOne() != null
    }
}