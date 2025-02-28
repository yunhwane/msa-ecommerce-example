package com.example.ecommercecatalogservice.catalog.adapter.out.persistent.repository

import com.example.ecommercecatalogservice.catalog.adapter.out.persistent.entity.CatalogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaCatalogRepository : JpaRepository<CatalogEntity, Long> {
}