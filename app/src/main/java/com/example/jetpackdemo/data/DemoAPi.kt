package com.example.jetpackdemo.data

import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.util.Constants
import retrofit2.Response
import retrofit2.http.GET


interface DemoAPi {

    @GET(Constants.LOGIN_END_POINT)
    suspend fun login(): Response<LoginModel>
}