package com.example.ecommerceuserservice.exception

import com.example.ecommerceuserservice.user.adapter.`in`.web.response.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus


import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ApiControllerAdvice {

    private val log = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        log.error("Exception : {}", e.message, e)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ApiResponse.error(
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
                message = "internal server error",
            )
        )
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(e: NoSuchElementException): ResponseEntity<ApiResponse<Any>> {
        log.error("NoSuchElementException : {}", e.message, e)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ApiResponse.error(
                httpStatus = HttpStatus.NOT_FOUND,
                message = e.message.toString(),
            )
        )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<ApiResponse<Any>> {
        log.error("IllegalArgumentException : {}", e.message, e)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ApiResponse.error(
                httpStatus = HttpStatus.BAD_REQUEST,
                message = e.message.toString(),
            )
        )
    }
}