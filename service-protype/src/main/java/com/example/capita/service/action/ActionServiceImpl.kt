package com.example.capita.service.action

import com.example.capita.action.Action
import com.example.capita.action.ActionService
import com.example.capita.index.IndexService
import com.example.capita.index.Indices
import com.example.service.protype.R
import java.util.Locale

class ActionServiceImpl : ActionService {

    val action = listOf(
        Action(
            icon = R.drawable.dse,
            shortName = "DSE",
            longName = "Dhaka Stock Exchange Ltd."
        ),
        Action(
            icon = R.drawable.dse,
            shortName = "CSE",
            longName = "Chittagong Stock Exchange Ltd."
        )
    )

    override fun actionSearch(searchText: String): List<Action>{
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return action.filter { action ->
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
    override fun listAction(): List<Action> {
        return action
    }
}