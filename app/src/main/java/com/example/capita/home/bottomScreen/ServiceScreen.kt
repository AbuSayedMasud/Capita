package com.example.capita.home.bottomScreen

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.example.capita.home.serviceScreen.DisplayServices
import com.example.capita.service.service.ServiceImpl

// @Composable
// fun NewsScreen(newsService: NewsService) {
//    val newsList = newsService.listNews()
//
//    LazyColumn {
//        itemsIndexed(newsList) { index, news ->
//            NewsView(
//                icon = painterResource(id = news.icon),
//                firstName = news.firstName,
//                middleName = news.middleName,
//                lastName = news.lastName,
//                description = news.mainNews,
//            )
//        }
//    }
// }

@SuppressLint("SuspiciousIndentation")
@Composable
fun ServiceScreen() {
    val service = ServiceImpl()
    val services by remember { mutableStateOf(service.listService()) }
    val navController = rememberNavController()

    DisplayServices(services, navController)
}
