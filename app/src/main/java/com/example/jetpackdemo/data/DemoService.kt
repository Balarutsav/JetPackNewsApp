package com.example.jetpackdemo.data

import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.data.models.LoginReqModel
import com.example.jetpackdemo.data.models.RegistrationReqModel
import com.example.jetpackdemo.data.remote.dto.LoginDTO
import com.example.jetpackdemo.data.remote.dto.RegistrationDTO
import retrofit2.Response
import javax.inject.Inject


class DemoService @Inject constructor(private val demoApi: DemoAPi) {

    suspend fun login(loginReqModel: LoginReqModel): Response<LoginDTO> {


        return demoApi.login(loginReqModel)

    }

   suspend fun register(request: RegistrationReqModel): Response<RegistrationDTO> {
        return  demoApi.register(request)
    }


}