package com.example.capita.home.homeScreen.sectionBar // ktlint-disable filename

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.google.accompanist.pager.* // ktlint-disable no-wildcard-imports

@SuppressLint("RememberReturnType")
@Composable
fun HomeSectionBar(
    sections: List<String>,
    homeSelectedSection: Int,
    onSectionSelected: (Int) -> Unit,
    colorSelectionViewModel: ColorSelectionViewModel,
) {

    val lighterColor = colorSelectionViewModel.lighterColor// Create a lighter shade of the selected color

    Surface(
        color = lighterColor, // Use the lighter color for the section bar
        modifier = Modifier.fillMaxWidth(),
    ) {
        TabRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(lighterColor),
            selectedTabIndex = homeSelectedSection,
            backgroundColor = lighterColor,
        ) {
            sections.forEachIndexed { index, section ->
                Tab(
                    text = {
                        Text(
                            text = section,
                            fontFamily = FontFamily.Default,
                        )
                    },
                    selected = homeSelectedSection == index,
                    onClick = { onSectionSelected(index) },
                )
            }
        }
    }
}

