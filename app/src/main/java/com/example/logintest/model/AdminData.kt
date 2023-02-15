package com.example.logintest.model

import com.google.gson.annotations.SerializedName

data class AdminData(
    @SerializedName("appId") val apiKey: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)