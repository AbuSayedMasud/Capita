package com.example.capita.home.homeScreen.stocks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.capita.home.stock.Stock

@Composable
fun StockView(stock: Stock) {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 8.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            // First Column
            Column(modifier = Modifier.weight(4f)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    // First Row - Icon and Full Name
                    Image(
                        painter = painterResource(id = stock.icon),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                    )
                    Text(
                        text = stock.longName,
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    // Second Row - Short Name, Equity, Market
                    Text(
                        text = stock.shortName,
                        style = MaterialTheme.typography.body1,
                    )
                    Text("|", modifier = Modifier.padding(horizontal = 4.dp))
                    Text(
                        text = stock.equity,
                        style = MaterialTheme.typography.body1,
                    )
                    Text("|", modifier = Modifier.padding(horizontal = 4.dp))
                    Text(
                        text = stock.market,
                        style = MaterialTheme.typography.body1,
                    )
                }
            }
            // Second Column
            Column(modifier = Modifier.weight(2f)) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    // First Row - Value
                    Text(
                        text = stock.value.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(vertical = 4.dp),
                    )
                }
                Column(modifier = Modifier.fillMaxHeight().align(Alignment.CenterHorizontally), verticalArrangement = Arrangement.Center) {
                    // Second Row - Closed Price and Change
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = stock.changeIcon),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                        )
                        Text(
                            text = stock.closedPrice.toString(),
                            style = MaterialTheme.typography.body1,
                        )
                        Text("(")
                        if (stock.change.toString() == "-") {
                            Image(
                                painter = painterResource(id = stock.changeIcon),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                            )
                        }

                        Text(
                            text = stock.change.toString(),
                            style = MaterialTheme.typography.body1,
                        )
                        Text(")")
                    }
                }
            }
        }
    }
}
