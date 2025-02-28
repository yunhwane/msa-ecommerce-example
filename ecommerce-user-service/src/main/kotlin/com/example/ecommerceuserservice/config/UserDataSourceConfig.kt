package com.example.ecommerceuserservice.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class UserDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "storage.datasource.user")
    fun userHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun coreDataSource(
        @Qualifier("userHikariConfig") config: HikariConfig,
    ): HikariDataSource {
        return HikariDataSource(config)
    }

}