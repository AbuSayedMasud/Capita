package com.example.retrofit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.api.ApiService
import com.example.retrofit.model.Categories
import com.example.retrofit.model.ProductInfo

class ProductRepository(private val apiService: ApiService) {
    private val _productLiveData = MutableLiveData<ProductInfo>()
    val productLiveData : LiveData<ProductInfo> get() = _productLiveData

    private val _categoryProductLiveData = MutableLiveData<Categories>()
    val categoryProductLiveData : LiveData<Categories> get() = _categoryProductLiveData
    suspend fun getProductsInfo(){
        val result = apiService.getProductInfo()
        if(result?.body() != null){
            _productLiveData.postValue(result.body())
        }
    }

    suspend fun getCategory(){
        val result = apiService.getCategories()
        result?.body().let {
            Log.d("masud01",it.toString())
            _categoryProductLiveData.postValue(it)
        }
    }
}