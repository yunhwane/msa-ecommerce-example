package com.example.ecommercecatalogservice.catalog.adapter.`in`.web.api

import com.example.ecommercecatalogservice.catalog.adapter.`in`.web.request.SaveCatalogRequest
import com.example.ecommercecatalogservice.catalog.adapter.`in`.web.response.ApiResponse
import com.example.ecommercecatalogservice.catalog.adapter.`in`.web.response.LoadCatalogsResponse
import com.example.ecommercecatalogservice.catalog.application.port.`in`.CatalogSaveCommand
import com.example.ecommercecatalogservice.catalog.application.port.`in`.CatalogsUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RestController
@RequestMapping(value = ["/api/v1/catalogs"])
class CatalogController(
    private val catalogsUseCase: CatalogsUseCase
){

    @GetMapping
    fun getCatalogs(): ResponseEntity<ApiResponse<List<LoadCatalogsResponse>>> {
        return ResponseEntity.ok().body(
            ApiResponse.with(
                HttpStatus.OK,
                "success",
                catalogsUseCase.getCatalogs().map {
                    LoadCatalogsResponse(
                        productId = it.productId!!,
                        productName = it.productName,
                        stock = it.stock,
                        unitPrice = it.unitPrice
                    )
                }
            )
        )
    }

    @PostMapping
    fun save(request: SaveCatalogRequest): ResponseEntity<ApiResponse<Any>> {

        val command = CatalogSaveCommand(
            productName = request.productName,
            stock = request.stock,
            unitPrice = request.unitPrice
        )

        catalogsUseCase.save(command = command)

        return ResponseEntity.created(URI.create("/api/v1/catalogs"))
            .body(ApiResponse.with(
                httpStatus = HttpStatus.CREATED,
                message = "success",
                data = null,
            )
        )
    }

}