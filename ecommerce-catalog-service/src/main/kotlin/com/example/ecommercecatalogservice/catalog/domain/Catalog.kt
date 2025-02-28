package com.example.ecommercecatalogservice.catalog.domain

import java.util.*


data class Catalog (
    val productId: String? = null,
    val productName: String,
    val stock: Int,
    val unitPrice: Int,
){
}