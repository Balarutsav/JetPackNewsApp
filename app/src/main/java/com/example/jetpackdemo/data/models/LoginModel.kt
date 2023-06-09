package com.example.jetpackdemo.data.models


import com.google.gson.annotations.SerializedName

data class LoginModel(
    val code: Int,
    val `data`: Data,
    val message: String
) {
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