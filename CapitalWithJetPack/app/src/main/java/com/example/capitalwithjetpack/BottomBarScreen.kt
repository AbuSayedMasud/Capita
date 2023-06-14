package com.example.capitalwithjetpack

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object News : BottomBarScreen(
        route = "news",
        title = "News",
        icon = Icons.Default.List
    )
    object Bookmark : BottomBarScreen(
        route = "Bookmark",
        title = "Bookmark",
        icon = Icons.Default.Lock
    )
    object Protfolio : BottomBarScreen(
        route = "Protfolio",
        title = "Protfolio",
        icon = Icons.Default.Person
    )
    object More : BottomBarScreen(
        route = "Menu",
        title = "Menu",
        icon = Icons.Default.Menu
    )
}
