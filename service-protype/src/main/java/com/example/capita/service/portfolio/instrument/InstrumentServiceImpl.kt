package com.example.capita.service.portfolio.instrument

import com.example.capita.portfolio.instrument.Instrument
import com.example.capita.portfolio.instrument.BalanceService
import com.example.service.protype.R
import java.util.Locale

class InstrumentServiceImpl : BalanceService {
    val instruments = listOf(
        Instrument(
            icon = R.drawable.aci,
            longName = "ACI Limited",
            shortName = "ACI",
            value = 100.0,
            closedPrice = 90.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24,
            description = listOf(
                "Total Quantity" to "500.00",
                "Salable Quantity" to "450.00",
                "Average Cost" to "800.00",
                "Total Cost" to "2379.30",
                "Close Price" to "593.90",
                "Unrealized Gain/Loss" to "7889.00",
                "%Gain(Loss)" to "35.45",
                "%Cost value" to ".60",
            ),
        ),
    )

    override fun instrumentSearch(searchText: String): List<Instrument> {
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return instruments.filter { instrument ->
            (
                instrument.longName.contains(lowerCaseSearchText) ||
                    instrument.shortName.lowercase(Locale.getDefault())
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

    override fun listInstrument(): List<Instrument> {
        return instruments
    }
}
