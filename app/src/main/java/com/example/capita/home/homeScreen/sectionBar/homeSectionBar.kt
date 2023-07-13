package com.example.capita.home.homeScreen.sectionBar // ktlint-disable filename

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*

@SuppressLint("RememberReturnType")
@Composable
fun HomeSectionBar(
    sections: List<String>,
    homeSelectedSection: Int,
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
            selectedTabIndex = homeSelectedSection,
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
                    selected = homeSelectedSection == index,
                    onClick = { onSectionSelected(index) },
                )
            }
        }
    }
}
