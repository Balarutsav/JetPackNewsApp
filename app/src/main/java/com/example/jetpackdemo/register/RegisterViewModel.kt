package com.example.jetpackdemo.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackdemo.data.models.RegistrationReqModel
import com.example.jetpackdemo.data.remote.ApiResources
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.data.remote.dto.RegistrationDTO
import com.example.jetpackdemo.domain.RegistrationUseCase
import com.example.jetpackdemo.extensionFunction.checkIsEmpty
import com.example.jetpackdemo.extensionFunction.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase, val baseDataSource: BaseDataSource
) : ViewModel() {
    val TAG = "Registration ViewModel"

    private val state = MutableStateFlow<ApiResources<RegistrationDTO>>(ApiResources.unknown())
    val mState: StateFlow<ApiResources<RegistrationDTO>> get() = state


    fun doRegistration(registrationReqModel: RegistrationReqModel) {


        when {
            registrationReqModel.name.checkIsEmpty() -> {
                state.value = ApiResources.error("Please enter name")
                viewModelScope.launch {
                    delay(2000)
                    dismissError()
                }
                return
            }
            
            !registrationReqModel.email.isValidEmail() -> {
                state.value = ApiResources.error("please enter valid email")
                viewModelScope.launch {
                    delay(2000)
                    dismissError()
                }
                return

            }
            
            registrationReqModel.password.checkIsEmpty() -> {
                state.value = ApiResources.error("Please enter password")
                viewModelScope.launch {
                    delay(2000)
                    dismissError()
                }
                return
            }
            registrationReqModel.password.length<6 -> {
                state.value = ApiResources.error("Password at least 6 characters")
                viewModelScope.launch {
                    delay(2000)
                    dismissError()
                }
                return
            }

        }

        Log.e(TAG, "doRegistration: ")
        viewModelScope.launch {

            try {
                state.value = ApiResources.loading()
                val data = registrationUseCase.invoke(registrationReqModel)
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