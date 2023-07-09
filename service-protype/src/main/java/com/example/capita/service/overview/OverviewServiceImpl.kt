package com.example.capita.service.overview

import com.example.capita.overview.Overview
import com.example.capita.overview.OverviewService
import com.example.service.protype.R

class OverviewServiceImpl : OverviewService {

     val overviewDSE = listOf(
        Overview(
            icon = R.drawable.logo1,
            shortName = "DSEX",
            longName = "DSEX Index",
            amount = 6331.36305,
            increase = 1.93465,
            percentage = 0.18815,
            changeIcon = R.drawable.minus
        ),
        Overview(
            icon = R.drawable.logo1,
            shortName = "DSES",
            longName = "DSES Index",
            amount = 1373.82707,
            increase = 2.46399,
            percentage = 0.17903,
            changeIcon = R.drawable.minus
        ),
        Overview(
            icon = R.drawable.logo1,
            shortName = "DS30",
            longName = "DS30 Index",
            amount = 2191.51864,
            increase = 0.42042,
            percentage = -0.01918,
            changeIcon = R.drawable.minus
        )
    )

    val overviewCSE = listOf(
        Overview(
            icon = R.drawable.logo1,
            shortName = "CSE50",
            longName = "CSE50 Index",
            amount = 6331.36305,
            increase = 1.93465,
            percentage = 0.18815,
            changeIcon = R.drawable.minus
        ),
        Overview(
            icon = R.drawable.logo1,
            shortName = "CSE30",
            longName = "CSE30 Index",
            amount = 1373.82707,
            increase = 2.46399,
            percentage = 0.17903,
            changeIcon = R.drawable.minus
        ),
        Overview(
            icon = R.drawable.logo1,
            shortName = "CSCX",
            longName = "CSCX Index",
            amount = 2191.51864,
            increase = 0.42042,
            percentage = -0.01918,
            changeIcon = R.drawable.minus
        )
    )

    override fun listOverview(): List<Overview> {
        return overviewDSE
    }
}