package com.example.ecommercecatalogservice.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class CatalogDatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "storage.datasource.catalog")
    fun catalogHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun coreDataSource(
        @Qualifier("catalogHikariConfig") config: HikariConfig,
    ): HikariDataSource {
        return HikariDataSource(config)
    }

}