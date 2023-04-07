package com.example.jetpackdemo.repo

import com.example.jetpackdemo.data.DemoService
import com.example.jetpackdemo.data.models.LoginModel
import retrofit2.Response
import javax.inject.Inject


class DemoRepository @Inject constructor(private val demoService: DemoService) {

    suspend fun doLogin(request: HashMap<String, String>): Response<LoginModel> {
        return demoService.login(request)
    }
}