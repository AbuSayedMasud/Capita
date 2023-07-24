package com.example.capita.home.shell

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.capita.home.bottomScreen.* // ktlint-disable no-wildcard-imports
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.example.capita.news.NewsService

@Composable
fun BottomNavGraph(navController: NavHostController, newsService: NewsService) {
    val colorSelectionViewModel = viewModel<ColorSelectionViewModel>()
    NavHost(navController = navController, startDestination = BottomBar.Market.route) {
        composable(BottomBar.Market.route) {
            HomeScreen(colorSelectionViewModel = colorSelectionViewModel)
        }
        composable(BottomBar.Portfolio.route) {
            PortfolioScreen(colorSelectionViewModel)
        }
        composable(BottomBar.Trade.route) {
            BookmarkScreen()
        }
        composable(BottomBar.Service.route) {
            ServiceScreen()
        }
        composable(BottomBar.Menu.route) {
            MenuScreen(colorSelectionViewModel)
        }
    }
}
