package com.example.jetpackdemo.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackdemo.data.models.LoginReqModel
import com.example.jetpackdemo.data.remote.ApiResources
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.data.remote.dto.LoginDTO
import com.example.jetpackdemo.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase, val baseDataSource: BaseDataSource
) : ViewModel() {
    private val state = MutableStateFlow<ApiResources<LoginDTO>>(ApiResources.unknown())
    val mState: StateFlow<ApiResources<LoginDTO>> get() = state


    fun doLogin(loginReqModel: LoginReqModel) {

        Log.e("LoginViewModel", "doLogin: ")

        viewModelScope.launch {

            try {
                state.value = ApiResources.loading()
                val data = loginUseCase.invoke(loginReqModel)
                state.value = baseDataSource.getResult { data }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

    fun dismissError() {
        state.value = ApiResources.unknown()
    }


}