package com.example.capita.home.topBarScreen

import androidx.cardview.widget.CardView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.capita.instrument.Instrument

@Composable
fun CardView(instrument: Instrument) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = instrument.id.toString(), modifier = Modifier.padding(8.dp))
            Text(text = instrument.name, modifier = Modifier.padding(8.dp))
            Text(text = instrument.symbol, modifier = Modifier.padding(8.dp))
            Text(text = instrument.market, modifier = Modifier.padding(8.dp))
            Text(text = instrument.assetClass, modifier = Modifier.padding(8.dp))
        }

    }
}