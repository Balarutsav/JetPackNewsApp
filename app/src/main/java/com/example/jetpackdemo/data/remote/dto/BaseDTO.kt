package com.example.jetpackdemo.data.remote.dto

import com.google.gson.annotations.SerializedName

open class BaseDTO(
    @SerializedName("status")
    var status: Boolean=false,

    @SerializedName("message")
    var message: String="",


    @SerializedName("error")
var error: String=""

)