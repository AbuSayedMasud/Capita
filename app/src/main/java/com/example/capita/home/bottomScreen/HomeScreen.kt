package com.example.capita.home.bottomScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.example.capita.home.homeScreen.index.IndexScreen
import com.example.capita.home.homeScreen.overview.OverviewScreen
import com.example.capita.home.homeScreen.sectionBar.HomeSectionBar
import com.example.capita.home.homeScreen.stocks.StockScreen
import com.google.accompanist.pager.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val sections = listOf(
        "Overview",
        "Indices",
        "Stocks",
    )
    val pagerState = rememberPagerState()
    var homeSelectedSection by remember { mutableStateOf(0) }

    // Observe the current page and update the selected section accordingly.
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            homeSelectedSection = page
        }
    }

    LaunchedEffect(homeSelectedSection) {
        pagerState.animateScrollToPage(homeSelectedSection)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        HomeSectionBar(
            sections = sections,
            homeSelectedSection = homeSelectedSection,
            onSectionSelected = { section ->
                homeSelectedSection = section
            },
        )

        HorizontalPager(
            pageCount = sections.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            Box(Modifier.fillMaxSize()) {
                when (sections[page]) {
                    "Overview" -> OverviewScreen()
                    "Indices" -> IndexScreen()
                    "Stocks" -> StockScreen()
                }
            }
        }
    }
}
// @Composable
// @Preview(showBackground = true)
// fun HomeScreenPreview() {
//    HomeScreen()
// }
