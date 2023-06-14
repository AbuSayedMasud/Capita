package com.example.capita.screen.topBarScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.capita.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyAppBar(
    title: String,
    onSearch: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") } // Maintain the state of the search text
    var isSearching by remember { mutableStateOf(false) } // Maintain the state of whether the user is searching or not

    val painter = painterResource(id =R.drawable.logo)
    val myCustomColor = Color(0xFF006A4E)

    TopAppBar(
        /*If the user is searching, it creates a TextField for them to type their search query into.
         When the text in the TextField changes, it updates the searchText and calls onSearch.
         */
        title = {
            if (isSearching) {
//                Surface(
//                    shape = MaterialTheme.shapes.small,
//                    modifier = Modifier.fillMaxWidth()
//                )
                TextField(
                    value = searchText,
                    onValueChange = { newText ->
                        searchText = newText
                        onSearch(newText)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 10.dp, top = 2.dp, bottom = 2.dp),
                    placeholder = { Text("Search") },
                    leadingIcon = {
                        IconButton(onClick = { isSearching = false }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    trailingIcon = {
                        if (searchText.isNotEmpty()) {
                            IconButton(onClick = { searchText = "" }) {
                                Icon(Icons.Filled.Close, contentDescription = null)
                            }
                        }
                    },
                    textStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        textColor = Color.DarkGray,
                        cursorColor = Color.DarkGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(50) // This sets the corners of the TextField to be rounded
                )

            } else {
                Text(text = title, color = Color.White) // If not in search mode, just display the title
            }
        },

        // If the user is not currently searching, the title of the app is displayed.
        actions = {
            if (!isSearching) {
                IconButton(onClick = { isSearching = true }) {
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
@Preview(showBackground = true)
@Composable
fun MyAppBarPreview() {
    MyAppBar(title = "My App", onSearch = {})
}