package com.example.capita.home.news

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    icon: Painter,
    firstName: String,
    middleName: String,
    lastName: String,
    description: String,
) {
    var expanded by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // Define sizes based on screen size
    val imageSize = (screenWidth * 0.09f).coerceAtMost(52.dp)
    val textColumnWeight =
        if (screenWidth > 600.dp) 4f else 1f // Increase text space on large screens
    val valueColumnWeight =
        if (screenWidth > 600.dp) 2f else 1f // Increase value space on large screens
    val textSize = if (screenWidth > 600.dp) 14.sp else 12.sp

    Card(
        modifier = Modifier.padding(16.dp, 8.dp),
        elevation = 8.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
        onClick = { expanded = !expanded },
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            verticalAlignment = Alignment.Top,
        ) {
            Box(
                modifier = Modifier.size(imageSize),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = icon,
                    contentDescription = null,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(textColumnWeight)) {
                Text(
                    text = firstName,
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                )
                Text(text = middleName, style = MaterialTheme.typography.body2)
                Text(text = lastName, style = MaterialTheme.typography.body2)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    AnimatedVisibility(visible = expanded) {
                        Text(
                            text = description,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                        )
                    }
                }
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    modifier = Modifier.rotate(if (expanded) 180f else 0f),
                )
            }
        }
    }
}
