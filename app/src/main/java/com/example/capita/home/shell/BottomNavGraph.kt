package com.example.capita.home.shell

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.capita.home.bottomScreen.*
import com.example.capita.screen.bottomScreen.*


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.News.route) {
            NewsScreen()
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