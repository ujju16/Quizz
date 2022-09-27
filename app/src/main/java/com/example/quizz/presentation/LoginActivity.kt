package com.example.quizz.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizz.MainActivity
import com.example.quizz.databinding.LoginActivityBinding
import com.example.quizz.R

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = LoginActivityBinding.inflate(layoutInflater)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        loginViewModel.loginResult.observe(this, Observer { processLogin(it) })

        binding.validate?.setOnClickListener() {
            loginViewModel.login(
                binding.username.text.toString(),
                binding.password.text.toString()
            )
        }
    }

    private fun processLogin(isLoginOk: Boolean) {
        if (isLoginOk) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Mauvais identifiant", Toast.LENGTH_LONG).show()
        }
    }

}