package com.example.jetpackdemo.data

import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.util.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.GET
import retrofit2.http.POST


interface DemoAPi {

    @POST(Constants.LOGIN_END_POINT)
    suspend fun login(@FieldMap request: HashMap<String, String>): Response<LoginModel>
}