package com.example.logintest.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logintest.model.User
import com.example.logintest.repository.AdminRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdminViewModel : ViewModel() {
    private val repository: AdminRepository = AdminRepository()
    val userData: MutableLiveData<User> = MutableLiveData()

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val userInfo: User = repository.getUser()
            userData.postValue(userInfo)
        }
    }

}