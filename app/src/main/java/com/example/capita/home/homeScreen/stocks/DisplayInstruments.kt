package com.example.capita.home.homeScreen.stocks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.capita.instrument.Instrument
import com.example.capita.service.instrument.InstrumentServiceImpl

@Composable
fun InstrumentScreen() {
    val instrumentService = InstrumentServiceImpl()
    val instruments by remember { mutableStateOf(instrumentService.instruments) }

    DisplayInstruments(instruments)
}

@Composable
fun DisplayInstruments(instruments: List<Instrument>) {
    LazyColumn {
        items(instruments) { instrument ->
            CardView(instrument)
        }
    }
}