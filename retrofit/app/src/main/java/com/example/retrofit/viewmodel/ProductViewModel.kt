package com.example.retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.api.ApiService
import com.example.retrofit.model.Categories
import com.example.retrofit.model.ProductInfo
import com.example.retrofit.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ProductViewModel(val repository: ProductRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getProductsInfo()
        }

    }
    fun getCategory(){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.getCategory()
        }
    }

    val products : LiveData<ProductInfo> get() = repository.productLiveData
    val category:LiveData<Categories> get() = repository.categoryProductLiveData

}