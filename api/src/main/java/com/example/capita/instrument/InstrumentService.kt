package com.example.capita.instrument

interface InstrumentService {
    fun listInstrument(searchText: String): List<Instrument>
}