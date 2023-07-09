package com.example.capita.home.shell

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.capita.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.home.actionActivity.actionActivity

@Composable
fun MyAppBar(
    context: Context,
    title: String,
    onSearch: (String) -> Unit,
    showSearchBar: Boolean = false
) {
    var searchText by remember { mutableStateOf("") } // Maintain the state of the search text
    var isSearching by remember { mutableStateOf(showSearchBar) } // Maintain the state of whether the user is searching or not
    var isActionSearch by remember { mutableStateOf(showSearchBar) }

    val painter = painterResource(id = R.drawable.logo)
    val myCustomColor = Color(0xFF006A4E)

    TopAppBar(
        /*If the user is searching, it creates a TextField for them to type their search query into.
         When the text in the TextField changes, it updates the searchText and calls onSearch.
         */
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
                            color = Color.White
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
                                    tint = Color.White
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
                                    tint = Color.White
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
                        disabledIndicatorColor = Color.Transparent
                    ),
                )

            } else {
                Text(
                    text = title,
                    color = Color.White
                ) // If not in search mode, just display the title
            }
        },

        // If the user is not currently searching, the title of the app is displayed.
        actions = {
            if (!isSearching) {
                IconButton(onClick = {
                    //Open SearchActivity
                    val intent = Intent(context, SearchActivity::class.java)
                    context.startActivity(intent)
                }) {
                    Icon(Icons.Filled.Search, contentDescription = null, tint = Color.White)
                }
            }
        },
        //set as the app's logo
        navigationIcon = if (!isSearching) {
            {
                IconButton(onClick = { }) {
                    Image(
                        painter = painter,
                        contentDescription = "Logo",
                        modifier = Modifier.size(46.dp)
                    )
                }
            }
        } else null, // This sets the navigation icon to the app's logo when not searching
        backgroundColor = myCustomColor
    )
}
//@Preview(showBackground = true)
//@Composable
//fun MyAppBarPreview() {
//    MyAppBar(title = "My App", onSearch = {})
//}