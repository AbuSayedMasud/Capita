package com.example.capita.home.actionActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.capita.home.ui.theme.CapitaTheme
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
import com.example.capita.service.action.ActionServiceImpl
import com.example.capita.service.instrument.InstrumentServiceImpl
import com.example.capita.service.index.IndexServiceImpl
import com.example.capita.service.overview.OverviewServiceImpl


class actionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CapitaTheme {
                val actionSearch = ActionServiceImpl()
                var searchText by remember { mutableStateOf("") }
                val allActions = remember { mutableStateOf(actionSearch.listAction()) }
                val actions = remember(allActions.value, searchText){
                    if (searchText.isEmpty()) allActions.value
                    else actionSearch.actionSearch(searchText)
                }

                Column {
                    MyAppBar(
                        context = this@actionActivity,
                        title = "Search",
                        onSearch = { newSearchText ->
                            searchText = newSearchText
                        },
                        showSearchBar = true
                    )

                    LazyColumn {
                        items(items = actions) { action ->
                            ActionView(action)
                        }
                    }
                }
            }
        }
    }
}