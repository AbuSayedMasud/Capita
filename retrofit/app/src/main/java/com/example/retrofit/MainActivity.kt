package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.api.ApiService
import com.example.retrofit.api.RetrofitHelper
import com.example.retrofit.model.Categories
import com.example.retrofit.repository.ProductRepository
import com.example.retrofit.viewmodel.ProductViewModel
import com.example.retrofit.viewmodel.ProductViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var productViewModel: ProductViewModel
    lateinit var categoryList: Categories
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repository = ProductRepository(apiService)
        productViewModel = ViewModelProvider(
            this,
            ProductViewModelFactory(repository)
        ).get(ProductViewModel::class.java)
        productViewModel.category.observe(this) {

            it?.let {

                categoryList = it
                Log.d("masud",categoryList.toString())

            }
        }
    }
}