package com.example.logintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.logintest.viewModel.AdminViewModel

class MainActivity : AppCompatActivity() {
    private val adminViewModel: AdminViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logInButton: Button = findViewById(R.id.loginButton)
        val emailTextField: EditText = findViewById(R.id.emailFieldID)
        val passwordTextField: EditText = findViewById(R.id.passwordFieldID)

        logInButton.setOnClickListener {
            val email = emailTextField.text.toString()
            val password = passwordTextField.text.toString()
            adminViewModel.userData.observe(this) { data ->

                if (email == data.email && password.equals("info123")) {
                    val intent = Intent(this, UserProfile::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}