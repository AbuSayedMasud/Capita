package com.example.capita.service.news

import com.example.capita.news.News
import com.example.capita.news.NewsService
import com.example.service.protype.R

class NewsServiceImpl : NewsService {
    val news = listOf(
        News(
            icon = R.drawable.logo1,
            firstName = "AB BANK",
            middleName = "AB BANK LIMITED : 2% ",
            lastName = "Stock Dividend",
            mainNews = "Refer to their earlier news disseminated by DSE on 30.05.2023 regarding dividend declaration, the company has further informed that they have not received consent yet from BSEC against their declaration of 3% Stock dividend for the year ended December 31, 2022.",
        ),
//        News(
//            icon = R.drawable.dse,
//            firstName = "DSEX",
//            middleName = "DSEX Index",
//            lastName = "asd",
//            mainNews = "afasd",
//        ),
//        News(
//            icon = R.drawable.dse,
//            firstName = "DSEX",
//            middleName = "DSEX Index",
//            lastName = "asd",
//            mainNews = "afasd",
//        ),
    )

    override fun listNews(): List<News> {
        return news
    }
}
