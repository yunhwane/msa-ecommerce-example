package com.example.ecommercecatalogservice.catalog.application.service

import com.example.ecommercecatalogservice.catalog.application.port.`in`.CatalogSaveCommand
import com.example.ecommercecatalogservice.catalog.application.port.`in`.CatalogsUseCase
import com.example.ecommercecatalogservice.catalog.application.port.out.LoadCatalogPort
import com.example.ecommercecatalogservice.catalog.application.port.out.SaveCatalogPort
import com.example.ecommercecatalogservice.catalog.domain.Catalog
import com.example.ecommercecatalogservice.common.UseCase

@UseCase
class CatalogsService(
    private val loadCatalogsPort: LoadCatalogPort,
    private val saveCatalogPort: SaveCatalogPort,
) : CatalogsUseCase {

    override fun getCatalogs(): List<Catalog> {
        return loadCatalogsPort.getCatalogs()
    }

    override fun save(command: CatalogSaveCommand) {
        val catalog = Catalog(
            productName = command.productName,
            unitPrice = command.unitPrice,
            stock = command.stock,
        )
        return saveCatalogPort.save(catalog)
    }
}