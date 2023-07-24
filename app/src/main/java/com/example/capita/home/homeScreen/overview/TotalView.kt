package com.example.capita.home.homeScreen.overview

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TotalView() {
    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp),
//            .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.medium)
//            .padding(8.dp),
        elevation = 8.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
    ) {
        Column {
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Total Trade",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                )
                Text(
                    text = 193559.toString(),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                )
            }
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Total Volumn",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                )
                Text(
                    text = 300234263.toString(),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                )
            }
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Total Value in Taka (mn)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                )
                Text(
                    text = 8906.972.toString(),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}
