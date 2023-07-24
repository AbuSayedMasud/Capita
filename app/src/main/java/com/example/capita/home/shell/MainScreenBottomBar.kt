package com.example.capita.home.shell

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.example.capita.service.news.NewsServiceImpl

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MainScreenBottomBar(colorSelectionViewModel: ColorSelectionViewModel) {
    val navController = rememberNavController()
    val newsService = NewsServiceImpl()
//
    Scaffold(bottomBar = { bottomBar(navController = navController, bottomNavBarColor = colorSelectionViewModel.bottomNavBarColor) }) {
        BottomNavGraph(navController = navController, newsService = newsService)
    }
}

@Composable
fun bottomBar(navController: NavHostController, bottomNavBarColor: Color) {
    val screens = listOf(
        BottomBar.Market,
        BottomBar.Portfolio,
        BottomBar.Trade,
        BottomBar.Service,
        BottomBar.Menu,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
//    Color(0xFF006A4E)
    BottomNavigation(backgroundColor = bottomNavBarColor, contentColor = Color.White) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any() { it.route == screen.route } == true
    val unselectedIconTint =
        if (!selected) LocalContentColor.current.copy(alpha = 1f) else LocalContentColor.current
    val textColor = if (selected) Color.White else Color.LightGray.copy(alpha = 0.9f)
    val textStyle = TextStyle(fontSize = 10.sp, color = textColor, fontWeight = if (selected) FontWeight.ExtraBold else FontWeight.Bold)

    BottomNavigationItem(
        label = {
            Text(
                text = screen.title,
                style = textStyle,
                modifier = Modifier.alpha(1f),
            ) // Reduce font size)
        },
        icon = {
            val icon = painterResource(id = screen.icon)
            val modifier = if (selected) {
                Modifier
                    .size(26.dp)
//                    .background(color = Color(0xFF7eb09b))
            } else {
                Modifier
                    .size(24.dp)
                    .alpha(0.8f) // This will make the unselected icon a bit transparent
            }
            Icon(
                painter = icon,
                contentDescription = "Navigation Icon",
                modifier = modifier,
                tint = unselectedIconTint,
            )
        },
        selected = selected,
        modifier = if (selected) {
            Modifier
        } else {
            Modifier.clickable { navController.navigate(screen.route) }
        },
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
    )
}

// @Preview(showBackground = true)
// @Composable
// fun PreviewMainScreenBottomBar() {
//    MainScreenBottomBar()
// }
