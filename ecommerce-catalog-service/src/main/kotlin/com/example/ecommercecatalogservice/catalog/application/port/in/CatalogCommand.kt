package com.example.ecommercecatalogservice.catalog.application.port.`in`

data class CatalogSaveCommand (
    val productName: String,
    val stock: Int,
    val unitPrice: Int
){
}