package com.example.e_movieapp.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.e_movieapp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var confirmPasswordEt:EditText

    private lateinit var signUpBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = FirebaseAuth.getInstance()

        emailEt = findViewById(R.id.edEmail)
        passwordEt = findViewById(R.id.edPassword)
        confirmPasswordEt=findViewById(R.id.etConfirmpassword)

        signUpBtn = findViewById(R.id.btnSignup)

        signUpBtn.setOnClickListener{
            val intent = Intent(this@RegisterActivity, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }

        signUpBtn.setOnClickListener{
            var email: String = emailEt.text.toString()
            var password: String = passwordEt.text.toString()
            var confirmPassword:String=confirmPasswordEt.text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this@RegisterActivity, "Both password fields must be identical",Toast.LENGTH_LONG).show();
            }

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)||TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(this@RegisterActivity, "Please fill all the fields", Toast.LENGTH_LONG).show()
            } else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this@RegisterActivity, OnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this@RegisterActivity, "Successfully Registered", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@RegisterActivity, IntroActivity::class.java)
                        startActivity(intent)
                    }else {
                        Toast.makeText(this@RegisterActivity, "Registration Failed", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }
}

//    lateinit var edFirstName: EditText
//    lateinit var edLastName: EditText
//    lateinit var edPassword: EditText
//    lateinit var editTextEmail: EditText
//    lateinit var editTextTextPassword2: EditText
//    var MIN_PASSWORD_LENGTH = 6;
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_registration)
//
//        val btnSignup =findViewById<Button>(R.id.btnSignup)
//        btnSignup.setOnClickListener {
//            startActivity(Intent(this@RegisterActivity, RegisterMovie::class.java))
//            finish()
//        }
//        viewInitializations()
//        validateInput()
//        performSignUp()
//
//    }
//
//    fun viewInitializations() {
//        edFirstName = findViewById(R.id.edFirstName)
//        edLastName = findViewById(R.id.edLastName)
//        editTextEmail= findViewById(R.id.edEmail)
//        edPassword = findViewById(R.id.edPassword)
//        editTextTextPassword2= findViewById(R.id.editTextTextPassword2)
//
//        // To show back button in actionbar
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//    }
//
//    // Checking if the input in form is valid
//    fun validateInput(): Boolean {
//
//        if (edFirstName.text.toString().equals("")) {
//            edFirstName.setError("Please Enter First Name")
//            return false
//        }
//        if (edLastName.text.toString().equals("")) {
//            edLastName.setError("Please Enter Last Name")
//            return false
//        }
//        if (editTextEmail.text.toString().equals("")) {
//            editTextEmail.setError("Please Enter Email")
//            return false
//        }
//        if (edPassword.text.toString().equals("")) {
//          edPassword.setError("Please Enter Password")
//            return false
//        }
//        if (editTextTextPassword2.text.toString().equals("")) {
//            editTextTextPassword2.setError("Please Enter Repeat Password")
//            return false
//        }
//
//        // checking the proper email format
//        if (!isEmailValid(editTextEmail.text.toString())) {
//            editTextEmail.setError("Please Enter Valid Email")
//            return false
//        }
//        // checking minimum password Length
//        if (edPassword.text.length < MIN_PASSWORD_LENGTH) {
//            edPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters")
//            return false
//        }
//
//        // Checking if repeat password is same
//        if (!edPassword.text.toString().equals(editTextTextPassword2.text.toString())) {
//            editTextTextPassword2.setError("Password does not match")
//            return false
//        }
//        return true
//    }
////    fun isEmailValid(email: String): Boolean {
////        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
////    }
//    fun isEmailValid(username: String): Boolean {
//        return if (username.contains("@")) {
//            Patterns.EMAIL_ADDRESS.matcher(username).matches()
//        } else {
//            username.isNotBlank()
//        }
//    }
//
//    // Hook Click Event
//
//    fun performSignUp () {
//        if (validateInput()) {
//
//            // Input is valid, here send data to your server
//
//           val firstName= edFirstName.text.toString()
//            val LastName = edLastName.text.toString()
//            val email = editTextEmail.text.toString()
//            val Password = edPassword.text.toString()
//            val confirmpassword = editTextTextPassword2.text.toString()
//
//            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
//
//        }
//    }


