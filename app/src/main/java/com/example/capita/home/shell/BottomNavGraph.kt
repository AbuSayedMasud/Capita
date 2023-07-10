package com.example.capita.home.shell

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.capita.home.bottomScreen.*
import com.example.capita.news.NewsService


@Composable
fun BottomNavGraph(navController: NavHostController, newsService: NewsService) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.News.route) {
            NewsScreen(newsService = newsService)
        }
        composable(BottomBarScreen.WatchList.route) {
            BookmarkScreen()
        }
        composable(BottomBarScreen.Portfolio.route) {
            ProtfolioScreen()
        }
        composable(BottomBarScreen.More.route) {
            MoreScreen()
        }
    }
}