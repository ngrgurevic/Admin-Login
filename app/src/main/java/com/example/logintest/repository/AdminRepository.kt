package com.example.logintest.repository

import AdminApiService
import com.example.logintest.model.AdminData
import com.example.logintest.model.User

class AdminRepository() {
    private var apiKey = "f5a14a7f-6460-4b28-8e7c-e3b95725689d"
    private var email = "info@mediatorium.co"
    private var password = "info123"

    private val client: AdminApiService = AdminApiService.client

    suspend fun getAdminToken(): String {
        val response = client.loginAdmin(AdminData(apiKey, email, password))
        val admin = response.body() ?: throw Exception("Token failed to recieve")
        return admin.accessToken
    }

    suspend fun getUser(): User {
        val token = getAdminToken()
        val response = client.getUserData("Bearer $token")
        val user = response.body() ?: throw Exception("Getting userData failed")
        return user
    }
}
