package com.example.capita.home.homeScreen.stocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capita.home.stock.Stock
import com.example.capita.service.home.stock.StockServiceImpl

@Composable
fun StockScreen() {
    val stockService = StockServiceImpl()
    val stocks by remember { mutableStateOf(stockService.stocks) }

    DisplayStocks(stocks)
}

@Composable
fun DisplayStocks(stocks: List<Stock>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 56.dp)
                .fillMaxHeight(),
        ) {
            items(stocks) { stock ->
                StockView(stock)
            }
        }
    }
}
