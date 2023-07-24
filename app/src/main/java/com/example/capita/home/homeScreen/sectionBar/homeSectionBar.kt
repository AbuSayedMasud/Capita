package com.example.capita.home.homeScreen.sectionBar // ktlint-disable filename

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
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
import com.google.accompanist.pager.* // ktlint-disable no-wildcard-imports

// @SuppressLint("RememberReturnType")
// @Composable
// fun HomeSectionBar(
//    sections: List<String>,
//    homeSelectedSection: Int,
//    onSectionSelected: (Int) -> Unit,
//    homeSectionBarColor: Color,
// ) {
//    Surface(
//        color = homeSectionBarColor, // Use the lighter color for the section bar
//        modifier = Modifier.fillMaxWidth(),
//
//    ) {
//        ScrollableTabRow(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(48.dp)
//                .background(homeSectionBarColor),
//            edgePadding = 0.dp,
//            selectedTabIndex = homeSelectedSection,
//            backgroundColor = homeSectionBarColor,
//        ) {
//            sections.forEachIndexed { index, section ->
//                Tab(
//                    selected = homeSelectedSection == index,
//                    onClick = { onSectionSelected(index) },
//                    // Custom indicator that fills the entire width of the tab
//                    modifier = Modifier.fillMaxWidth(),
//                ) {
//                    Text(
//                        text = section,
//                        fontFamily = FontFamily.Default,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.padding(16.dp),
//                        style = TextStyle(
//                            color = if (homeSelectedSection == index) Color.Black else Color.Gray,
//                        ),
//                    )
//                }
//            }
//        }
//    }
// }

@SuppressLint("RememberReturnType")
@Composable
fun HomeSectionBar(
    sections: List<String>,
    homeSelectedSection: Int,
    onSectionSelected: (Int) -> Unit,
    homeSectionBarColor: Color,
) {
    Surface(
        color = homeSectionBarColor, // Use the lighter color for the section bar
        modifier = Modifier.fillMaxWidth(),

    ) {
        CustomScrollableTabRow(
            tabs = sections,
            selectedTabIndex = homeSelectedSection,
            homeSectionBarColor = homeSectionBarColor,
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
    homeSectionBarColor: Color,
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
        backgroundColor = homeSectionBarColor,
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
