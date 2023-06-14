package com.example.capita.HomePageModule

import SetStatusBarColor
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.capita.BottomBar.MainScreenBottomBar
import com.example.capita.HomePageModule.ui.theme.CapitaTheme
import com.example.capita.screen.topBarScreen.MyAppBar
import com.example.capita.service.instrument.InstrumentServiceImpl

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var service = InstrumentServiceImpl();
        for (i: com.example.capita.instrument.Instrument in service.listInstrument()){
            Log.d("HomeActivity", i.name)
        }
        setContent {
            SetStatusBarColor(Color(0xFF0E2B26),Color(0xFF0E2B26))
            CapitaTheme {

                Column {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        MyAppBar(
                            title = "Capita",
                            onSearch = { searchText ->
                                // What happens when the search button is clicked
                            }
                        )
                    }
                    MainScreenBottomBar()
                }
            }
        }
    }
}
