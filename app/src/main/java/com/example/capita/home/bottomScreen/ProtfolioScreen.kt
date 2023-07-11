package com.example.capita.home.bottomScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capita.home.portfolioScreen.instrument.InstrumentView
import com.example.capita.home.portfolioScreen.sectionBar.portfolioSectionBar
import com.example.capita.service.portfolio.instrument.InstrumentServiceImpl

@Composable
fun ProtfolioScreen() {
    var portfolioSelectedSection by remember { mutableStateOf("Instrument") }
    val instrumentService = InstrumentServiceImpl()
    val instrumentList = instrumentService.listInstrument()

    Column {
        portfolioSectionBar(
            selectedSection = portfolioSelectedSection,
            onSectionSelected = { section ->
                portfolioSelectedSection = section
            },
        )

        val navController = rememberNavController()

        NavHost(navController, startDestination = portfolioSelectedSection) {
            composable("Instrument") {
                LazyColumn {
                    itemsIndexed(instrumentList) { index, instrument ->
                        InstrumentView(
                            icon = painterResource(id = instrument.icon),
                            longName = instrument.longName,
                            shortName = instrument.shortName,
                            value = instrument.value,
                            closedPrice = instrument.closedPrice,
                            change = instrument.change,
                            changeIcon = instrument.changeIcon,
                            description = instrument.description,
                        )
                    }
                }
                composable("Balance") {
                }
                composable("Receivable") {
                }
            }
        }
    }
}

// @Composable
// @Preview(showBackground = true)
// fun ProtfolioScreenPreview() {
//    ProtfolioScreen()
// }
