package com.example.e_movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_movieapp.data.db.models.UserMovie


@Database(entities = [UserMovie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesdao(): MovieDao
}