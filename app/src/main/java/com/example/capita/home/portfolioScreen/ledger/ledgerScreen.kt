package com.example.capita.home.portfolioScreen.ledger

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
import com.example.capita.portfolio.ledger.Ledger
import com.example.capita.service.portfolio.ledger.LedgerServiceImpl
import ledgerView

@Composable
fun LedgerScreen() {
    val ledgerService = LedgerServiceImpl()
    val ledgers by remember { mutableStateOf(ledgerService.ledger) }

    Displayledgers(ledgers)
}
@Composable
fun Displayledgers(ledger: List<Ledger>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 56.dp)
                .fillMaxHeight(),
        ) {
            items(ledger) { item ->
                ledgerView(item)
            }
        }
    }
}

