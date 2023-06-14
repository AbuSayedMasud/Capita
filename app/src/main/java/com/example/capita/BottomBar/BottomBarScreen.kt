package com.example.capita.BottomBar

import com.example.capita.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.market_share

    )
    object News : BottomBarScreen(
        route = "news",
        title = "News",
        icon = R.drawable.newspaper
    )
    object WatchList : BottomBarScreen(
        route = "WatchList",
        title = "WatchList",
        icon = R.drawable.star
    )
    object Portfolio : BottomBarScreen(
        route = "Portfolio",
        title = "Portfolio",
        icon = R.drawable.user
    )
    object More : BottomBarScreen(
        route = "Menu",
        title = "Menu",
        icon = R.drawable.menu
    )
}

