package com.example.capita.home.actionActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.capita.home.HomeActivity
import com.example.capita.home.shell.MyAppBar
import com.example.capita.home.ui.theme.CapitaTheme
import com.example.capita.service.home.filter.FilterServiceImpl

class actionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CapitaTheme {
                val actionSearch = FilterServiceImpl()
                var searchText by remember { mutableStateOf("") }
                val allActions = remember { mutableStateOf(actionSearch.listFilter()) }
                val actions = remember(allActions.value, searchText) {
                    if (searchText.isEmpty()) {
                        allActions.value
                    } else {
                        actionSearch.filterSearch(searchText)
                    }
                }

                Column {
                    MyAppBar(
                        context = this@actionActivity,
                        title = "Search",
                        onSearch = { newSearchText ->
                            searchText = newSearchText
                        },
                        showSearchBar = true,
                    )

                    LazyColumn {
                        items(items = actions) { action ->
                            ActionView(action = action) {
                                val intent = Intent(this@actionActivity, HomeActivity::class.java)
                                intent.putExtra("action_shortName", action.shortName)
                                startActivity(intent)
                            }
                        }
                    }
                }
            }
        }
    }
}
