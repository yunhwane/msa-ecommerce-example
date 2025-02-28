package com.example.ecommerceuserservice.user.application.service

import com.example.ecommerceuserservice.common.UseCase
import com.example.ecommerceuserservice.user.application.port.`in`.UserSaveCommand
import com.example.ecommerceuserservice.user.application.port.`in`.UserUseCase
import com.example.ecommerceuserservice.user.application.port.out.LoadUserPort
import com.example.ecommerceuserservice.user.application.port.out.SaveUserPort
import com.example.ecommerceuserservice.user.application.port.out.ValidateUserPort
import com.example.ecommerceuserservice.user.domain.Role
import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.transaction.annotation.Transactional


@UseCase
@Transactional(readOnly = true)
class UserService (
    private val loadUserPort: LoadUserPort,
    private val validateUserPort: ValidateUserPort,
    private val saveUserPort: SaveUserPort,
    private val passwordEncoder: PasswordEncoder

) : UserUseCase {

    override fun getUser(id: UserId): User {
        val user = loadUserPort.getUser(id) ?: throw IllegalStateException("User with id $id not found")
        return user
    }

    @Transactional
    override fun save(command: UserSaveCommand): UserId {

        require(!validateUserPort.existsByEmail(command.email)) {
            "User with email ${command.email} duplicated"
        }

        val encryptPassword = passwordEncoder.encode(command.password)

        return saveUserPort.save(
            User(
                id = null,
                email = command.email,
                password = encryptPassword,
                role = Role.USER
            )
        )
    }
}