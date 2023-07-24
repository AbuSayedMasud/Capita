package com.example.capita.home.portfolioScreen.instrument

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capita.service.portfolio.instrument.InstrumentServiceImpl

@Composable
fun InstrumentScreen() {
    val instrumentService = InstrumentServiceImpl()
    val instrumentList = instrumentService.listInstrument()

    var expandedIndex by remember { mutableStateOf(-1) }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 56.dp)
                .fillMaxHeight(),
        ) {
            itemsIndexed(instrumentList) { index, thisInstrument ->
                InstrumentView(
                    instrument = thisInstrument,
                    expandedIndexInstrument = expandedIndex,
                    onCardClicked = { clickedIndex ->
                        expandedIndex = if (expandedIndex == clickedIndex) -1 else clickedIndex
                    },
                )
            }
        }
    }
}
