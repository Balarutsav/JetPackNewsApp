package com.example.jetpackdemo.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackdemo.data.models.LoginModel
import com.example.jetpackdemo.data.remote.ApiResources
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    val baseDataSource: BaseDataSource
) : ViewModel() {
    private val state = MutableStateFlow<ApiResources<LoginModel>>(ApiResources.unknown())
    val mState: StateFlow<ApiResources<LoginModel>> get() = state


    fun doLogin() {

        Log.e("LoginViewModel", "doLogin: ")

        viewModelScope.launch {

            try {
                val requestMap: HashMap<String, String> = hashMapOf()
                requestMap["email"] = "Developer5@gmail.com"
                requestMap["password"] = "123456"
                state.value = ApiResources.loading()
                val data = loginUseCase.invoke(requestMap)
                state.value = baseDataSource.getResult { data }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }


}