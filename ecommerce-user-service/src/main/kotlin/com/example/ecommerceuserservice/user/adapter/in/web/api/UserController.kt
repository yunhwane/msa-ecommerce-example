package com.example.ecommerceuserservice.user.adapter.`in`.web.api

import com.example.ecommerceuserservice.user.adapter.`in`.web.request.UserSaveRequest
import com.example.ecommerceuserservice.user.adapter.`in`.web.response.ApiResponse
import com.example.ecommerceuserservice.user.adapter.`in`.web.response.GetUserResponse
import com.example.ecommerceuserservice.user.adapter.`in`.web.response.SaveUserResponse
import com.example.ecommerceuserservice.user.application.port.`in`.UserSaveCommand
import com.example.ecommerceuserservice.user.application.port.`in`.UserUseCase
import com.example.ecommerceuserservice.user.domain.User
import com.example.ecommerceuserservice.user.domain.UserId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping("/api/v1/users")
class UserController (
    private val userUseCase: UserUseCase
){

    @RequestMapping("/hello")
    fun hello(): String {
        return "Hello from User Service"
    }

    @PostMapping
    fun saveUser(@RequestBody request: UserSaveRequest): ResponseEntity<ApiResponse<SaveUserResponse>> {
        val command = UserSaveCommand(request.email, request.password)
        val userId = userUseCase.save(command)

        val response = SaveUserResponse(userId.userId)

        return ResponseEntity.created(URI.create("/api/v1/login"))
            .body(ApiResponse.with(HttpStatus.CREATED, "User successfully created", response))
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: String): ResponseEntity<ApiResponse<GetUserResponse>> {
        val user = userUseCase.getUser(UserId(userId))
        val getUserResponse = user.id?.userId?.let {
            GetUserResponse(
                email = user.email,
                userId = it
            )
        }

        return ResponseEntity.ok().body(
            ApiResponse.with(
                HttpStatus.OK,
                message = "success",
                data = getUserResponse
            )
        )
    }
}