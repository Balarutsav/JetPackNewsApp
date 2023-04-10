package com.example.jetpackdemo.repo

import com.example.jetpackdemo.data.DemoService
import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.data.models.LoginReqModel
import com.example.jetpackdemo.data.models.RegistrationReqModel
import com.example.jetpackdemo.data.remote.dto.LoginDTO
import com.example.jetpackdemo.data.remote.dto.RegistrationDTO
import retrofit2.Response
import javax.inject.Inject


class DemoRepository @Inject constructor(private val demoService: DemoService) {

    suspend fun doLogin(request: LoginReqModel): Response<LoginDTO> {
        return demoService.login(request)
    }

    suspend fun doRegistration(request: RegistrationReqModel):Response<RegistrationDTO>{
        return demoService.register(request)
    }
}