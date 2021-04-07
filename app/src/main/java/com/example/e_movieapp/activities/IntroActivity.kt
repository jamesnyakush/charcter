package com.example.e_movieapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.e_movieapp.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btnRegisterMovie = findViewById<Button>(R.id.btnRegisterMovie)
        btnRegisterMovie.setOnClickListener {
            startActivity(Intent(this@IntroActivity, RegisterMovie::class.java))
        }

        val btnDisplayMovies = findViewById<Button>(R.id.btnDisplayMovies)
        btnDisplayMovies.setOnClickListener {
            startActivity(Intent(this@IntroActivity, DisplayActivity::class.java))

        }

    }
}