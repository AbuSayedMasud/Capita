package com.example.testretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testretrofit.api.apiService
import com.example.testretrofit.models.Categories

class ProductRepository(private val apiService: apiService) {


    private val _categoryProductLiveData = MutableLiveData<Categories>()
    val categoryProductLiveData : LiveData<Categories> get() = _categoryProductLiveData

    suspend fun getCategory(){
        val result = apiService.getCategories()
        result?.body().let {
            _categoryProductLiveData.postValue(it)
        }
    }
}