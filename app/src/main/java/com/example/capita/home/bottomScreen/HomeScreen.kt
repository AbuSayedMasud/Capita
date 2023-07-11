package com.example.capita.home.bottomScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capita.home.homeScreen.index.IndexScreen
import com.example.capita.home.homeScreen.overview.OverviewScreen
import com.example.capita.home.homeScreen.sectionBar.homeSectionBar
import com.example.capita.home.homeScreen.stocks.StockScreen

@Composable
fun HomeScreen() {
    var homeSelectedSection by remember { mutableStateOf("Overview") }

    Column {
        homeSectionBar(
            selectedSection = homeSelectedSection,
            onSectionSelected = { section ->
                homeSelectedSection = section
            },
        )

        val navController = rememberNavController()

        NavHost(navController, startDestination = homeSelectedSection) {
            composable("Overview") {
                OverviewScreen()
            }
            composable("Indices") {
                IndexScreen()
            }
            composable("Stocks") {
                StockScreen()
            }
        }
    }
}
// @Composable
// @Preview(showBackground = true)
// fun HomeScreenPreview() {
//    HomeScreen()
// }
