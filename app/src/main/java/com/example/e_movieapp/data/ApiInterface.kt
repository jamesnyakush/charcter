package com.example.e_movieapp.data

import okhttp3.Call
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("register")
    fun registerMovies(@Body requestBody: RequestBody): Call


    @GET("courses")
    fun getMovies(@Header("Authorization") accessToken: String): Call
}