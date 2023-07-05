package com.example.capita.home.homeScreen.overview

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StatusView() {

    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp),
//            .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.medium)
//            .padding(8.dp),
        elevation = 8.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Market Status",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Open",
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Last Update",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp),
                        fontSize = 14.sp

                        )
                    Text(
                        text = "Jul 05, 2023 at 11:46 AM",
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}