package com.example.capita.home.shell

import com.example.capita.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Home : BottomBarScreen(
        route = "Market",
        title = "Market",
        icon = R.drawable.market_share,

    )
    object Service : BottomBarScreen(
        route = "news",
        title = "Service",
        icon = R.drawable.service,
    )
    object Trade : BottomBarScreen(
        route = "Watchlist",
        title = "Trade",
        icon = R.drawable.trade,
    )
    object Portfolio : BottomBarScreen(
        route = "Portfolio",
        title = "Portfolio",
        icon = R.drawable.user,
    )
    object More : BottomBarScreen(
        route = "Menu",
        title = "Menu",
        icon = R.drawable.menu,
    )
}
