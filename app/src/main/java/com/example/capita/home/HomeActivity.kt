package com.example.capita.home

import SetStatusBarColor
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.example.capita.home.shell.MainScreenBottomBar
import com.example.capita.home.shell.MyAppBar
import com.example.capita.home.ui.theme.CapitaTheme

class HomeActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorSelectionViewModel = viewModel<ColorSelectionViewModel>()

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
                            showSearchBar = false,
                            colorSelectionViewModel = colorSelectionViewModel,
                        )
                    }

                    MainScreenBottomBar(colorSelectionViewModel)

//
                }
            }
        }
    }
}
