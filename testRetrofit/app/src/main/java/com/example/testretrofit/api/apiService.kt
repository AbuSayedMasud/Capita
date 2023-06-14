package com.example.testretrofit.api

import com.example.testretrofit.models.Categories
import retrofit2.Response
import retrofit2.http.GET

interface apiService {
    @GET("products/categories")
    suspend fun getCategories(): Response<Categories>
}