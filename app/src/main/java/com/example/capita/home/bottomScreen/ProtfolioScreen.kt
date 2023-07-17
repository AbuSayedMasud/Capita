package com.example.capita.home.bottomScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capita.home.portfolioScreen.balance.BalanceScreen
import com.example.capita.home.portfolioScreen.balance.BalanceView
import com.example.capita.home.portfolioScreen.instrument.InstrumentScreen
import com.example.capita.home.portfolioScreen.sectionBar.portfolioSectionBar
import com.example.capita.service.portfolio.balance.BalanceServiceImpl
import com.example.capita.service.portfolio.instrument.InstrumentServiceImpl

@Composable
fun ProtfolioScreen() {
    var portfolioSelectedSection by remember { mutableStateOf("Instrument") }

    Column {
        portfolioSectionBar(
            portfolioSelectedSection = portfolioSelectedSection,
            onSectionSelected = { section ->
                portfolioSelectedSection = section
            },
        )

        val navController = rememberNavController()

        NavHost(navController, startDestination = portfolioSelectedSection) {
            composable("Instrument") {
                InstrumentScreen()
            }
            composable("Balance") {
                BalanceScreen()
            }
            composable("Receivable") {
            }
        }
    }
}

// @Composable
// @Preview(showBackground = true)
// fun ProtfolioScreenPreview() {
//    ProtfolioScreen()
// }
