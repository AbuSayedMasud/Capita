package com.example.capita.home.bottomScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.example.capita.home.portfolioScreen.balance.BalanceScreen
import com.example.capita.home.portfolioScreen.instrument.InstrumentScreen
import com.example.capita.home.portfolioScreen.receivable.ReceivableScreen
import com.example.capita.home.portfolioScreen.sectionBar.portfolioSectionBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PortfolioScreen() {
    val sections = listOf(
        "Instrument",
        "Balance",
        "Receivable",
    )

    val pagerState = rememberPagerState()
    var portfolioSelectedSection by remember { mutableStateOf(0) }


    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            portfolioSelectedSection = page
        }
    }

    LaunchedEffect(portfolioSelectedSection) {
        pagerState.animateScrollToPage(portfolioSelectedSection)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        portfolioSectionBar(
            sections = sections,
            portfolioSelectedSection = portfolioSelectedSection,
            onSectionSelected = { section ->
                portfolioSelectedSection = section
            },
        )

        HorizontalPager(
            pageCount = sections.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            Box(Modifier.fillMaxSize()) {
                when (sections[page]) {
                    "Instrument" -> InstrumentScreen()
                    "Balance" -> BalanceScreen()
                    "Receivable" -> ReceivableScreen()
                }
            }
        }
    }
}

// @Composable
// @Preview(showBackground = true)
// fun ProtfolioScreenPreview() {
//    ProtfolioScreen()
// }
