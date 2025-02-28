package com.example.ecommercecatalogservice.catalog.adapter.out.persistent.repository

import com.example.ecommercecatalogservice.catalog.adapter.out.persistent.entity.CatalogEntity
import com.example.ecommercecatalogservice.common.PersistentAdapter


@PersistentAdapter
class CatalogRepositoryAdapter(
    private val jpaCatalogRepository: JpaCatalogRepository
) : CatalogRepository{

    override fun getCatalogs(): List<CatalogEntity> {
        return jpaCatalogRepository.findAll()
    }

    override fun save(catalogEntity: CatalogEntity) {
        jpaCatalogRepository.save(catalogEntity)
    }
}