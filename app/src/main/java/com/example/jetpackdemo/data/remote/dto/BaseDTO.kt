package com.example.jetpackdemo.data.remote.dto

import com.example.jetpackdemo.data.models.LoginModel
import com.google.gson.annotations.SerializedName

open class BaseDTO(
    var code: Int=0,
    var message: String=""



)