package com.example.jetpackdemo.data

import com.example.jetpackdemo.data.models.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class DemoService @Inject constructor(private val demoApi: DemoAPi) {

    suspend fun login(): Response<LoginModel> {
        return demoApi.login()

    }


}