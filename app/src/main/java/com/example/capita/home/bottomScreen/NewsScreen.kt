package com.example.capita.home.bottomScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.capita.home.newsScreen.NewsView
import com.example.capita.news.NewsService

@Composable
fun NewsScreen(newsService: NewsService) {
    val newsList = newsService.listNews()

    LazyColumn {
        itemsIndexed(newsList) { index, news ->
            NewsView(
                icon = painterResource(id = news.icon),
                firstName = news.firstName,
                middleName = news.middleName,
                lastName = news.lastName,
                description = news.mainNews,
            )
        }
    }
}
// @Composable
// @Preview(showBackground = true)
// fun NewsScreenPreview(){
//    NewsScreen()
// }
