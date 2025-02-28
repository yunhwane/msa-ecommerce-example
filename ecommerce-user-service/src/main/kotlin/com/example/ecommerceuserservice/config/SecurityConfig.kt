package com.example.ecommerceuserservice.config

import com.example.ecommerceuserservice.security.TokenProvider
import com.example.ecommerceuserservice.security.filter.CustomUsernamePasswordAuthenticationFilter
import com.example.ecommerceuserservice.security.handler.CustomLoginFailHandler
import com.example.ecommerceuserservice.security.handler.CustomLoginSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
class SecurityConfig (
    private val tokenProvider: TokenProvider,
    private val userDetailsService: UserDetailsService,
){


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf {
            it.disable()
        }
        http.authorizeHttpRequests {
            it.anyRequest().permitAll()
        }

        http.sessionManagement {
            it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }

        http.formLogin {
            it.disable()
        }

        http.httpBasic {
            it.disable()
        }

        http.addFilterBefore(customUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun customUsernamePasswordAuthenticationFilter() : CustomUsernamePasswordAuthenticationFilter {
        CustomUsernamePasswordAuthenticationFilter().apply {
            setAuthenticationSuccessHandler(customLoginSuccessHandler())
            setAuthenticationFailureHandler(customLoginFailHandler())
            setAuthenticationManager(authenticationManager())
            return this
        }
    }

    @Bean
    fun customLoginFailHandler() : CustomLoginFailHandler {
        return CustomLoginFailHandler()
    }

    @Bean
    fun customLoginSuccessHandler() : CustomLoginSuccessHandler {
        return CustomLoginSuccessHandler(tokenProvider)
    }

    @Bean
    fun authenticationManager() : AuthenticationManager {
        DaoAuthenticationProvider().apply {
            setPasswordEncoder(passwordEncoder())
            setUserDetailsService(userDetailsService)
            return ProviderManager(this)
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}