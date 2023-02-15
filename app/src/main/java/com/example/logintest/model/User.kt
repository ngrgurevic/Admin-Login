package com.example.logintest.model

data class User(
    val id: Int,
    val name: String,
    val surname: String,
    val fullName: String,
    val roleId: Int,
    val imageId: Int,
    val address: String,
    val phoneNumber: String,
    val oib: String,
    val email: String,
    val statusId: Int,
    val accessLiburnija: Boolean,
    val accessParking: Boolean,
    val accessZadar: Boolean,
    val checked: Boolean,
    val status: Any?,
    val cards: List<Any>
)