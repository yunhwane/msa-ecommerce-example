package com.example.ecommercecatalogservice.catalog.adapter.`in`.web.response

data class LoadCatalogsResponse (
    val productId: String,
    val productName: String,
    val stock: Int,
    val unitPrice: Int,
){
}