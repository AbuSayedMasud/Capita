package com.example.capita.portfolio.instrument

interface BalanceService {
    fun instrumentSearch(searchText: String): List<Instrument>
    fun listInstrument(): List<Instrument>
}
