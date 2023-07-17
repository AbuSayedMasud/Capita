package com.example.capita.home.homeScreen.overview // ktlint-disable filename

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.home.overview.Overview

@Composable
fun OverView(overview: Overview) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

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
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // First Column - Icon and Full Name
//            Image(
//                painter = painterResource(id = overview.icon),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(imageSize),
//            )
//
            Spacer(modifier = Modifier.width(8.dp)) // Space between Image and Texts

            // Second Column - Texts
            Column(modifier = Modifier.weight(textColumnWeight)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = overview.shortName,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(),
                ) {
                    Text(
                        text = overview.longName,
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(valueColumnWeight)
                    .offset(x = -screenWidth * 0.01f), // move text to the left by 5% of screen width
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.End),
//                        .padding(start = screenWidth * 0.1f)
                ) {
                    Text(
                        text = overview.amount.toString(),
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.End,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.End),
//                        .padding(start = screenWidth * 0.08f)
                ) {
                    Image(
                        painter = painterResource(id = overview.changeIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(10.dp)
                            .padding(end = 4.dp),
                    )
                    Text(
                        text = overview.increase.toString(),
                        style = MaterialTheme.typography.body2,
//                        fontSize = textSize,
                    )

                    Spacer(modifier = Modifier.padding(1.dp))

                    Text("(", fontSize = textSize)
                    if (overview.percentage.toString() == "-") {
                        Image(
                            painter = painterResource(id = overview.changeIcon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(12.dp)
                                .padding(end = 4.dp),
                        )
                    }
                    Text(
                        text = overview.percentage.toString() + "%",
                        style = MaterialTheme.typography.body2,
//                        fontSize = textSize,
                    )
                    Text(")", fontSize = textSize)
                }
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .align(Alignment.End),
//                        .padding(start = screenWidth * 0.08f)
//                ) {
//
//                }
            }
        }
    }
}

// @Preview
// @Composable
// fun CardViewPreview() {
//    val sampleIndex = Overview(
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
//        CardView(overview = sampleIndex)
//    }
// }
