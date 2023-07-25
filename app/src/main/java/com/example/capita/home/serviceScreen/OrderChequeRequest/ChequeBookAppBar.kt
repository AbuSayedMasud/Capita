package com.example.capita.home.serviceScreen.OrderChequeRequest

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel

@Composable
fun ChequeBookAppBar(
    title: String,
    colorSelectionViewModel: ColorSelectionViewModel,
) {
    // The new AppBar content without search and profile icons
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp)
                    .offset(x = (-10).dp),
            )
        },
        backgroundColor = colorSelectionViewModel.appBarColor,
        navigationIcon = null, // Remove the navigation icon
        actions = {}
    )
}