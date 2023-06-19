package com.example.capita.service.instrument

import com.example.capita.instrument.Instrument
import com.example.capita.instrument.InstrumentService
import java.util.Locale

class InstrumentServiceImpl : InstrumentService {
    val instruments = listOf(
        Instrument(1, "AB Bank Limited", "ABBANK", "DSE", "Equity"),
        Instrument(2, "South East Bank Limited", "SEBL", "DSE", "Equity"),
    )

    override fun listInstrument(searchText: String): List<com.example.capita.instrument.Instrument> {
        if (searchText.isBlank()) {
            return emptyList()
        }

        val lowerCaseSearchText = searchText.lowercase(Locale.getDefault())

        return instruments.filter { instrument ->
            (
                    instrument.id.toString().contains(lowerCaseSearchText) ||
                            instrument.name.lowercase(Locale.getDefault())
                                .contains(lowerCaseSearchText) ||
                            instrument.symbol.lowercase(Locale.getDefault())
                                .contains(lowerCaseSearchText) ||
                            instrument.market.lowercase(Locale.getDefault())
                                .contains(lowerCaseSearchText) ||
                            instrument.assetClass.lowercase(Locale.getDefault())
                                .contains(lowerCaseSearchText)
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