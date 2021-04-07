@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.example.e_movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.e_movieapp.data.UserMovie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(userMovie: UserMovie)

    @Query("SELECT * FROM UserMovie")
    fun getAllMovies(): List<UserMovie>
}