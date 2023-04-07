package com.example.jetpackdemo.domain

import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.repo.DemoRepository
import retrofit2.Response
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val demoRepository: DemoRepository, private val baseDataSource: BaseDataSource
) {
    val TAG = "LoginUseCase"
    suspend fun invoke(request: HashMap<String, String>): Response<LoginModel> =
        demoRepository.doLogin(request)


}