package com.example.ecommercecatalogservice.catalog.adapter.out.persistent.repository

import com.example.ecommercecatalogservice.catalog.adapter.out.persistent.entity.CatalogEntity

interface CatalogRepository {
    fun getCatalogs(): List<CatalogEntity>
    fun save(catalogEntity: CatalogEntity)
}