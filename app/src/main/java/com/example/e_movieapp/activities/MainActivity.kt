package com.example.e_movieapp.activities


import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.e_movieapp.R
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var welcomeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        welcomeTextView = findViewById(R.id.tvWelcome)

        val welcomeTextView = findViewById<TextView>(R.id.tvWelcome)

        welcomeTextView.setOnClickListener {

/*
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
*/

            welcomeTextView.movementMethod = LinkMovementMethod.getInstance();

        }
    }
}