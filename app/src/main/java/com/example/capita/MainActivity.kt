package com.example.capita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.example.capita.home.shell.MainScreenBottomBar
import com.example.capita.ui.theme.CapitaTheme

class MainActivity : ComponentActivity() {
    private val colorSelectionViewModel: ColorSelectionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapitaTheme {
                MainScreenBottomBar(colorSelectionViewModel = colorSelectionViewModel)
            }
        }
    }
}
