package com.example.capita.home.shell


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.capita.service.news.NewsServiceImpl

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MainScreenBottomBar() {
    val navController= rememberNavController()
    val newsService = NewsServiceImpl()
//
    Scaffold(bottomBar = { bottomBar(navController = navController) }) {
        BottomNavGraph(navController = navController, newsService = newsService)
    }
}

@Composable
fun bottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.News,
        BottomBarScreen.WatchList,
        BottomBarScreen.Portfolio,
        BottomBarScreen.More,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation (backgroundColor = Color(0xFF006A4E),contentColor = Color.White ){
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                curentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    curentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title,
                style = TextStyle(fontSize = 10.sp)) // Reduce font size)
        },
        icon = {
            val icon = painterResource(id = screen.icon)
            Icon(painter = icon, contentDescription = "Navigation Icon",modifier = Modifier.size(24.dp))
        },
        selected = curentDestination?.hierarchy?.any() {
            it.route == screen.route
        } == true,
        modifier = if (curentDestination?.hierarchy?.any { it.route == screen.route } == true) {
            Modifier
        } else {
            Modifier.clickable { navController.navigate(screen.route) }
        },
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop=true
            }
        },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)


    )
}
//@Preview(showBackground = true)
//@Composable
//fun PreviewMainScreenBottomBar() {
//    MainScreenBottomBar()
//}