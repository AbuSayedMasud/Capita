package com.example.capita.home.portfolioScreen.receivable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.portfolio.receivable.Receivable

@Composable
fun ReceivableView(receivable: Receivable) {
    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp),
//            .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.medium)
//            .padding(8.dp),
        elevation = 2.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
    ) {
        Column {
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(
                    text = receivable.Name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp),
                    textAlign = TextAlign.Start,
                )
            }
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Company",
                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(bottom = 4.dp),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Share Quantity",
                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(bottom = 4.dp),
                        fontSize = 12.sp,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Amount",
                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(bottom = 4.dp),
                        fontSize = 12.sp,
                    )
                }
            }

            // Data Rows

            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = receivable.company1,
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = receivable.company2,
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "${receivable.shareQuantity1}",
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp,
                    )
                    Text(
                        text = "${receivable.shareQuantity2}",
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "${receivable.amount1}",
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp,
                    )
                    Text(
                        text = "${receivable.amount2}",
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}
