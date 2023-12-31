package com.example.capita.logIn.loginScreen

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capita.R
import com.example.capita.home.HomeActivity
import com.example.capita.service.security.IdentityServiceImpl
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {
    var username by remember {
        mutableStateOf("")
    }
    var isTextClicked by remember { mutableStateOf(false) }
    var isForgetClicked by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val startHomeActivity = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }
    Column(
        modifier = Modifier
            .padding(34.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Login Image",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 100.dp, 0.dp, 100.dp),

        )
        Spacer(modifier = Modifier.height(10.dp))
        Surface(

            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                placeholder = { Text("Enter your username") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedLabelColor = Color.Gray, // Customize other colors as needed
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = colorResource(id = R.color.green),
                    focusedLabelColor = colorResource(id = R.color.green),
                    cursorColor = colorResource(id = R.color.green),
                    leadingIconColor = colorResource(id = R.color.green),
                    placeholderColor = colorResource(id = R.color.green),

                ),
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Username Icon") },
                trailingIcon = {
                    if (username.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear Icon",
                            modifier = Modifier.clickable { username = "" },
                            tint = Color(0xFF006A4E),
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),

            )
        }
        Surface(

            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password Icon") },
                trailingIcon = {
                    val visibilityIcon = if (passwordVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
                    val visibilityIconContentDescription = if (passwordVisible) "Hide password" else "Show password"
                    Icon(
                        painter = painterResource(id = visibilityIcon),
                        contentDescription = visibilityIconContentDescription,
                        modifier = Modifier.clickable { passwordVisible = !passwordVisible },
                        tint = colorResource(id = R.color.green),
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedLabelColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = colorResource(id = R.color.green),
                    focusedLabelColor = colorResource(id = R.color.green),
                    cursorColor = colorResource(id = R.color.green),
                    leadingIconColor = colorResource(id = R.color.green),
                    placeholderColor = colorResource(id = R.color.green),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { isChecked ->
                        checked = isChecked
                    },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color(0xFF006A4E),
                        checkedColor = colorResource(id = R.color.green),
                    ),

                )
                Text(
                    text = "Remember me",
                    color = colorResource(id = R.color.green),
                )
            }

            ClickableText(
                text = AnnotatedString("Forget Password?"),
                onClick = { offset ->
                    isForgetClicked = true
                    scope.launch {
                        Toast.makeText(
                            context,
                            "Text clicked",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                },
                style = TextStyle(color = Color(0xFF006A4E)),
                modifier = Modifier.padding(start = 10.dp),

            )
        }

        Button(
            onClick = {
                val ids = IdentityServiceImpl()
                if (ids.authenticate("", "")) {
                    val intent = Intent(context, HomeActivity::class.java)
                    startHomeActivity.launch(intent)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),

            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF006A4E),
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = "Sign Up",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(5.dp),

            )
        }
    }
}
