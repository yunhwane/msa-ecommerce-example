package com.example.ecommerceuserservice.security

import com.example.ecommerceuserservice.common.Provider
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletResponse
import java.util.*
import javax.crypto.SecretKey

const val SECRET_KEY = "secret"
const val EXPIRATION_TIME = 1000L * 60 * 60 * 24 * 10
const val TOKEN_PREFIX = "Bearer "
const val HEADER_STRING = "Authorization"
const val EMAIL_CLAIM = "email"


@Provider
class JwtTokenProvider : TokenProvider {

    private val secretKey: SecretKey = Keys.hmacShaKeyFor(SECRET_KEY.repeat(16).toByteArray())

    override fun createAccessToken(email: String): String {
        val now = Date()
        val verifyDate = Date(now.time + EXPIRATION_TIME)

        return Jwts.builder()
            .setClaims(mapOf(EMAIL_CLAIM to email))
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .setIssuedAt(now)
            .setExpiration(verifyDate)
            .compact()
    }

    override fun setHeaderAccessToken(httpServletResponse: HttpServletResponse, accessToken: String) {
        httpServletResponse.addHeader(HEADER_STRING, "$TOKEN_PREFIX$accessToken")
    }

}