package com.example.logintest.model

import com.google.gson.annotations.SerializedName

data class Admin(
    @SerializedName("username") val username: String,
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("refreshToken") val refreshToken: String
)