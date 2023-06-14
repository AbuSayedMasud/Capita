package com.example.retrofit.api

import com.example.retrofit.model.Categories
import com.example.retrofit.model.ProductInfo
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProductInfo():Response<ProductInfo>

    @GET("products/categories")
    suspend fun getCategories():Response<Categories>
}