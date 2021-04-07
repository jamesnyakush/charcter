package com.example.e_movieapp.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.e_movieapp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var edLoginEmail: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var tvRegister:TextView
    private lateinit var tvforgot: TextView

    private lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       edLoginEmail = findViewById(R.id.edLoginEmail)
       etLoginPassword = findViewById(R.id.etLoginPassword)

        tvRegister = findViewById(R.id.tvRegister)
        btnLogin = findViewById(R.id.btnLogin)

        tvforgot= findViewById(R.id.tvForgotPassword)

        auth = FirebaseAuth.getInstance()

        tvRegister.setOnClickListener {

            val myIntent = Intent(this, RegisterActivity::class.java)
            startActivity(myIntent)

          tvRegister.movementMethod = LinkMovementMethod.getInstance();

        }

        tvforgot.setOnClickListener {

            val myIntent = Intent(this, ForgotPassword::class.java)
            startActivity(myIntent)

            tvforgot.movementMethod = LinkMovementMethod.getInstance();

        }
        btnLogin.setOnClickListener {
            var email: String = edLoginEmail.text.toString()
            var password: String = etLoginPassword.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this@LoginActivity, "Please fill all the fields", Toast.LENGTH_LONG).show()
            } else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this@LoginActivity, OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this@LoginActivity, "Successfully Logged In", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@LoginActivity, SplashActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }

    }
}