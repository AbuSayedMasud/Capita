package com.example.capita.home.shell

import com.example.capita.R

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Market : BottomBar(
        route = "Market",
        title = "Market",
        icon = R.drawable.market_share,
    )
    object Portfolio : BottomBar(
        route = "Portfolio",
        title = "Portfolio",
        icon = R.drawable.user,
    )
    object Trade : BottomBar(
        route = "Trade",
        title = "Trade",
        icon = R.drawable.trade,
    )
    object Service : BottomBar(
        route = "Service",
        title = "Service",
        icon = R.drawable.service,
    )
    object Menu : BottomBar(
        route = "Menu",
        title = "Menu",
        icon = R.drawable.menu,
    )
}
