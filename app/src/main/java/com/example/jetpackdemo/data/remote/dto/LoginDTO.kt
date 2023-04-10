package com.example.jetpackdemo.data.remote.dto


import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("data")
    val `data`: Data?=null
) : BaseDTO(){
    data class Data(
        @SerializedName("Email")
        val email: String,
        @SerializedName("Id")
        val id: Int,
        @SerializedName("Name")
        val name: String,
        @SerializedName("Token")
        val token: String
    )
}