package com.example.capita.service.instrument

import com.example.capita.instrument.Instrument
import com.example.capita.instrument.InstrumentService
import com.example.service.protype.R
import java.util.Locale

class InstrumentServiceImpl : InstrumentService {
    val instruments = listOf(
        Instrument(
            icon = R.drawable.logo1,
            longName = "AB Bank Limited",
            shortName = "ABBANK",
            equity = "Equity",
            market = "DSE",
            value = 100.0,
            closedPrice = 90.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Bangladesh Commerce Bank Limited",
            shortName = "BCBL",
            equity = "Equity",
            market = "DSE",
            value = 150.0,
            closedPrice = 140.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Bank Asia Limited",
            shortName = "BANKASIA",
            equity = "Equity",
            market = "DSE",
            value = 200.0,
            closedPrice = 180.0,
            change = 20.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Bengal Commercial Bank Limited",
            shortName = "BCB",
            equity = "Equity",
            market = "DSE",
            value = 120.0,
            closedPrice = 130.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "BRAC Bank Limited",
            shortName = "BRACBANK",
            equity = "Equity",
            market = "DSE",
            value = 180.0,
            closedPrice = 200.0,
            change = -20.0,
            changeIcon = R.drawable.minus
        ),

        Instrument(
            icon = R.drawable.logo1,
            longName = "Standard Bank Limited",
            shortName = "STDBANK",
            equity = "Equity",
            market = "DSE",
            value = 220.0,
            closedPrice = 210.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24),

        Instrument(
            icon = R.drawable.logo1,
            longName = "Southeast Bank Limited",
            shortName = "SOUTHEASTB",
            equity = "Equity",
            market = "DSE",
            value = 250.0,
            closedPrice = 240.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "South Bangla Agriculture and Commerce Bank Limited",
            shortName = "SBACBL",
            equity = "Equity",
            market = "DSE",
            value = 260.0,
            closedPrice = 270.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Trust Bank Limited",
            shortName = "TRUSTBANK",
            equity = "Equity",
            market = "DSE",
            value = 280.0,
            closedPrice = 290.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "United Commercial Bank PLC",
            shortName = "UCB",
            equity = "Equity",
            market = "DSE",
            value = 300.0,
            closedPrice = 290.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Uttara Bank",
            shortName = "UTTARABANK",
            equity = "Equity",
            market = "DSE",
            value = 320.0,
            closedPrice = 310.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Agrani Bank Limited",
            shortName = "AGRANIBANK",
            equity = "Equity",
            market = "DSE",
            value = 340.0,
            closedPrice = 330.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Bangladesh Development Bank",
            shortName = "BDBANK",
            equity = "Equity",
            market = "DSE",
            value = 360.0,
            closedPrice = 350.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "BASIC Bank Limited",
            shortName = "BASICBANK",
            equity = "Equity",
            market = "DSE",
            value = 380.0,
            closedPrice = 390.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Janata Bank Limited",
            shortName = "JANATABANK",
            equity = "Equity",
            market = "DSE",
            value = 400.0,
            closedPrice = 390.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Rupali Bank Limited",
            shortName = "RUPALIBANK",
            equity = "Equity",
            market = "DSE",
            value = 420.0,
            closedPrice = 410.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Sonali Bank PLC",
            shortName = "SONALIBANK",
            equity = "Equity",
            market = "DSE",
            value = 440.0,
            closedPrice = 430.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Bangladesh Krishi Bank",
            shortName = "BKB",
            equity = "Equity",
            market = "DSE",
            value = 460.0,
            closedPrice = 470.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Rajshahi Krishi Unnayan Bank",
            shortName = "RAKUB",
            equity = "Equity",
            market = "DSE",
            value = 480.0,
            closedPrice = 470.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Probashi Kallyan",
            shortName = "PROBASHI",
            equity = "Equity",
            market = "DSE",
            value = 500.0,
            closedPrice = 510.0,
            change = -10.0,
            changeIcon = R.drawable.logo1
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Al-Arafah Islami Bank Limited",
            shortName = "ALARAFAH",
            equity = "Equity",
            market = "DSE",
            value = 520.0,
            closedPrice = 530.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "EXIM Bank Limited",
            shortName = "EXIMBANK",
            equity = "Equity",
            market = "DSE",
            value = 540.0,
            closedPrice = 530.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "First Security Islami Bank Limited",
            shortName = "FSIBL",
            equity = "Equity",
            market = "DSE",
            value = 560.0,
            closedPrice = 570.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Global Islami Bank PLC",
            shortName = "GIBL",
            equity = "Equity",
            market = "DSE",
            value = 580.0,
            closedPrice = 570.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "ICB Islamic Bank Limited",
            shortName = "ICBIBANK",
            equity = "Equity",
            market = "DSE",
            value = 600.0,
            closedPrice = 610.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Islami Bank Bangladesh Limited",
            shortName = "ISLAMIBANK",
            equity = "Equity",
            market = "DSE",
            value = 620.0,
            closedPrice = 610.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Shahjalal Islami Bank Limited",
            shortName = "SJIBL",
            equity = "Equity",
            market = "DSE",
            value = 640.0,
            closedPrice = 650.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Social Islami Bank Limited",
            shortName = "SIBL",
            equity = "Equity",
            market = "DSE",
            value = 660.0,
            closedPrice = 650.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Union Bank Limited",
            shortName = "UBL",
            equity = "Equity",
            market = "DSE",
            value = 680.0,
            closedPrice = 690.0,
            change = -10.0,
            changeIcon = R.drawable.minus
        ),
        Instrument(
            icon = R.drawable.logo1,
            longName = "Standard Bank Limited",
            shortName = "STANDBANKL",
            equity = "Equity",
            market = "DSE",
            value = 700.0,
            closedPrice = 690.0,
            change = 10.0,
            changeIcon = R.drawable.baseline_add_24
        )
    )

    override fun listInstrument(searchText: String): List<com.example.capita.instrument.Instrument> {
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
}
//        val instr1 = com.example.capita.instrument.Instrument(
//            1,
//            "AB Bank Limited",
//            "ABBANK",
//            "DSE",
//            "Equity"
//        )
//        val instr2 = com.example.capita.instrument.Instrument(
//            1,
//            "South East Bank Limited",
//            "SEBL",
//            "DSE",
//            "Equity"
//        )
//        val list = ArrayList<com.example.capita.instrument.Instrument>();
//        list.add(instr1)
//        list.add(instr2)
//        return if (searchText.isEmpty()) list else list.filter {
//            it.name.contains(
//                searchText,
//                ignoreCase = true
//            )
//        }