package com.example.capita.service.portfolio.balance

import com.example.capita.portfolio.balance.Balance
import com.example.capita.portfolio.balance.BalanceService
import java.util.Locale

class BalanceServiceImpl : BalanceService {
    private val balanceData = listOf(
        Balance(
            index = 0,
            Name = "Current Asset",
            value = 3395885.00,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
        Balance(
            index = 1,
            Name = "Accrued Charge",
            value = 0.0,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
        Balance(
            index = 2,
            Name = "Deposit",
            value = 3442319.00,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
        Balance(
            index = 3,
            Name = "Withdrawal",
            value = 0.0,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
        Balance(
            index = 4,
            Name = "Value Of Securities",
            value = 254264.00,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
        Balance(
            index = 5,
            Name = "Equity",
            value = 45922.00,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
        Balance(
            index = 6,
            Name = "Ratio",
            value = 0.0,
            Balance = 2947385.00,
            ReceivablesSales = 0.0,
            UnclearCheque = 449500.00,
        ),
        Balance(
            index = 7,
            Name = "Purchase Power",
            value = 2947385.00,
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

        return balanceData.filter { balance ->
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
        return balanceData
    }
}
