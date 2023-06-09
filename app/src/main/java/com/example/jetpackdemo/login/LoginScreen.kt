package com.example.jetpackdemo.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jetpackdemo.DemoScreens
import com.example.jetpackdemo.ui.theme.PurplePrimary


@Composable

fun LoginScreen(navController: NavHostController?, loginViewModel: LoginViewModel) {
    var email by remember { mutableStateOf(TextFieldValue("")) }


    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Text(
            text = "Login",
            modifier = Modifier.clickable {
                navController?.navigate(DemoScreens.REGISTER_SCREEN)
            },
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(text = "Please sign in to continue.",
            modifier = Modifier
                .clickable {
                    navController?.navigate(DemoScreens.REGISTER_SCREEN)
                }
                .padding(top = 10.dp),
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp)

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Email address") },
        )


        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            },
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(text = "Password") },


            )

        Button(
            onClick = {
                loginViewModel.doLogin()
            },
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = PurplePrimary, contentColor = Color.White
            )
        ) {
            Text(text = "Login")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    LoginScreen(navController = null, loginViewModel = viewModel())
}
