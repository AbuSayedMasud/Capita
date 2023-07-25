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
import com.example.capita.service.service.ChequeServiceImpl.ChequeServiceImpl

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderChequeRequestScreen() {
    val chequeService = ChequeServiceImpl()
    val chequeList = chequeService.listChequeService()

    // Create state variables for selected dropdown items
    var selectedAccount by remember { mutableStateOf(chequeList.firstOrNull()?.account1 ?: "") }
    var selectedBranch by remember { mutableStateOf(chequeList.firstOrNull()?.branch1 ?: "") }
    var selectedDefinition by remember { mutableStateOf(chequeList.firstOrNull()?.definition1 ?: "") }

    // Create state variables for dropdown menu visibility
    var isAccountDropdownExpanded by remember { mutableStateOf(false) }
    var isBranchDropdownExpanded by remember { mutableStateOf(false) }
    var isDefinitionDropdownExpanded by remember { mutableStateOf(false) }

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
                        value = selectedAccount,
                        onValueChange = { selectedAccount = it },
                        label = { Text("Bank Account") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(
                                onClick = { isAccountDropdownExpanded  = !isAccountDropdownExpanded  },
                            ) {
                                Icon(
                                    if (isAccountDropdownExpanded) Icons.Default.Close else Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                )
                            }
                        },
                    )
                    DropdownMenu(
                        expanded = isAccountDropdownExpanded ,
                        onDismissRequest = { isAccountDropdownExpanded  = false },
                    ) {
                        chequeList.forEach { cheque ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedAccount  = cheque.account1
                                    isAccountDropdownExpanded = false
                                },
                            ) {
                                Text(text = cheque.account1)
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
                        value = selectedBranch,
                        onValueChange = { selectedBranch = it },
                        label = { Text("Delivery Branch") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(
                                onClick = { isBranchDropdownExpanded = !isBranchDropdownExpanded },
                            ) {
                                Icon(
                                    if (isBranchDropdownExpanded) Icons.Default.Close else Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                )
                            }
                        },
                    )
                    DropdownMenu(
                        expanded = isBranchDropdownExpanded,
                        onDismissRequest = { isBranchDropdownExpanded = false },
                    ) {
                        chequeList.forEach { cheque ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedBranch = cheque.branch1
                                    isBranchDropdownExpanded = false
                                },
                            ) {
                                Text(text = cheque.branch1)
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
                        value = selectedDefinition,
                        onValueChange = { selectedDefinition = it },
                        label = { Text("Cheque Definition") },
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            IconButton(
                                onClick = { isDefinitionDropdownExpanded = !isDefinitionDropdownExpanded },
                            ) {
                                Icon(
                                    if (isDefinitionDropdownExpanded) Icons.Default.Close else Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                )
                            }
                        },
                    )
                    DropdownMenu(
                        expanded = isDefinitionDropdownExpanded,
                        onDismissRequest = { isDefinitionDropdownExpanded = false },
                    ) {
                        chequeList.forEach { cheque ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedDefinition = cheque.definition1
                                    isDefinitionDropdownExpanded = false
                                },
                            ) {
                                Text(text = cheque.definition1)
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
