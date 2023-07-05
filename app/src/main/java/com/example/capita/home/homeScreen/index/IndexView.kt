package com.example.capita.home.homeScreen.index

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.capita.index.Indices
import com.example.service.protype.R

@Composable
fun IndexView(index: Indices) {
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
                        painter = painterResource(id = index.icon),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = index.shortName,
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
                        text = index.longName,
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
                    Text(
                        text = index.amount.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 24.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.Center
                ) {
                    // Second Row - Closed Price and Change
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 30.dp)
                    ) {
                        Image(
                            painter = painterResource(id = index.changeIcon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(10.dp)
                        )
                        Text(
                            text = index.increase.toString(),
                            style = MaterialTheme.typography.body1
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 30.dp)
                    ) {
                        Text(
                            "("
                        )
                        if (index.percentage.toString() == "-") {
                            Image(
                                painter = painterResource(id = index.changeIcon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(16.dp)

                            )
                        }
                        Text(
                            text = index.percentage.toString(),
                            style = MaterialTheme.typography.body1

                            )
                        Text(")")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CardViewPreview() {
    val sampleIndex = Indices(
        icon = R.drawable.logo1,
        longName = "DSEX Index",
        shortName = "DSEX",
        amount = 6331.36305,
        increase = 11.93465,
        percentage = 0.18815,
        changeIcon = R.drawable.minus
    )

    MaterialTheme {
        IndexView(index = sampleIndex)
    }
}
