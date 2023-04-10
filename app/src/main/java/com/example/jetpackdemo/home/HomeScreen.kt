package com.example.jetpackdemo.home

import android.app.Activity
import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.jetpackdemo.ui.theme.Purple200
import com.example.jetpackdemo.ui.theme.Purple500
import com.example.jetpackdemo.ui.theme.Purple700
import com.example.jetpackdemo.ui.theme.PurplePrimary


@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    val context = LocalContext.current
    val statusBarColor = Purple500

    SideEffect {
        val window: Window = (context as Activity).window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = statusBarColor.toArgb()
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Demo App") }) },
        bottomBar = {
        },
        floatingActionButton = {
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Welcome to home screen")

        }
    }
}