package com.example.ecommerceuserservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class EcommerceUserServiceApplication

fun main(args: Array<String>) {
	runApplication<EcommerceUserServiceApplication>(*args)
}
