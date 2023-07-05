package com.example.capita.home.bottomScreen

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capita.R
import com.example.capita.home.homeScreen.overview.StatusView
import com.example.capita.home.homeScreen.overview.TotalView
import com.example.capita.home.homeScreen.sectionBar.scrollingSectionBar
import com.example.capita.home.homeScreen.stocks.CardView
import com.example.capita.service.index.IndexServiceImpl
import com.example.capita.index.Indices
import com.example.capita.instrument.Instrument
import com.example.capita.overview.Overview
import com.example.capita.service.instrument.InstrumentServiceImpl
import com.example.capita.service.overview.OverviewServiceImpl
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capita.home.homeScreen.index.IndexView

@Composable
fun HomeScreen() {
    var selectedSection by remember { mutableStateOf("Overview") }

    Column {
        scrollingSectionBar(
            selectedSection = selectedSection,
            onSectionSelected = { section ->
                selectedSection = section
            }
        )

        val navController = rememberNavController()

        NavHost(navController, startDestination = selectedSection){
            composable("Overview"){
                OverviewScreen()
            }
            composable("Indices"){
                IndexScreen()
            }
            composable("Stocks"){
                InstrumentScreen()
            }
        }
    }
    }
@Composable
fun InstrumentScreen() {
    val instrumentService = InstrumentServiceImpl()
    val instruments by remember { mutableStateOf(instrumentService.instruments) }

    DisplayInstruments(instruments)
}

@Composable
fun DisplayInstruments(instruments: List<Instrument>) {
    LazyColumn {
        items(instruments) { instrument ->
            CardView(instrument)
        }
    }
}

@Composable
fun OverviewScreen() {
    val overviewService = OverviewServiceImpl()
    val overview by remember { mutableStateOf(overviewService.overview) }

    Column {
        StatusView()
        DisplayOverview(overview)
        TotalView()

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            // Add padding to create some spacing around the button
            FloatingActionButton(
                onClick = { /* Handle the button click */ },
                content = {
                    val imagePainter = painterResource(R.drawable.pen)
                    Icon(
                        painter = imagePainter,
                        contentDescription = "Custom Icon",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier
                    .padding(16.dp)
                    .offset((-8).dp, (-60).dp)
                    .size(56.dp),

                // Set the background color of the button to white
                backgroundColor = androidx.compose.ui.graphics.Color.White,
                contentColor = androidx.compose.ui.graphics.Color.Black
            )
        }
    }

}

@Composable
fun DisplayOverview(overview: List<Overview>) {
    LazyColumn {
        items(overview) { overview ->
            com.example.capita.home.homeScreen.overview.CardView(overview)
        }
    }
}

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


//@Composable
//@Preview(showBackground = true)
//fun HomeScreenPreview() {
//    HomeScreen()
//}