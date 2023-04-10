package com.example.jetpackdemo.register

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jetpackdemo.DemoScreens
import com.example.jetpackdemo.R
import com.example.jetpackdemo.data.models.RegistrationReqModel
import com.example.jetpackdemo.data.remote.ApiResources
import com.example.jetpackdemo.ui.theme.Green
import com.example.jetpackdemo.ui.theme.PurplePrimary
import com.example.jetpackdemo.ui.theme.Red
import kotlinx.coroutines.withContext

@Composable
fun RegistrationScreen(navController: NavHostController?, registerViewModel: RegisterViewModel) {
    val coroutineScope = rememberCoroutineScope()

    val tag = "Register Screen"
    val showDialog = remember { mutableStateOf(false) }

    val registrationResponse by registerViewModel.mState.collectAsState()
    Log.e(tag, "RegisterScreen: Api status ${registrationResponse.status.name}")


    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,


        ) {
//        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Person Icon")


        Text(
            text = "Create Account ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif
        )

        Text(text = stringResource(R.string.lbl_msg_register),
            modifier = Modifier
                .clickable {
                    navController?.navigate(DemoScreens.LOGIN_SCREEN)
                }
                .padding(top = 10.dp),
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp)

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            placeholder = { Text(text = "Name") },
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            placeholder = { Text(text = "Email address") },
        )


        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
            ,
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            },
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            placeholder = { Text(text = stringResource(R.string.lbl_password)) },
        )

        Button(
            onClick = {
                registerViewModel.doRegistration(
                    RegistrationReqModel(
                        name = name, email = email, password = password
                    )
                )

            },
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = PurplePrimary, contentColor = Color.White
            )
        ) {
            Text(text = stringResource(R.string.lbl_sign_up))
        }

    }





    Log.e(tag, "RegisterScreen: Api status ${registrationResponse.status.name}")
    when (registrationResponse.status) {
        ApiResources.Status.LOADING -> {
            showDialog.value = true
        }
        ApiResources.Status.SUCCESS -> {
            showDialog.value = false


            navController?.navigate(DemoScreens.HOME_SCREEN)

            /*Snackbar(modifier = Modifier.padding(8.dp), backgroundColor = Green, action = {
                TextButton(onClick = { registerViewModel.dismissError() }) {
                    Text("Okay", color = Color.White)
                }
            }) {
                Text(registrationResponse.message ?: "", color = Color.White)
            }*/

        }
        ApiResources.Status.ERROR -> {
            showDialog.value = false
            Snackbar(modifier = Modifier.padding(8.dp), backgroundColor = Red, action = {
                TextButton(onClick = { registerViewModel.dismissError() }) {
                    Text("Dismiss", color = Color.White)
                }
            }) {
                Text(registrationResponse.message ?: "Unknown error occurred", color = Color.White)
            }
        }
        else -> {

        }
    }

    Log.e(tag, "RegisterScreen: Show dialog  status ${showDialog.value}")
    if (showDialog.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.White)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    RegistrationScreen(navController = null, registerViewModel = viewModel())
}
