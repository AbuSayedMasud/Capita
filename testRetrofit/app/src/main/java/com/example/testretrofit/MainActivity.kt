package com.example.testretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.testretrofit.api.RetrofitHelper
import com.example.testretrofit.api.apiService
import com.example.testretrofit.repository.ProductRepository
import com.example.testretrofit.viewmodel.ProductViewModel
import com.example.testretrofit.viewmodel.ProductViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var productViewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiService = RetrofitHelper.getInstance().create(apiService::class.java)
        val repository = ProductRepository(apiService)
        productViewModel = ViewModelProvider(
            this,
            ProductViewModelFactory(repository)
        ).get(ProductViewModel::class.java)
        productViewModel.category.observe(this) {

            it?.let {


                Log.d("masud",it.toString())

            }
        }
    }
}