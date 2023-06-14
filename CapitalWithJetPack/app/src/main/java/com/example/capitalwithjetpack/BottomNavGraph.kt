package com.example.capitalwithjetpack

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.capitalwithjetpack.bottomScreen.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.News.route) {
            NewsScreen()
        }
        composable(BottomBarScreen.Bookmark.route) {
            BookmarkScreen()
        }
        composable(BottomBarScreen.Protfolio.route) {
            ProtfolioScreen()
        }
        composable(BottomBarScreen.More.route) {
           MoreScreen()
        }
    }
}