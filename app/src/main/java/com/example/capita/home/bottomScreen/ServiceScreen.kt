package com.example.capita.home.bottomScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.capita.home.homeScreen.news.NewsView
import com.example.capita.home.serviceScreen.DisplayServices
import com.example.capita.home.serviceScreen.ServiceView
import com.example.capita.news.NewsService
import com.example.capita.service.CapitaService
import com.example.capita.service.Service
import com.example.capita.service.service.ServiceImpl

//@Composable
//fun NewsScreen(newsService: NewsService) {
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

@Composable
fun ServiceScreen() {
    val service = ServiceImpl()
    val services by remember { mutableStateOf(service.listService()) }

    DisplayServices(services)
}


