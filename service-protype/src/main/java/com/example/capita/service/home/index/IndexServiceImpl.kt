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
            amount = 6331.36305,
            increase = 1.93465,
            percentage = 0.18815,
            changeIcon = R.drawable.minus
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "DSES",
            longName = "DSES Index",
            amount = 1373.82707,
            increase = 2.46399,
            percentage = 0.17903,
            changeIcon = R.drawable.minus
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "DS30",
            longName = "DS30 Index",
            amount = 2191.51864,
            increase = 0.42042,
            percentage = -0.01918,
            changeIcon = R.drawable.minus
        ),
        Indices(
            icon = R.drawable.dse,
            shortName = "CDSET",
            longName = "CDSET Index",
            amount = 1212.5,
            increase = 0.42042,
            percentage = -0.01918,
            changeIcon = R.drawable.minus
        )
    )

    override fun indexSearch(searchText: String): List<Indices>{
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