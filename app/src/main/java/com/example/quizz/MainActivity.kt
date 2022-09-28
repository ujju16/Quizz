package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.quizz.presentation.QuizzFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.fragment_container, QuizzFragment())
            .addToBackStack(null)
        fragmentTransaction.commit()
    }
}