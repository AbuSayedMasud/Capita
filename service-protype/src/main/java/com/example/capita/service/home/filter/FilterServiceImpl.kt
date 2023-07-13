package com.example.capita.service.home.filter

import com.example.capita.home.filter.Filter
import com.example.capita.home.filter.FilterService
import com.example.service.protype.R
import java.util.Locale

class FilterServiceImpl : FilterService {

    val filter = listOf(
        Filter(
            icon = R.drawable.cse,
            shortName = "DSE",
            longName = "Dhaka Stock Exchange Ltd.",
        ),
        Filter(
            icon = R.drawable.cse,
            shortName = "CSE",
            longName = "Chittagong Stock Exchange Ltd.",
        ),
    )

    override fun filterSearch(searchText: String): List<Filter> {
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return filter.filter { action ->
            (
                action.longName.contains(lowerCaseSearchText) ||
                    action.shortName.lowercase(Locale.getDefault())
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
    override fun listFilter(): List<Filter> {
        return filter
    }
}
