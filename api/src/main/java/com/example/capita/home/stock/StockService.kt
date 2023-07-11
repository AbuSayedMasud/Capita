package com.example.capita.home.stock

interface StockService {
    fun stockSearch(searchText: String): List<Stock>
    fun listStock(): List<Stock>
}
