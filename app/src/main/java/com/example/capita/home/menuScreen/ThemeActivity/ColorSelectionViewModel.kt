package com.example.capita.home.menuScreen.ThemeActivity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ColorSelectionViewModel : ViewModel() {
    var appBarColor by mutableStateOf(Color(0xFF006A4E))
    var bottomNavBarColor by mutableStateOf(Color(0xFF006A4E))
    var selectedColor by mutableStateOf(Color(0xFF006A4E))
    var lighterColor by mutableStateOf(Color(0xFF006A4E))
}

