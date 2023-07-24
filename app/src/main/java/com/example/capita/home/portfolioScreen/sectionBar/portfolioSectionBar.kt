package com.example.capita.home.portfolioScreen.sectionBar // ktlint-disable filename

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.capita.home.homeScreen.sectionBar.CustomScrollableTabRow

@SuppressLint("RememberReturnType")
@Composable
fun PortfolioSectionBar(
    sections: List<String>,
    portfolioSelectedSection: Int,
    onSectionSelected: (Int) -> Unit,
    portfolioSectionBarColor: Color,
) {
    Surface(
        color = portfolioSectionBarColor, // Use the lighter color for the section bar
        modifier = Modifier.fillMaxWidth(),

        ) {
        CustomScrollableTabRow(
            tabs = sections,
            selectedTabIndex = portfolioSelectedSection,
            portfolioSectionBarColor = portfolioSectionBarColor,
            onTabClick = { index ->
                onSectionSelected(index)
            },
        )
    }
}

@Composable
fun CustomScrollableTabRow(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    portfolioSectionBarColor: Color,
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .customTabIndicatorOffset(
                        currentTabPosition = tabPositions[selectedTabIndex],
                        tabWidth = tabPositions[selectedTabIndex].width.value.dp,
                    ),
            )
        },
        backgroundColor = portfolioSectionBarColor,
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            Tab(
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tabIndex) },
                text = {
                    Text(
                        text = tab,
                        fontFamily = FontFamily.Default,
                        color = if (selectedTabIndex == tabIndex) Color.Black else Color.Gray,
                    )
                },
            )
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp,
): Modifier = composed {
    composed(
        inspectorInfo = debugInspectorInfo {
            name = "customTabIndicatorOffset"
            value = currentTabPosition
        },
    ) {
        val currentTabWidth by animateDpAsState(
            targetValue = tabWidth,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        )
        val indicatorOffset by animateDpAsState(
            targetValue = currentTabPosition.left,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        )
        this.fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset(x = indicatorOffset)
            .width(currentTabWidth)
    }
}

// @Preview
// @Composable
// fun PreviewScrollingSectionBar() {
//    scrollingSectionBar()
// }
