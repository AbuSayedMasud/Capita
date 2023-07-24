package com.example.capita.portfolio.instrument

interface InstrumentService {
    fun instrumentSearch(searchText: String): List<Instrument>
    fun listInstrument(): List<Instrument>
}
