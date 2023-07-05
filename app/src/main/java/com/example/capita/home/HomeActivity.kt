package com.example.capita.home

import SetStatusBarColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.capita.home.shell.MainScreenBottomBar
import com.example.capita.home.shell.MyAppBar
import com.example.capita.home.ui.theme.CapitaTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SetStatusBarColor(Color(0xFF0E2B26), Color(0xFF0E2B26))
            CapitaTheme {
                Column {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        MyAppBar(
                            context = this@HomeActivity,
                            title = "Capita",
                            onSearch = { searchText ->
                                // What happens when the search button is clicked
                            },
                            showSearchBar = false
                        )
                    }

                    MainScreenBottomBar()

//
                    }
                }
            }
        }
    }

