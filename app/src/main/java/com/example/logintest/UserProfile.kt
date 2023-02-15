package com.example.logintest

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.logintest.databinding.ActivityMainBinding

import com.example.logintest.viewModel.AdminViewModel

class UserProfile : AppCompatActivity() {
    private val adminViewModel: AdminViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val logoutButton: Button = findViewById(R.id.logoutButton)
        adminViewModel.userData.observe(this) { data ->
            val nameTextView: TextView = findViewById(R.id.name)
            val surnameTextView: TextView = findViewById(R.id.surname)
            val fullNameTextView: TextView = findViewById(R.id.fullName)
            val addressTextView: TextView = findViewById(R.id.address)
            val phoneNumberTextView: TextView = findViewById(R.id.phoneNumber)
            val oibTextView: TextView = findViewById(R.id.oib)
            val emailTextView: TextView = findViewById(R.id.email)
            val imageIdView: TextView = findViewById(R.id.imageId)
            val roleIdView: TextView = findViewById(R.id.roleId)
            val accessLiburnijaView: TextView = findViewById(R.id.accessLiburnija)
            val accessParkingView: TextView = findViewById(R.id.accessParking)
            val accessZadarView: TextView = findViewById(R.id.accessZadar)
            val checked: TextView = findViewById(R.id.checked)

            nameTextView.text = data.name
            surnameTextView.text = data.surname
            fullNameTextView.text = data.fullName
            addressTextView.text = data.address
            phoneNumberTextView.text = data.phoneNumber
            oibTextView.text = data.oib
            emailTextView.text = data.email
            imageIdView.text = "Img ID: " + data.imageId.toString()
            roleIdView.text = "RoleID: " + data.roleId.toString()
            accessLiburnijaView.text = "Access Liburnija: " + data.accessLiburnija.toString()
            accessParkingView.text = "Access Parking: " + data.accessParking.toString()
            accessZadarView.text = "Access Zadar: " + data.accessZadar.toString()
            checked.text = data.checked.toString()
        }

        logoutButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}