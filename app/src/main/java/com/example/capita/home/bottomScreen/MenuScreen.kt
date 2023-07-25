package com.example.capita.home.bottomScreen

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.R
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel
import com.example.capita.home.menuScreen.ThemeActivity.ShowColorSelectionDialog

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuScreen(colorSelectionViewModel: ColorSelectionViewModel) {
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }

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
        modifier = Modifier
            .padding(16.dp, 6.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color(0xFFFFFFFF),
        shape = MaterialTheme.shapes.medium,
        onClick = {
            showDialog.value = true
        },
    ) {
        Row(
//            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(imageSize)
                    .padding(screenWidth * 0.02f),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.theme),
                    contentDescription = null,
                )
            }

            Column(modifier = Modifier.weight(textColumnWeight)) {
                Text(
                    text = "Theme",
                    modifier = Modifier.padding(bottom = screenWidth * 0.01f),
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                    fontSize = 17.sp,
                )
            }
        }
    }
    if (showDialog.value) {
        ShowColorSelectionDialog(context, colorSelectionViewModel) {
            showDialog.value = false
        }
    }
}

// @Composable
// @Preview(showBackground = true)
// fun MoreScreenPreview() {
//    MoreScreen()
// }
