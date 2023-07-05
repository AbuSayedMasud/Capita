package com.example.capita.home.homeScreen.stocks


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.capita.instrument.Instrument

@Composable
fun CardView(instrument: Instrument) {
    Card(
        modifier = Modifier.padding(16.dp),
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
                        painter = painterResource(id = instrument.icon),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = instrument.longName,
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.subtitle1
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    // Second Row - Short Name, Equity, Market
                    Text(
                        text = instrument.shortName,
                        style = MaterialTheme.typography.body1
                    )
                    Text("|", modifier = Modifier.padding(horizontal = 4.dp))
                    Text(
                        text = instrument.equity,
                        style = MaterialTheme.typography.body1
                    )
                    Text("|", modifier = Modifier.padding(horizontal = 4.dp))
                    Text(
                        text = instrument.market,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            // Second Column
            Column(modifier = Modifier.weight(2f)) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    // First Row - Value
                    Text(
                        text = instrument.value.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
                Column(modifier = Modifier.fillMaxHeight().align(Alignment.CenterHorizontally), verticalArrangement = Arrangement.Center) {
                    // Second Row - Closed Price and Change
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = instrument.changeIcon),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = instrument.closedPrice.toString(),
                            style = MaterialTheme.typography.body1,
                        )
                        Text("(")
                        if(instrument.change.toString()=="-"){
                            Image(
                                painter = painterResource(id = instrument.changeIcon),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }


                        Text(
                            text = instrument.change.toString(),
                            style = MaterialTheme.typography.body1,
                        )
                        Text(")")

                    }
                }
            }
        }
    }
}