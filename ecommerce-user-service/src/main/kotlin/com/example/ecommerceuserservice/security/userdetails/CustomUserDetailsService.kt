package com.example.ecommerceuserservice.security.userdetails

import com.example.ecommerceuserservice.user.application.port.out.LoadUserPort
import com.example.ecommerceuserservice.user.domain.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val loadUserPort: LoadUserPort,
    ) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = loadUserPort.getUserByEmail(username) ?: throw UsernameNotFoundException("No user found with email: $username")
        return CustomUserDetails(user)

    }
}