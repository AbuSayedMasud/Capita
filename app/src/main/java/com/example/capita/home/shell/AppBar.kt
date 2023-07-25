package com.example.capita.home.shell

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.R
import com.example.capita.home.SearchActivity.SearchActivity
import com.example.capita.home.menuScreen.ThemeActivity.ColorSelectionViewModel

@Composable
fun MyAppBar(
    context: Context,
    title: String,
    onSearch: (String) -> Unit,
    showSearchBar: Boolean = false,
    colorSelectionViewModel: ColorSelectionViewModel,
    onProfileClick: (() -> Unit)?,
    profilePhoto: Painter?,
) {
    val myCustomColor = colorSelectionViewModel.appBarColor

    var searchText by remember { mutableStateOf("") } // Maintain the state of the search text
    val isSearching by remember { mutableStateOf(showSearchBar) } // Maintain the state of whether the user is searching or not
    val isActionSearch by remember { mutableStateOf(showSearchBar) }

    TopAppBar(
        title = {
            if (isSearching || isActionSearch) {
                TextField(
                    value = searchText,
                    onValueChange = { newText ->
                        searchText = newText
                        onSearch(newText)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = (-8).dp), // Adjust this value to move the search icon and placeholder to the left

                    placeholder = {
                        Text(
                            text = "Search",
                            color = Color.White,
                        )
                    },
                    leadingIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Search, contentDescription = null, tint = Color.White)
                        }
                    },
                    trailingIcon = {
                        if (searchText.isNotEmpty()) {
                            IconButton(onClick = { searchText = "" }) {
                                Icon(
                                    Icons.Filled.Close,
                                    contentDescription = null,
                                    tint = Color.White,
                                )
                            }
                        } else {
                            IconButton(onClick = {
                                if (context is Activity) {
                                    context.finish()
                                }
                            }) {
                                Icon(
                                    Icons.Filled.Close,
                                    contentDescription = null,
                                    tint = Color.White,
                                )
                            }
                        }
                    },
                    textStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        textColor = Color.White,
                        cursorColor = Color.White.copy(alpha = ContentAlpha.medium),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                )
            } else {
                Text(
                    text = title,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp)
                        .offset(x = (-10).dp),
                )
            }
        },

        // If the user is not currently searching, the title of the app is displayed.
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                if (!isSearching) {
                    IconButton(onClick = {
                        // Open SearchActivity
                        val intent = Intent(context, SearchActivity::class.java)
                        context.startActivity(intent)
                    }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(29.dp),
                        )
                    }
                }

                if (onProfileClick != null) {
                    IconButton(onClick = onProfileClick) {
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .padding(8.dp)
                                .clip(CircleShape)
                                .background(Color.Gray),
                        ) {
                            if (profilePhoto != null) {
                                Image(
                                    painter = profilePhoto,
                                    contentDescription = "Profile Photo",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop,
                                )
                            }
                        }
                    }
                }
            }
        },
        navigationIcon = if (!isSearching) {
            {
                Image(
                    painter = painterResource(id = R.drawable.ab_bank),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(46.dp)
                        .padding(8.dp),
                )
            }
        } else {
            null
        }, // This sets the navigation icon to the app's logo when not searching
        backgroundColor = myCustomColor,
    )
}

// set as the app's logo

// @Preview(showBackground = true)
// @Composable
// fun MyAppBarPreview() {
//    MyAppBar(title = "My App", onSearch = {})
// }
