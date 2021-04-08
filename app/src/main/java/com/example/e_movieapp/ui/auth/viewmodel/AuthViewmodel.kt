package com.example.e_movieapp.ui.auth.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_movieapp.data.db.models.UserData
import com.example.e_movieapp.data.repository.AuthRepository
import com.example.e_movieapp.utils.EmptyResource
import com.example.e_movieapp.utils.logError


class AuthViewModel @ViewModelInject constructor(
    private val repository: AuthRepository
) : ViewModel() {


    val loginResult by lazy {
        MutableLiveData<EmptyResource>()
    }

    val signUpResult by lazy {
        MutableLiveData<EmptyResource>()
    }

    val resetResult by lazy {
        MutableLiveData<EmptyResource>()
    }

    fun login(email: String, password: String) {
        loginResult.value = EmptyResource.loading()

        repository.signInWithNicknameAndPassword(email, password)
            .addOnSuccessListener {
                UserData.email = email
                loginResult.value = EmptyResource.success()
            }
            .addOnFailureListener {
                loginResult.value = EmptyResource.error(it)
            }
    }

    fun reset(email: String) {
        resetResult.value = EmptyResource.loading()

        repository.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                UserData.email = email
                resetResult.value = EmptyResource.success()
            }
            .addOnFailureListener {
                resetResult.value = EmptyResource.error(it)
            }


/*
signInWithNicknameAndPassword(email, password)
            .addOnSuccessListener {
                UserData.email = email
                loginResult.value = EmptyResource.success()
            }
            .addOnFailureListener {
                loginResult.value = EmptyResource.error(it)
            }
            */
    }


    fun register(
        email: String,
        password: String
    ) {
        signUpResult.value = EmptyResource.loading()

        repository.createUserWithNicknameAndPassword(email, password)
            .addOnSuccessListener {
                signUpResult.value = EmptyResource.success()
            }
            .addOnFailureListener {
                onSignupError(it)
            }
    }

    private fun onSignupError(exception: Exception? = null) {
        "Signup Error: $exception".logError()
        repository.signOut()
        signUpResult.value = EmptyResource.error(exception)
    }
}