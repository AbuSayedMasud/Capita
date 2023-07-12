package com.example.capita.service.portfolio.balance

import com.example.capita.portfolio.balance.Balance
import com.example.capita.portfolio.balance.BalanceService
import java.util.Locale

class BalanceServiceImpl : BalanceService {
    val balance = listOf(
        Balance(
            Name = "Current Asset",
            value = 3395885.00,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
    )

    override fun balanceSearch(searchText: String): List<Balance> {
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return balance.filter { balance ->
            (
                balance.Name.contains(lowerCaseSearchText)
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

    override fun listBalance(): List<Balance> {
        return balance
    }
}
