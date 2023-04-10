package com.example.jetpackdemo

import android.app.Activity
import android.view.Window
import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackdemo.home.HomeScreen
import com.example.jetpackdemo.home.HomeViewModel
import com.example.jetpackdemo.login.LoginScreen
import com.example.jetpackdemo.login.LoginViewModel
import com.example.jetpackdemo.register.RegisterViewModel
import com.example.jetpackdemo.register.RegistrationScreen

@Composable
fun NavigationGraph(navController: NavHostController , loginViewModel: LoginViewModel,registrationViewModel:RegisterViewModel,homeViewModel: HomeViewModel) {
    val context = LocalContext.current
    val statusBarColor = Color.White

    SideEffect {
        val window: Window = (context as Activity).window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = statusBarColor.toArgb()
    }
    NavHost(
        navController = navController, startDestination = DemoScreens.LOGIN_SCREEN
    ) {
        composable(DemoScreens.LOGIN_SCREEN) {
            LoginScreen(navController,loginViewModel)
        }
        composable(DemoScreens.REGISTER_SCREEN) {
            RegistrationScreen(navController, registrationViewModel)
        }
        composable(DemoScreens.HOME_SCREEN){
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
        }
    }
}