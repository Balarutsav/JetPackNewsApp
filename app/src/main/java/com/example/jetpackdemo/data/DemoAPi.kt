package com.example.jetpackdemo.data

import com.example.jetpackdemo.data.models.LoginReqModel
import com.example.jetpackdemo.data.models.RegistrationReqModel
import com.example.jetpackdemo.data.remote.dto.LoginDTO
import com.example.jetpackdemo.data.remote.dto.RegistrationDTO
import com.example.jetpackdemo.util.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface DemoAPi {

    @POST(Constants.LOGIN_END_POINT)
    suspend fun login(@Body request: LoginReqModel): Response<LoginDTO>

    @POST(Constants.REGISTER_END_POINT)
    suspend fun register(@Body request: RegistrationReqModel): Response<RegistrationDTO>
}