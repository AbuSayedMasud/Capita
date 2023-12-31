package com.example.capita.home.homeScreen.index

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capita.home.index.Indices
import com.example.capita.service.home.index.IndexServiceImpl

@Composable
fun IndexScreen() {
    val indexService = IndexServiceImpl()
    val indices by remember { mutableStateOf(indexService.listIndex()) }

    DisplayIndices(indices)
}

@Composable
fun DisplayIndices(indices: List<Indices>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 56.dp) // Adjust the bottom padding to account for the bottom navigation bar height
                .fillMaxHeight(),
        ) {
            items(indices) { index ->
                IndexView(index)
            }
        }
    }
}
