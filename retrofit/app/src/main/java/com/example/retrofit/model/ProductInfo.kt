package com.example.retrofit.model

data class ProductInfo(
    val limit: Int?=null,
    val products: List<Product>?=null,
    val skip: Int?=null,
    val total: Int?=null
)