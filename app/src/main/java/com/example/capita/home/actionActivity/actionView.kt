package com.example.capita.home.actionActivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.capita.action.Action
import com.example.capita.index.Indices
import com.example.service.protype.R

@Composable
fun ActionView(action: Action, onClick: () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .clickable(onClick = onClick),
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
                        painter = painterResource(id = action.icon),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = action.shortName,
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
                        text = action.longName,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun CardViewPreview() {
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
//}
