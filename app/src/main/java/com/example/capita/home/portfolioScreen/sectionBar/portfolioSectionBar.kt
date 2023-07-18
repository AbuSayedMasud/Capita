package com.example.capita.home.portfolioScreen.sectionBar // ktlint-disable filename

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@Composable
fun portfolioSectionBar(
    sections: List<String>,
    portfolioSelectedSection: Int,
    onSectionSelected: (Int) -> Unit,
) {
    val lighterAppBarColor = Color(0xFFD1DED0)

    Surface(
        color = lighterAppBarColor,
        modifier = Modifier.fillMaxWidth(),
    ) {
        TabRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(lighterAppBarColor),
            selectedTabIndex = portfolioSelectedSection,
            backgroundColor = lighterAppBarColor,
        ) {
            sections.forEachIndexed { index, section ->
                Tab(
                    text = {
                        Text(
                            text = section,
                            fontFamily = FontFamily.Default,
                        )
                    },
                    selected = portfolioSelectedSection == index,
                    onClick = { onSectionSelected(index) },
                )
            }
        }
    }
}

// @Preview
// @Composable
// fun PreviewScrollingSectionBar() {
//    scrollingSectionBar()
// }
