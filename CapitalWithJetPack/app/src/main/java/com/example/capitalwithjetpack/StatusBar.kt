package com.example.capitalwithjetpack
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.viewinterop.AndroidView
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

@Composable
fun SetStatusBarColor(color: Color) {
    val context = LocalContext.current
    val view = LocalView.current

    AndroidView(factory = {
        View(context).apply {
            setBackgroundColor(color.toArgb())
        }
    }, update = { view ->
        view.setBackgroundColor(color.toArgb())
    })

    (context as? Activity)?.window?.apply {
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = color.toArgb()
        decorView.systemUiVisibility = view.systemUiVisibility
    }
}
