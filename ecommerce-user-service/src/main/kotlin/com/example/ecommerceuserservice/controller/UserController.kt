package com.example.ecommerceuserservice.controller

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