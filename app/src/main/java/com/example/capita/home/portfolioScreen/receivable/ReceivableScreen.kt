package com.example.capita.home.portfolioScreen.receivable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.capita.portfolio.receivable.Receivable
import com.example.capita.service.portfolio.receivable.ReceivableServiceImpl

@Composable
fun ReceivableScreen() {
    val receivableService = ReceivableServiceImpl()
    val receivables by remember { mutableStateOf(receivableService.listReceivable()) }

    DisplayReceivables(receivables)
}

@Composable
fun DisplayReceivables(receivable: List<Receivable>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(receivable) { thisReceivable ->
                ReceivableView(thisReceivable)
            }
        }
    }
}
