package com.example.capita.home.topBarScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.capita.home.ui.theme.CapitaTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.capita.service.instrument.InstrumentServiceImpl
import com.example.capita.home.topBarScreen.CardView
import com.example.capita.instrument.Instrument


class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CapitaTheme {
                val service = InstrumentServiceImpl()
                var searchText by remember { mutableStateOf("") }
                val instruments = remember { derivedStateOf { service.listInstrument(searchText) } }

                Column {
                    MyAppBar(
                        context = this@SearchActivity,
                        title = "Search",
                        onSearch = { newSearchText ->
                            searchText = newSearchText
                        },
                        showSearchBar = true
                    )

                    LazyColumn {
                        items(items = instruments.value) { instrument ->
                            CardView(instrument)
                        }
                    }
                }
            }
        }
    }
}





