package com.example.ecommerceuserservice.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.example.ecommerceuserservice.user.adapter.out.persistent"])
@EnableJpaRepositories(basePackages = ["com.example.ecommerceuserservice.user.adapter.out.persistent"])
internal class CoreJpaConfig