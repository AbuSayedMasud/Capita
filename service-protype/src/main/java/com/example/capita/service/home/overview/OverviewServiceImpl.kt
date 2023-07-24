package com.example.capita.service.home.overview

import com.example.capita.home.overview.Overview
import com.example.capita.home.overview.OverviewService
import com.example.service.protype.R

class OverviewServiceImpl : OverviewService {

    val overviewDSE = listOf(
        Overview(
            icon = R.drawable.dse,
            shortName = "DSEX",
            longName = "DSEX Index",
            amount = 6331.3635,
            increase = 1.932,
            percentage = 0.18,
            changeIcon = R.drawable.minus,
        ),
        Overview(
            icon = R.drawable.dse,
            shortName = "DSES",
            longName = "DSES Index",
            amount = 1373.8254,
            increase = 2.464,
            percentage = 0.17,
            changeIcon = R.drawable.minus,
        ),
        Overview(
            icon = R.drawable.dse,
            shortName = "DS30",
            longName = "DS30 Index",
            amount = 2191.5541,
            increase = 0.442,
            percentage = -0.01,
            changeIcon = R.drawable.minus,
        ),
    )

    val overviewCSE = listOf(
        Overview(
            icon = R.drawable.cse,
            shortName = "CSE50",
            longName = "CSE50 Index",
            amount = 6331.3652,
            increase = 1.932,
            percentage = 0.18,
            changeIcon = R.drawable.minus,
        ),
        Overview(
            icon = R.drawable.cse,
            shortName = "CSE30",
            longName = "CSE30 Index",
            amount = 1373.8221,
            increase = 2.463,
            percentage = 0.17,
            changeIcon = R.drawable.minus,
        ),
        Overview(
            icon = R.drawable.cse,
            shortName = "CSCX",
            longName = "CSCX Index",
            amount = 2191.5122,
            increase = 0.492,
            percentage = -0.01,
            changeIcon = R.drawable.minus,
        ),
    )

    override fun listOverview(): List<Overview> {
        return overviewDSE
    }
}
