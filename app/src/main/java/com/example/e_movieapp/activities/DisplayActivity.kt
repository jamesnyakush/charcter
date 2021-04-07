package com.example.e_movieapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.e_movieapp.*
import com.example.e_movieapp.data.MovieItemClickListener
import com.example.e_movieapp.data.UserMovie

class DisplayActivity : AppCompatActivity(),
    MovieItemClickListener {
//    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
//        database = Room.databaseBuilder(baseContext, AppDatabase::class.java, "DetailsDB.db").build()
//        fetchMovies()
    }

/*
    fun fetchMovies() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val moviesCall = apiClient.getMovies("Bearer " + accessToken)
        moviesCall.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                fetchMoviesFromDatabase()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    var MoviesList = response.body()?.movies as List<Movies>
                    Thread {
                       MoviesList.forEach { userMovie ->
                            database.MovieDao().insertMovies(userMovie)
                        }
                    }.start()

                    displayMovies(MoviesList)
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
*/

/*
    fun fetchCoursesFromDatabase(){
        Thread{
            val userMovie = database.MovieDao().getAllMovies()

            runOnUiThread {
                displayCourses(userMovie)
            }
        }.start()
    }
*/

/*
    fun displayCourses(courses: List<UserMovie>){
        var MovieAdapter = MovieAdapter(courses, this)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = MovieAdapter
    }
*/

    override fun onItemClick(userMovie: UserMovie) {
        //obtain student id from shared preferences
        //courseId = course.courseId
        //make a post request https://github.com/owuor91/registration-api
    }
}