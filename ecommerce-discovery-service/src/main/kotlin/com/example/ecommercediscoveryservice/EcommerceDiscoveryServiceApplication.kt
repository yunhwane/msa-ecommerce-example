package com.example.ecommercediscoveryservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EcommerceDiscoveryServiceApplication

fun main(args: Array<String>) {
	runApplication<EcommerceDiscoveryServiceApplication>(*args)
}
