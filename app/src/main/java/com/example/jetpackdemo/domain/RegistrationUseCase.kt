package com.example.jetpackdemo.domain

import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.data.models.LoginReqModel
import com.example.jetpackdemo.data.models.RegistrationReqModel
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.data.remote.dto.LoginDTO
import com.example.jetpackdemo.data.remote.dto.RegistrationDTO
import com.example.jetpackdemo.repo.DemoRepository
import retrofit2.Response
import javax.inject.Inject


class RegistrationUseCase @Inject constructor(
    private val demoRepository: DemoRepository, private val baseDataSource: BaseDataSource
) {
    val TAG = "LoginUseCase"
    suspend fun invoke(request: RegistrationReqModel): Response<RegistrationDTO> =
        demoRepository.doRegistration(request)


}