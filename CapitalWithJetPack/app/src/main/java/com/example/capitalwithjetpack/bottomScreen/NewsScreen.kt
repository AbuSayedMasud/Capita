package com.example.capitalwithjetpack.bottomScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NewsScreen(){
    Box(modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "News",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold

        )
    }
}
@Composable
@Preview(showBackground = true)
fun NewsScreenPreview(){
    NewsScreen()
}