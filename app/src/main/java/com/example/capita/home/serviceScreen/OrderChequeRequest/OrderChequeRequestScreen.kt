package com.example.capita.home.serviceScreen.OrderChequeRequest

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderChequeRequestScreen() {
    var selectedDropdownItem1 by remember { mutableStateOf("Item 1") }
    var selectedDropdownItem2 by remember { mutableStateOf("Item 1") }
    var selectedDropdownItem3 by remember { mutableStateOf("Item 1") }

    val dropdownItem1 = listOf("Item 1", "Item 2", "Item 3")
    val dropdownItem2 = listOf("Item 1", "Item 2", "Item 3")
    val dropdownItem3 = listOf("Item 1", "Item 2", "Item 3")

    var isDropdownExpanded1 by remember { mutableStateOf(false) }
    var isDropdownExpanded2 by remember { mutableStateOf(false) }
    var isDropdownExpanded3 by remember { mutableStateOf(false) }

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextField(
                        value = selectedDropdownItem1,
                        onValueChange = { selectedDropdownItem1 = it },
                        label = { Text("Bank Account") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(
                                onClick = { isDropdownExpanded1 = !isDropdownExpanded1 },
                            ) {
                                Icon(
                                    if (isDropdownExpanded1) Icons.Default.Close else Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                )
                            }
                        },
                    )
                    DropdownMenu(
                        expanded = isDropdownExpanded1,
                        onDismissRequest = { isDropdownExpanded1 = false },
                    ) {
                        dropdownItem1.forEach { item ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedDropdownItem1 = item
                                    isDropdownExpanded1 = false
                                },
                            ) {
                                Text(text = item)
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextField(
                        value = selectedDropdownItem2,
                        onValueChange = { selectedDropdownItem2 = it },
                        label = { Text("Delivery Branch") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(
                                onClick = { isDropdownExpanded2 = !isDropdownExpanded2 },
                            ) {
                                Icon(
                                    if (isDropdownExpanded2) Icons.Default.Close else Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                )
                            }
                        },
                    )
                    DropdownMenu(
                        expanded = isDropdownExpanded2,
                        onDismissRequest = { isDropdownExpanded2 = false },
                    ) {
                        dropdownItem2.forEach { item ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedDropdownItem2 = item
                                    isDropdownExpanded2 = false
                                },
                            ) {
                                Text(text = item)
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextField(
                        value = selectedDropdownItem3,
                        onValueChange = { selectedDropdownItem3 = it },
                        label = { Text("Cheque Definition") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(
                                onClick = { isDropdownExpanded3 = !isDropdownExpanded3 },
                            ) {
                                Icon(
                                    if (isDropdownExpanded3) Icons.Default.Close else Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                )
                            }
                        },
                    )
                    DropdownMenu(
                        expanded = isDropdownExpanded3,
                        onDismissRequest = { isDropdownExpanded3 = false },
                    ) {
                        dropdownItem3.forEach { item ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedDropdownItem3 = item
                                    isDropdownExpanded3 = false
                                },
                            ) {
                                Text(text = item)
                            }
                        }
                    }
                }
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF006A4E),
                        contentColor = Color.White,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(
                        text = "Submit",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(5.dp),

                    )
                }
            }
        },
    )
}
