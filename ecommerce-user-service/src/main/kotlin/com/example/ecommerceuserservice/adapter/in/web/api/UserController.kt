package com.example.ecommerceuserservice.adapter.`in`.web.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/users")
class UserController {

    @RequestMapping("/hello")
    fun hello(): String {
        return "Hello from User Service"
    }
}