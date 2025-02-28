package com.example.ecommerceuserservice.security.handler

import com.example.ecommerceuserservice.security.TokenProvider
import com.example.ecommerceuserservice.user.adapter.`in`.web.response.ApiResponse
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler

class CustomLoginSuccessHandler(private val tokenProvider: TokenProvider) : SimpleUrlAuthenticationSuccessHandler(){

    private val objectMapper = jacksonObjectMapper()

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val username = authentication.name

        val apiResponse = ApiResponse.with(HttpStatus.OK, "authentication success", null)


        val token = tokenProvider.createAccessToken(username)
        tokenProvider.setHeaderAccessToken(response, token)

        response.status = HttpServletResponse.SC_OK
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writer().writeValueAsString(apiResponse))
        response.writer.flush()
        response.writer.close()
    }

}