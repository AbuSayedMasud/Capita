package com.example.capita.service.news

import com.example.capita.news.News
import com.example.capita.news.NewsService
import com.example.capita.overview.Overview
import com.example.service.protype.R

class NewsServiceImpl : NewsService{
    val news = listOf(
        News(
            icon = R.drawable.dse,
            firstName = "DSEX",
            middleName = "DSEX Index",
            lastName = "asd",
            mainNews = "afasd"
        ),
        News(
            icon = R.drawable.dse,
            firstName = "DSEX",
            middleName = "DSEX Index",
            lastName = "asd",
            mainNews = "afasd"
        ),
        News(
            icon = R.drawable.dse,
            firstName = "DSEX",
            middleName = "DSEX Index",
            lastName = "asd",
            mainNews = "afasd"
        )
    )

    override fun listNews(): List<News> {
        return news
    }
}