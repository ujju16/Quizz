package com.example.quizz.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    val loginResult: MutableLiveData<Boolean> = MutableLiveData()

    fun login(username: String, password: String) {
        if (username.equals("ujju16") && password.equals("u0j9j1u2")) {
            loginResult.postValue(true)
        }
        else {
            loginResult.postValue(false)
        }
    }
}