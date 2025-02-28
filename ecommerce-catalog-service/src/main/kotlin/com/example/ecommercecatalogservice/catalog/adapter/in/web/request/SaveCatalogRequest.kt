package com.example.ecommercecatalogservice.catalog.adapter.`in`.web.request

data class SaveCatalogRequest (
    val productName: String,
    val stock: Int,
    val unitPrice: Int,
){
}