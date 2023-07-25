package com.example.capita.home.homeScreen.stocks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.home.stock.Stock

@Composable
fun StockView(stock: Stock) {
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
        modifier = Modifier.padding(16.dp,8.dp),
        elevation = 2.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
//                Box(
//                    modifier = Modifier
//                        .size(imageSize)
//                        .padding(screenWidth * 0.01f),
//                    contentAlignment = Alignment.Center,
//                ) {
//                    Image(
//                        painter = painterResource(id = stock.icon),
//                        contentDescription = null,
//                    )
//                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(2f)) {
                    Text(
                        text = stock.longName,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = stock.shortName, style = MaterialTheme.typography.body2)
                        Text("|", modifier = Modifier.padding(horizontal = 2.dp))
                        Text(text = stock.equity, style = MaterialTheme.typography.body2)
                        Text("|", modifier = Modifier.padding(horizontal = 2.dp))
                        Text(text = stock.market, style = MaterialTheme.typography.body2)
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = screenWidth * 0.001f),
                    horizontalAlignment = Alignment.End,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Text(
                            text = stock.value.toString(),
                            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
//                            fontSize = 14.sp,
                            textAlign = TextAlign.End,
                        )
                    }
                    // Second Row - Closed Price and Change
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Image(
                            painter = painterResource(id = stock.changeIcon),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                        )
                        Text(
                            text = stock.closedPrice.toString(),
                            style = MaterialTheme.typography.body2,
//                            fontSize = textSize,
                            textAlign = TextAlign.End,
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
                            style = MaterialTheme.typography.body2,
//                            fontSize = textSize,
                            textAlign = TextAlign.End,
                        )
                        Text(")")
                    }
                }
            }
        }
    }
}
