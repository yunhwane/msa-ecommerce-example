package com.example.ecommercecatalogservice.catalog.adapter.out.persistent.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity


@Entity
class CatalogEntity (

    @Column(name = "productId")
    val productId: String,

    @Column(name = "productName")
    val productName: String,

    @Column(name = "stock")
    val stock: Int,

    @Column(name = "unitPrice")
    val unitPrice: Int,

): BaseEntity() {
}