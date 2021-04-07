package com.example.e_movieapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.e_movieapp.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

class RegisterMovie : AppCompatActivity() {
    private lateinit var btnSave: Button
    private lateinit var edTitle: TextView
    private lateinit var edActors: TextView
    private lateinit var edDirector: TextView
    private lateinit var edRate: TextView
    private lateinit var edReview: TextView
    private lateinit var edYear: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_movie)

        btnSave.setOnClickListener {
            var title = edTitle.text.toString()
            var year = edYear.text.toString()
            val director = edDirector.text.toString()
            val rate = edRate.text.toString()
            val review = edReview.text.toString()
            val actors = edActors.text.toString()

            var requestBody = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("title", title)
                    .addFormDataPart("year", year)
                    .addFormDataPart("director", director)
                    .addFormDataPart("rate", rate)
                    .addFormDataPart("review", review)
                    .addFormDataPart("actors", actors)
                    .build()

//            registerMovies(requestBody)
            Toast.makeText(baseContext, "added to databases", Toast.LENGTH_SHORT).show()
        }
    }
}


/*
    fun registerMovies(requestBody: RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var moviesCall = apiClient.registerMovies(requestBody).also {
            moviesCall.enqueue(object : Callback {
               override fun onFailure(call: Call, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
               private fun onResponse(call: Call, response: Response<MovieResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        startActivity(Intent(baseContext, DisplayActivity::class.java))
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }


    }}
*/


//    private lateinit var button: Button
//    private lateinit var edTitle: EditText
//    private lateinit var edYear: EditText
//    private lateinit var edDirector: EditText
//    private lateinit var edActors: EditText
//    private lateinit var edRate: EditText
//    private lateinit var edReview: EditText
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register_movie)
//
//        button = findViewById(R.id.btnSave)
//        edTitle = findViewById(R.id.edTitle)
//        edYear = findViewById(R.id.edYear)
//        edActors = findViewById(R.id.edActers)
//        edDirector = findViewById(R.id.edDirector)
//        edRate = findViewById(R.id.edratings)
//        edReview = findViewById(R.id.edReview)
//
//        button.setOnClickListener {
//            val dbHandler = DatabaseHandler(this, null)
//            var Title: String = edTitle.text.toString()
//            var Year:String=edYear.text.toString()
//            var Director: String =edDirector.text.toString()
//            var Actors: String = edActors.text.toString()
//            var Rate: String =edRate.text.toString()
//            var Review: String = edReview.text.toString()
//            dbHandler.addDetails(Title,Year,Director,Actors,Rate,Review)
//            val cursor = dbHandler.getAllDetails()
//            cursor!!.moveToFirst()
//            Toast.makeText(this@RegisterMovie, "Added to database", Toast.LENGTH_LONG).show()
//            val intent = Intent(this@RegisterMovie, DisplayActivity::class.java)
//            startActivity(intent)
//        }
//
//    }}
//    private lateinit var sqLiteDatabaseObj: SQLiteDatabase
//    private lateinit var editTextName: EditText
//    private lateinit var editTextN:EditText
//    private lateinit var button: Button
//    private lateinit var editTextRate:EditText
//    private lateinit var editTextDir: EditText
//    private lateinit var editTextRev: EditText
//    var EditTextEmptyHold:Boolean = false
//    lateinit var SQLiteDataBaseQueryHolder:String
//    lateinit var NameHolder:String
//    lateinit var NameHolder1:String
//    lateinit var NameHolder2:String
//    lateinit var NameHolder3:String
//    lateinit var NameHolder4:String
//    lateinit var NameHolder5:String

//        button=findViewById(R.id.btnSave);
//        editTextName =findViewById(R.id.edTitle);
//        editText=findViewById(R.id.edYear)
//        editTextN=findViewById(R.id.edActers)
//        editTextDir = findViewById(R.id.edDirector);
//        editTextRev=findViewById(R.id.edReview)
//        editTextRate=findViewById(R.id.edratings)
//
//
//        button.setOnClickListener {
//            val dbHandler = DatabaseHandler(this, null)
//            val details = Title(editText.text.toString())
//            dbHandler.addDetails(details)
//            Toast.makeText(this, etName.text.toString() + "Added to database", Toast.LENGTH_LONG).show()
//        }
//
//        button.setOnClickListener( View.OnClickListener() {
//
//
//                SQLiteDataBaseBuild();
//
//                SQLiteTableBuild();
//
//                CheckEditTextStatus();
//
//                InsertDataIntoSQLiteDatabase();
//
//                EmptyEditTextAfterDataInsert();
//
//
//            })
//
//
//    }
//
//   fun SQLiteDataBaseBuild(){
//
//        sqLiteDatabaseObj = openOrCreateDatabase("AndroidJSonDataBase", Context.MODE_PRIVATE, null);
//
//    }
//
// fun  SQLiteTableBuild(){
//
//        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS AndroidJSonTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Title VARCHAR, Year INTEGER,Director VARCHAR,Actors VARCHAR,Rate INTEGER,Review VARCHAR);");
//
//    }
//
//    fun  CheckEditTextStatus(){
//
//        var NameHolder = editTextName.getText().toString();
//        var NameHolder1 = editText.getText().toString();
//        var NameHolder2 = editTextN.getText().toString();
//        var NameHolder3 = editTextDir.getText().toString();
//        var NameHolder4 = editTextRev.getText().toString();
//        var NameHolder5=editTextRate.getText().toString()
//
//
//
//        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(NameHolder1) || TextUtils.isEmpty(NameHolder2)||TextUtils.isEmpty(NameHolder3)||TextUtils.isEmpty(NameHolder4)||TextUtils.isEmpty(NameHolder5)){
//
//            EditTextEmptyHold = false ;
//
//        }
//        else {
//
//            EditTextEmptyHold = true ;
//        }
//    }
//
//    fun InsertDataIntoSQLiteDatabase(){
//
//        if(EditTextEmptyHold == true)
//        {
//
//            SQLiteDataBaseQueryHolder = "INSERT INTO AndroidJSonTable (Title,Year,Director,Actors, Rate,Review,) VALUES('"+NameHolder+"', '"+NameHolder1+"', '"+NameHolder2+"', '"+NameHolder3+"', '"+NameHolder4+"', '"+NameHolder5+"');";
//
//            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
//
//            Toast.makeText(this@RegisterMovie,"Data Inserted Successfully", Toast.LENGTH_LONG).show();
//            val intent = Intent(this@RegisterMovie, DisplayActivity::class.java)
//            startActivity(intent)
//        }
//        else {
//
//            Toast.makeText(this@RegisterMovie,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
//
//        }
//
//    }
//
//   fun EmptyEditTextAfterDataInsert(){
//
//        editTextName.getText().clear();
//        editTextDir.getText().clear();
//       editTextN.getText().clear();
//       editTextRev.getText().clear();
//       editText.getText().clear();
//       editTextRate.getText().clear();
//
//    }
//
//}
//

