package com.example.capita.home.SearchActivity // ktlint-disable package-name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.capita.home.homeScreen.stocks.CardView
import com.example.capita.home.shell.MyAppBar
import com.example.capita.home.ui.theme.CapitaTheme
import com.example.capita.service.index.IndexServiceImpl
import com.example.capita.service.instrument.InstrumentServiceImpl

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CapitaTheme {
                val service = InstrumentServiceImpl()
                val indexSearch = IndexServiceImpl()
//                val overviewSearch = OverviewServiceImpl()
                var searchText by remember { mutableStateOf("") }
                val instruments = remember { derivedStateOf { service.stockSearch(searchText) } }
                val index = remember { derivedStateOf { indexSearch.indexSearch(searchText) } }
//                val overview = remember { derivedStateOf { overviewSearch.overviewSearch(searchText) } }

                Column {
                    MyAppBar(
                        context = this@SearchActivity,
                        title = "Search",
                        onSearch = { newSearchText ->
                            searchText = newSearchText
                        },
                        showSearchBar = true,
                    )

                    LazyColumn {
                        items(items = instruments.value) { instrument ->
                            CardView(instrument)
                        }
                    }
                    LazyColumn {
                        items(items = index.value) { index ->
                            com.example.capita.home.homeScreen.index.IndexView(index)
                        }
                    }
//                    LazyColumn {
//                        items(items = overview.value){ overview ->
//                            com.example.capita.home.homeScreen.overview.CardView(overview)
//                        }
//                    }
                }
            }
        }
    }
}
