package com.example.jetpackdemo.domain

import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.data.remote.ApiResources
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.repo.DemoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val demoRepository: DemoRepository,  private val baseDataSource: BaseDataSource) {

     operator fun invoke(request: HashMap<String, String>): Flow<ApiResources<LoginModel>> = flow {
        try {
            emit(ApiResources.loading())
            val loginResponse = demoRepository.doLogin(request)
            val data = baseDataSource.getResult { loginResponse }
            emit(data)
        } catch (e: HttpException) {
            emit(ApiResources.error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(ApiResources.error("Couldn't reach server. Check your internet connection."))
        }
    }

}