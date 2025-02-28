package com.example.ecommerceuserservice.security.handler

import com.example.ecommerceuserservice.user.adapter.`in`.web.response.ApiResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import java.io.IOException


class CustomLoginFailHandler : SimpleUrlAuthenticationFailureHandler() {


    private val objectMapper = jacksonObjectMapper()

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        exception: AuthenticationException?
    ) {


        val apiResponse = ApiResponse.with(HttpStatus.UNAUTHORIZED, "Authentication failed", null)

        response.status = HttpServletResponse.SC_UNAUTHORIZED
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(apiResponse))
        response.writer.flush()
        response.writer.close()
    }
}