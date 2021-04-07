package com.example.e_movieapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {


    /* Register */
    fun createUserWithNicknameAndPassword(email: String, password: String) =
        firebaseAuth.createUserWithEmailAndPassword(email, password)

    /* Login */
    fun signInWithNicknameAndPassword(email: String, password: String) =
        firebaseAuth.signInWithEmailAndPassword(email, password)

    /* Sign out */
    fun signOut() = firebaseAuth.signOut()

    /* User */
    fun getCurrentUser() = firebaseAuth.currentUser

    fun sendPasswordResetEmail(email: String) =
        firebaseAuth.sendPasswordResetEmail(email)
}