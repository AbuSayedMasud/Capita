package com.example.capita.home.homeScreen.overview

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.capita.R
import com.example.capita.home.actionActivity.actionActivity
import com.example.capita.overview.Overview
import com.example.capita.service.overview.OverviewServiceImpl

@Composable
fun OverviewScreen() {
    val overviewService = OverviewServiceImpl()
    val context = LocalContext.current

    val actionShortName = (context as Activity).intent.getStringExtra("action_shortName")

    val overviewData = when (actionShortName) {
        "DSE" -> overviewService.overviewDSE
        "CSE" -> overviewService.overviewCSE
        else -> overviewService.overviewDSE
    }

    val overview by remember { mutableStateOf(overviewData) }

    Column {
        StatusView()
        DisplayOverview(overview)
        TotalView()

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd,
        ) {
            // Add padding to create some spacing around the button
            FloatingActionButton(
                onClick = {
                    val intent = Intent(context, actionActivity::class.java)
                    context.startActivity(intent)
                },
                content = {
                    val imagePainter = painterResource(R.drawable.filter)
                    Icon(
                        painter = imagePainter,
                        contentDescription = "Custom Icon",
                        modifier = Modifier.size(24.dp),
                    )
                },
                modifier = Modifier
                    .padding(16.dp)
                    .offset((-8).dp, (-60).dp)
                    .size(56.dp),

                // Set the background color of the button to white
                backgroundColor = Color.White,
                contentColor = Color.Black,
            )
        }
    }
}

@Composable
fun DisplayOverview(overview: List<Overview>) {
    LazyColumn {
        items(overview) { overview ->
            OverView(overview)
        }
    }
}
