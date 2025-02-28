package com.example.ecommercecatalogservice.catalog.application.port.out

import com.example.ecommercecatalogservice.catalog.domain.Catalog

interface SaveCatalogPort {
    fun save(catalog: Catalog): Unit
}