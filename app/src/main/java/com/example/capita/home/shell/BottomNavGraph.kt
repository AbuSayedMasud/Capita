package com.example.capita.home.shell

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.capita.home.bottomScreen.* // ktlint-disable no-wildcard-imports
import com.example.capita.news.NewsService

@Composable
fun BottomNavGraph(navController: NavHostController, newsService: NewsService) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.Service.route) {
            NewsScreen(newsService = newsService)
        }
        composable(BottomBarScreen.Trade.route) {
            BookmarkScreen()
        }
        composable(BottomBarScreen.Portfolio.route) {
            PortfolioScreen()
        }
        composable(BottomBarScreen.More.route) {
            MoreScreen()
        }
    }
}
