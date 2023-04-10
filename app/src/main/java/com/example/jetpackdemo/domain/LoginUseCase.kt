package com.example.jetpackdemo.domain

import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.data.models.LoginReqModel
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.data.remote.dto.LoginDTO
import com.example.jetpackdemo.repo.DemoRepository
import retrofit2.Response
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val demoRepository: DemoRepository, private val baseDataSource: BaseDataSource
) {
    val TAG = "LoginUseCase"
    suspend fun invoke(request: LoginReqModel): Response<LoginDTO> =
        demoRepository.doLogin(request)


}