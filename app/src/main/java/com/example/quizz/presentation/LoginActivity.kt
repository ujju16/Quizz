package com.example.quizz.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.PersistableBundle
import android.view.LayoutInflater
import com.example.quizz.databinding.LoginActivityBinding
import com.example.quizz.R

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = LoginActivityBinding.inflate(layoutInflater)
    }
}