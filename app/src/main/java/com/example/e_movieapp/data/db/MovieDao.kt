@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.example.e_movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(userMovie: UserMovie)

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<UserMovie>
}