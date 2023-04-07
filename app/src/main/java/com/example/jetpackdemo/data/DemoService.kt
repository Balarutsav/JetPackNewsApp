package com.example.jetpackdemo.data

import com.example.jetpackdemo.data.models.LoginModel
import retrofit2.Response
import javax.inject.Inject


class DemoService @Inject constructor(private val demoApi: DemoAPi) {

    suspend fun login(request: HashMap<String, String>): Response<LoginModel> {
        return demoApi.login(request)

    }


}