package com.example.capita.home.serviceScreen

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
import com.example.capita.service.Service
import com.example.capita.service.service.ServiceImpl

@Composable
fun DisplayServices(services: List<Service>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 56.dp) // Adjust the bottom padding to account for the bottom navigation bar height
                .fillMaxHeight(),
        ) {
            items(services) { service ->
                ServiceView(service)
            }
        }
    }
}
