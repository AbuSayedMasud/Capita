package com.example.capita.home.homeScreen.sectionBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.text.Typography.section

@Composable
fun scrollingSectionBar(selectedSection: String, onSectionSelected: (String) -> Unit) {
    var selectedSection by remember { mutableStateOf("Overview") }

    val normalColor = Color.Gray
    val selectedColor = Color.Black

    val sections = listOf(
        "Overview",
        "Indices",
        "Stocks",
//        "Currency",
//        "Crypto",
//        "Future Indices"
    )

    val lighterAppBarColor = Color(0xFFD1DED0)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(lighterAppBarColor)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (section in sections) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable(
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        indication = null,
                        onClick = {
                            selectedSection = section
                            onSectionSelected(section)
                        }
                    )
            ) {
                Text(
                    text = section,
                    color = if (section == selectedSection) selectedColor else normalColor,
                    fontSize = if (section == selectedSection) 14.sp else 12.sp, // Enlarge the text size when selected
                    modifier = if (section == selectedSection) Modifier.scale(1.1f) else Modifier // Scale effect when selected
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewScrollingSectionBar() {
//    scrollingSectionBar()
//}