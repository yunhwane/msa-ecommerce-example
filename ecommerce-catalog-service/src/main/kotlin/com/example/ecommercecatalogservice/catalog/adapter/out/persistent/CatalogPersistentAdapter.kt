package com.example.ecommercecatalogservice.catalog.adapter.out.persistent

import com.example.ecommercecatalogservice.catalog.adapter.out.persistent.entity.CatalogEntity
import com.example.ecommercecatalogservice.catalog.adapter.out.persistent.repository.CatalogRepository
import com.example.ecommercecatalogservice.catalog.application.port.out.LoadCatalogPort
import com.example.ecommercecatalogservice.catalog.application.port.out.SaveCatalogPort
import com.example.ecommercecatalogservice.catalog.domain.Catalog
import com.example.ecommercecatalogservice.common.PersistentAdapter


@PersistentAdapter
class CatalogPersistentAdapter(
    private val catalogRepository: CatalogRepository,
) : LoadCatalogPort, SaveCatalogPort{

    override fun getCatalogs(): List<Catalog> {
        return catalogRepository.getCatalogs().map {
            Catalog(
                productId = it.productId,
                productName = it.productName,
                stock = it.stock,
                unitPrice = it.unitPrice,
            )
        }
    }

    override fun save(catalog: Catalog) {
        val catalogEntity = CatalogEntity(
            productName = catalog.productName,
            stock = catalog.stock,
            unitPrice = catalog.unitPrice,
        )

        catalogRepository.save(catalogEntity)
    }
}