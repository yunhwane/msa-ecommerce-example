package com.example.ecommercecatalogservice.catalog.application.port.`in`

import com.example.ecommercecatalogservice.catalog.domain.Catalog


interface CatalogsUseCase {
    fun getCatalogs(): List<Catalog>
    fun save(command: CatalogSaveCommand): Unit
}