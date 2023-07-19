package com.example.capita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.example.capita.home.shell.MainScreenBottomBar
import com.example.capita.ui.theme.CapitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorSelectionViewModel = viewModel<ColorSelectionViewModel>()

            CapitaTheme {
                MainScreenBottomBar(colorSelectionViewModel)
            }
        }
    }
}

