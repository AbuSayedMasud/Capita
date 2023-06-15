package com.example.capita.logIn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.capita.logIn.ui.theme.CapitaTheme
import com.example.capita.logIn.loginScreen.LoginScreen

class LogInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapitaTheme {
                Surface(
                    color = Color.White
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFFFFF))
                    ) {
                        LogInApplication()
                    }
                }
            }
        }
    }
}

@Composable
fun LogInApplication() {
    LoginScreen()
}