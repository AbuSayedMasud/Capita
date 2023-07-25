package com.example.capita.home.portfolioScreen.instrument

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.portfolio.instrument.Instrument

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun InstrumentView(
    instrument: Instrument,
    expandedIndexInstrument: Int,
    onCardClicked: (Int) -> Unit,

) {
//    val longName = instrument.longName
    val shortName = instrument.shortName
    val closedPrice = instrument.closedPrice
    val value = instrument.value
    val change = instrument.change
    val changeIcon = instrument.changeIcon
    val TotalQuantity = instrument.TotalQuantity
    val SalableQuantity = instrument.SalableQuantity
    val AverageCost = instrument.AverageCost
    val TotalCost = instrument.TotalCost
    val ClosePrice = instrument.ClosePrice
    val UnrealizedGain = instrument.UnrealizedGain
    val GainPercent = instrument.GainPercent
    val CostValue = instrument.Costvalue

    val isExpanded = expandedIndexInstrument == instrument.index

    var expanded by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // Define sizes based on screen size
    val imageSize = (screenWidth * 0.09f).coerceAtMost(52.dp)
    val textColumnWeight =
        if (screenWidth > 600.dp) 4f else 1f // Increase text space on large screens
    val valueColumnWeight =
        if (screenWidth > 600.dp) 2f else 1f // Increase value space on large screens
    val textSize = if (screenWidth > 600.dp) 14.sp else 12.sp

    Card(
        modifier = Modifier.padding(16.dp, 8.dp),
        elevation = 2.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
        onClick = { onCardClicked(instrument.index) },
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
//                Box(
//                    modifier = Modifier
//                        .size(imageSize)
//                        .padding(screenWidth * 0.01f),
//                    contentAlignment = Alignment.Center,
//                ) {
//                    Image(
//                        painter = icon,
//                        contentDescription = null,
//                    )
//                }
//
                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(textColumnWeight)) {
                    Text(
                        text = shortName,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                    )
                    Text(text = instrument.longName, style = MaterialTheme.typography.body2)
                }

                Column(
                    modifier = Modifier
                        .weight(valueColumnWeight)
                        .padding(top = screenWidth * 0.001f),
                    horizontalAlignment = Alignment.End,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Text(
                            text = value.toString(),
                            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                            fontSize = 14.sp,
                            textAlign = TextAlign.End,
                        )
                    }
                    // Second Row - Closed Price and Change
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                    ) {
                        Image(
                            painter = painterResource(id = changeIcon),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                        )
                        Text(
                            text = closedPrice.toString(),
                            style = MaterialTheme.typography.body2,
                            fontSize = textSize,
                            textAlign = TextAlign.End,
                        )
                        Text("(")
                        if (change.toString() == "-") {
                            Image(
                                painter = painterResource(id = changeIcon),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                            )
                        }

                        Text(
                            text = change.toString(),
                            style = MaterialTheme.typography.body2,
                            fontSize = textSize,
                            textAlign = TextAlign.End,
                        )
                        Text(")")
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))

//                IconButton(onClick = { expanded = !expanded }) {
//                    Icon(
//                        imageVector = Icons.Default.ArrowDropDown,
//                        contentDescription = if (expanded) "Collapse" else "Expand",
//                        modifier = Modifier.rotate(if (expanded) 180f else 0f),
//                    )
//                }
            }

            AnimatedContent(
                targetState = isExpanded,
            ) { targetExpanded ->
                AnimatedVisibility(
                    visible = targetExpanded,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically(),
                ) {
                    if (isExpanded) {
                        Card(
                            modifier = Modifier.padding(top = 8.dp),
                            elevation = 0.dp, // Set elevation to 0 to remove the shadow
                            backgroundColor = Color.Transparent, // Set background color to transparent
                            shape = MaterialTheme.shapes.medium,
                            border = null, // Set border property to null to remove the border
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                            ) {
                                InstrumentItem("Total Quantity", TotalQuantity)
                                InstrumentItem("Salable Quantity", SalableQuantity)
                                InstrumentItem("Average Cost", AverageCost)
                                InstrumentItem("Total Cost", TotalCost)
                                InstrumentItem("Close Price", ClosePrice)
                                InstrumentItem("Unrealized Gain/Loss", UnrealizedGain)
                                InstrumentItem("%Gain(Loss)", GainPercent)
                                InstrumentItem("%Cost value", CostValue)
                            }
                        }
                    }
                }
            }
        }
    }
}
