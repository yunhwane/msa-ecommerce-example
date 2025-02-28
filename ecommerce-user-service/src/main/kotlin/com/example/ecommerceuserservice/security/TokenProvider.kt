package com.example.ecommerceuserservice.security

import jakarta.servlet.http.HttpServletResponse

interface TokenProvider {
    fun createAccessToken(email: String): String
    fun setHeaderAccessToken(httpServletResponse: HttpServletResponse, accessToken: String)
}