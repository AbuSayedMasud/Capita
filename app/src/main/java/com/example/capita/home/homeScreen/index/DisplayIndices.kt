package com.example.capita.home.homeScreen.index

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    LazyColumn {
        items(indices) { index ->
            IndexView(index)
        }
    }
}
