package com.example.capita.service.portfolio.instrument

import com.example.capita.portfolio.instrument.Instrument
import com.example.capita.portfolio.instrument.InstrumentService
import com.example.service.protype.R
import java.util.Locale

class InstrumentServiceImpl : InstrumentService {
    val instruments = listOf(
        Instrument(
            index = 0,
            longName = "ACI Limited",
            shortName = "ACI",
            value = 100.0,
            closedPrice = 90.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24,
            TotalQuantity = 500.00,
            SalableQuantity = 450.00,
            AverageCost = 800.00,
            TotalCost = 2379.00,
            ClosePrice = 593.90,
            UnrealizedGain = 7889.00,
            GainPercent = 35.45,
            Costvalue = 0.60,
        ),
        Instrument(
            index = 1,
            longName = "ACME Limited",
            shortName = "ACME",
            value = 129.0,
            closedPrice = 70.0,
            change = 6.0,
            changeIcon = R.drawable.baseline_add_24,
            TotalQuantity = 500.00,
            SalableQuantity = 450.00,
            AverageCost = 800.00,
            TotalCost = 2379.00,
            ClosePrice = 593.90,
            UnrealizedGain = 7889.00,
            GainPercent = 35.45,
            Costvalue = 0.60,
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
