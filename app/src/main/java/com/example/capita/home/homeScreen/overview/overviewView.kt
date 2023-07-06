package com.example.capita.home.homeScreen.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.capita.overview.Overview

@Composable
fun OverView(overview: Overview) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Card(
        modifier = Modifier.padding(16.dp, 8.dp),
        elevation = 8.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            // First Column
            Column(modifier = Modifier.weight(4f)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    // First Row - Icon and Full Name
                    Image(
                        painter = painterResource(id = overview.icon),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = overview.shortName,
                        modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 41.dp)
                ) {
                    // Second Row - Short Name, Equity, Market
                    Text(
                        text = overview.longName,
//                        modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                }
            }
            // Second Column
            Column(modifier = Modifier.weight(2f)) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    // First Row - Value

                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(start = screenWidth * 0.08f)
                    ) {
                        Text(
                            text = overview.amount.toString(),
                            style = MaterialTheme.typography.subtitle1,
                            fontSize = 14.sp
                        )
                    }
                    // Second Row - Closed Price and Change
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(start = screenWidth * 0.08f)
                    ) {
                        Image(
                            painter = painterResource(id = overview.changeIcon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(10.dp)
                        )
                        Text(
                            text = overview.increase.toString(),
                            style = MaterialTheme.typography.body1,
                            fontSize = 14.sp
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(start = screenWidth * 0.08f)
                    ) {
                        Text(
                            "(", fontSize = 14.sp
                        )
                        if (overview.percentage.toString() == "-") {
                            Image(
                                painter = painterResource(id = overview.changeIcon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(12.dp)
                            )
                        }
                        Text(
                            text = overview.percentage.toString(),
                            style = MaterialTheme.typography.body1,
                            fontSize = 14.sp

                        )
                        Text(")", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun CardViewPreview() {
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
//}
