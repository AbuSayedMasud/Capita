package com.example.capita.service.instrument

import com.example.capita.instrument.Instrument
import com.example.capita.instrument.InstrumentService

class InstrumentServiceImpl: InstrumentService {
    override fun listInstrument(): List<com.example.capita.instrument.Instrument> {
        val instr1 = Instrument(
            1,
            "AB Bank Limited",
            "ABBANK",
            "DSE",
            "Equity"
        )
        val instr2 = Instrument(
            1,
            "South East Bank Limited",
            "SEBL",
            "DSE",
            "Equity"
        )
        val list = ArrayList<com.example.capita.instrument.Instrument>();
        list.add(instr1)
        list.add(instr2)
        return list
    }
}