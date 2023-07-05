package com.example.capita.instrument

import com.example.capita.index.Indices

interface InstrumentService {
    fun stockSearch(searchText: String): List<Instrument>
    fun listInstrument(): List<Instrument>
}