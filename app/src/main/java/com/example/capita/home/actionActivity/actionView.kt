package com.example.capita.home.actionActivity // ktlint-disable filename

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.home.filter.Filter

@Composable
fun ActionView(action: Filter, onClick: () -> Unit) {
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
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .clickable(onClick = onClick),
        elevation = 8.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // First Column - Icon and Full Name
            Image(
                painter = painterResource(id = action.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(imageSize),
            )

            Spacer(modifier = Modifier.width(8.dp)) // Space between Image and Texts

            // Second Column - Texts
            Column(modifier = Modifier.weight(textColumnWeight)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = action.shortName,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(),
                ) {
                    Text(
                        text = action.longName,
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
        }
    }
}

// @Preview
// @Composable
// fun CardViewPreview() {
//    val sampleIndex = Indices(
//        icon = R.drawable.logo1,
//        longName = "DSEX Index",
//        shortName = "DSEX",
//        amount = 6331.36305,
//        increase = 11.93465,
//        percentage = 0.18815,
//        changeIcon = R.drawable.minus
//    )
//
//    MaterialTheme {
//        IndexView(index = sampleIndex)
//    }
// }
