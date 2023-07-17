package com.example.capita.service.home.index

import com.example.capita.home.index.IndexService
import com.example.capita.home.index.Indices
import com.example.service.protype.R
import java.util.Locale

class IndexServiceImpl : IndexService {
    val index = listOf(
        Indices(
            icon = R.drawable.dse,
            shortName = "DSEX",
            longName = "DSEX Index",
            market = "DSE",
            amount = 6331.3635,
            increase = 1.934,
            percentage = 0.18,
            changeIcon = R.drawable.minus,
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "DSES",
            longName = "DSES Index",
            market = "DSE",
            amount = 1373.8432,
            increase = 2.426,
            percentage = 0.17,
            changeIcon = R.drawable.minus,
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "DS30",
            longName = "DS30 Index",
            market = "DSE",
            amount = 2191.5121,
            increase = 0.429,
            percentage = -0.01,
            changeIcon = R.drawable.minus,
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "CDSET",
            longName = "CDSET Index",
            market = "DSE",
            amount = 1212.4325,
            increase = 0.442,
            percentage = -0.01,
            changeIcon = R.drawable.minus,
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "CSE50",
            longName = "CSE50 Index",
            market = "CSE",
            amount = 1316.1383,
            increase = 0.184,
            percentage = -0.01,
            changeIcon = R.drawable.minus,
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "CSE30",
            longName = "CSE30 Index",
            market = "CSE",
            amount = 13354.8194,
            increase = 6.675,
            percentage = 0.04,
            changeIcon = R.drawable.minus,
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "CSCX",
            longName = "CSCX Index",
            market = "CSE",
            amount = 11177.3362,
            increase = 2.552,
            percentage = -0.02,
            changeIcon = R.drawable.minus,
        ),
    )

    override fun indexSearch(searchText: String): List<Indices> {
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return index.filter { index ->
            (
                index.longName.contains(lowerCaseSearchText) ||
                    index.shortName.lowercase(Locale.getDefault())
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
    override fun listIndex(): List<Indices> {
        return index
    }
}
