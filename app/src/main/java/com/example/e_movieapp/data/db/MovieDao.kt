@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.example.e_movieapp.data.db

import androidx.room.*
import com.example.e_movieapp.data.db.models.UserMovie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(userMovie: UserMovie)

    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<UserMovie>


    @Query("SELECT * FROM movies WHERE isFavourite= true")
    suspend fun getFavourites(): List<UserMovie>


    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMovie(userMovie: UserMovie)
}