package com.example.capita.home.bottomScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.capita.home.sectionBar.CardView
import com.example.capita.service.index.IndexServiceImpl
import com.example.capita.index.Indices
import com.example.capita.instrument.Instrument
import com.example.capita.instrument.InstrumentService

@Composable
fun HomeScreen() {
    val indexService = IndexServiceImpl()
    val indices by remember { mutableStateOf(indexService.listIndex()) }

    DisplayIndices(indices)
}

@Composable
fun DisplayIndices(indices: List<Indices>) {
    LazyColumn {
        items(indices) { index ->
            CardView(index)
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun HomeScreenPreview() {
//    HomeScreen()
//}