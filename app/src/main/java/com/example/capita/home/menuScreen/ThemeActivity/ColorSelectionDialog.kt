package com.example.capita.home.menuScreen.ThemeActivity // ktlint-disable package-name

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun ShowColorSelectionDialog(
    context: Context,
    viewModel: ColorSelectionViewModel,
    onDismiss: () -> Unit,
) {
    val colorList = listOf(
        Color(0xFF006A4E),
        Color(0xFFD32F2F),
        Color(0xFF1976D2),
        Color(0xFF9C27B0),
    )

    val selectedColor = remember { mutableStateOf(viewModel.selectedColor) }
    val lighterColor = remember { mutableStateOf(viewModel.lighterColor) }

    AlertDialog(
        onDismissRequest = { onDismiss },
        title = { Text(text = "Select Colors") },
        text = {
            Column {
                ColorPicker(
                    colors = colorList,
                    selectedColor = selectedColor.value,
                    onColorSelected = { color ->
                        selectedColor.value = color
                        viewModel.selectedColor = color
                        viewModel.lighterColor = color.copy(alpha = 0.1f) //
                    },
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                viewModel.appBarColor = selectedColor.value
                viewModel.bottomNavBarColor = selectedColor.value
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        },
    )
}

