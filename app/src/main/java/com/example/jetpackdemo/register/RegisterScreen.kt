package com.example.jetpackdemo.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun RegistrationScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Welcome to register")
    }

}