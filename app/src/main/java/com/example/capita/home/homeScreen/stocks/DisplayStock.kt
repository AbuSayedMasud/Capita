package com.example.capita.home.homeScreen.stocks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.capita.service.home.stock.StockServiceImpl
import com.example.capita.home.stock.Stock

@Composable
fun StockScreen() {
    val stockService = StockServiceImpl()
    val stocks by remember { mutableStateOf(stockService.stocks) }

    DisplayStocks(stocks)
}

@Composable
fun DisplayStocks(stocks: List<Stock>) {
    LazyColumn {
        items(stocks) { stock ->
            StockView(stock)
        }
    }
}
