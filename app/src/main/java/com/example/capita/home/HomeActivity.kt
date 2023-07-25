package com.example.capita.home

import SetStatusBarColor
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.capita.R
import com.example.capita.home.bottomScreen.ServiceScreen
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.example.capita.home.serviceScreen.DisplayServices
import com.example.capita.home.serviceScreen.OrderChequeRequest.ChequeBookAppBar
import com.example.capita.home.serviceScreen.OrderChequeRequest.OrderChequeRequestScreen
import com.example.capita.home.serviceScreen.ServiceView
import com.example.capita.home.shell.MainScreenBottomBar
import com.example.capita.home.shell.MyAppBar
import com.example.capita.home.ui.theme.CapitaTheme
import com.example.capita.service.Service
import com.example.capita.service.service.ServiceImpl

class HomeActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val colorSelectionViewModel = viewModel<ColorSelectionViewModel>()
            val profilePhoto: Painter = painterResource(id = R.drawable.profile_photo)
            val onProfileClick: () -> Unit = {
                // Handle the profile photo click event here
            }

            SetStatusBarColor(Color(0xFF0E2B26), Color(0xFF0E2B26))
            CapitaTheme {
                val navController = rememberNavController()
                val isCardClicked = remember { mutableStateOf(false) }

                Column {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        // Use the ChequeBookAppBar when the card is clicked
                        if (isCardClicked.value) {
                            ChequeBookAppBar(
                                title = "My Text",
                                colorSelectionViewModel = colorSelectionViewModel,
                            )
                        } else {
                            // Original AppBar when the card is not clicked
                            MyAppBar(
                                context = this@HomeActivity,
                                title = "AB Bank",
                                onSearch = { searchText ->
                                    // What happens when the search button is clicked
                                },
                                showSearchBar = false,
                                colorSelectionViewModel = colorSelectionViewModel,
                                onProfileClick = onProfileClick,
                                profilePhoto = profilePhoto,
                            )
                        }
                    }

                    // Content area
                    if (isCardClicked.value) {
                        // New Composable page when the card is clicked
                        OrderChequeRequestScreen()
                    } else {
                        MainScreenBottomBar(colorSelectionViewModel)
                    }
                }
            }
        }
    }
}
