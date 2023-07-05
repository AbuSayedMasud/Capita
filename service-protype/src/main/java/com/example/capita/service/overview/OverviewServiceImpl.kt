package com.example.capita.service.overview

import com.example.capita.overview.Overview
import com.example.capita.overview.OverviewService
import com.example.service.protype.R
import java.util.Locale

class OverviewServiceImpl : OverviewService {

     val overview = listOf(
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

    override fun overviewSearch(searchText: String): List<Overview>{
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return overview.filter { overview ->
            (
                    overview.longName.contains(lowerCaseSearchText) ||
                            overview.shortName.lowercase(Locale.getDefault())
                                .contains(lowerCaseSearchText)
//                            ||
//                            instrument.symbol.lowercase(Locale.getDefault())
//                                .contains(lowerCaseSearchText) ||
//                            instrument.market.lowercase(Locale.getDefault())
//                                .contains(lowerCaseSearchText) ||
//                            instrument.assetClass.lowercase(Locale.getDefault())
//                                .contains(lowerCaseSearchText)
                    )
        }
    }
    override fun listOverview(): List<Overview> {
        return overview
    }
}