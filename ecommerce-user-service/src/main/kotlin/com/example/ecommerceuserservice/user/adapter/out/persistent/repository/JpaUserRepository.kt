package com.example.ecommerceuserservice.user.adapter.out.persistent.repository

import com.example.ecommerceuserservice.user.adapter.out.persistent.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface JpaUserRepository : JpaRepository<UserEntity, Long> {
}