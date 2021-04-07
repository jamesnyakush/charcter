package com.example.e_movieapp.ui.auth.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_movieapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Auth : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
    }
}