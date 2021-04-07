package com.example.e_movieapp.data

//class DatabaseHandler(context: Context, factory: SQLiteDatabase.CursorFactory?) :
//        SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
//
//
//    override fun onCreate(db: SQLiteDatabase) {
//        val CREATE_MOVIE_TABLE = ("CREATE TABLE " + TABLE_DETAILS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_TITLE + " TEXT," + COLUMN_YEAR + " INTEGER," + COLUMN_RATE + "INTEGER," + COLUMN_REVIEW + "TEXT," + COLUMN_DIRECTOR + "TEXT," + "" + COLUMN_ACTORS + "TEXT" + ")")
//        db.execSQL(CREATE_MOVIE_TABLE)
//
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
//                           newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAILS)
//        onCreate(db)
//    }
//
//    fun addDetails(details: String, year: String, director: String, actors: String, rate: String, review: String) {
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(COLUMN_TITLE, details)
//        values.put(COLUMN_DIRECTOR, year)
//        values.put(COLUMN_ACTORS, director)
//        values.put(COLUMN_RATE, actors)
//        values.put(COLUMN_REVIEW, rate)
//        values.put(COLUMN_YEAR,review)
//        db.insert(TABLE_DETAILS, null, values)
//        db.close()
//    }
//
//    fun findDetails(Title: String, Director: String, Actors: String, Year: Int, Rate: Int, Review: String):UserMovie? {
//        val query =
//                "SELECT * FROM $TABLE_DETAILS WHERE $COLUMN_TITLE $COLUMN_ACTORS $COLUMN_DIRECTOR  $COLUMN_RATE $COLUMN_REVIEW  $COLUMN_YEAR=" + "  \"$Title\", \"$Actors\" ,\"$Director\" \"$Rate\" \"$Review\" \"$Year\""
//
//        val db = this.writableDatabase
//
//        val cursor = db.rawQuery(query, null)
//
//        var details: UserMovie? = null
//
//        if (cursor.moveToFirst()) {
//            cursor.moveToFirst()
//
//            val title = cursor.getString(1)
//            val actors = cursor.getString(2)
//            val director = cursor.getString(3)
//            val rate = Integer.parseInt(cursor.getString(4))
//            val review = cursor.getString(5)
//            val year = Integer.parseInt(cursor.getString(6))
//            details =
//                title,
//                actors,
//                director,
//                rate,
//                year,
//                review
//            )
//            cursor.close()
//        }
//        db.close()
//        return details
//    }
//
//    fun getAllMovies(): Cursor? {
//        val db = this.readableDatabase
//        return db.rawQuery("SELECT * FROM $TABLE_DETAILS", null)
//    }
//
//
//    companion object {
//
//        private val DATABASE_VERSION = 1
//        private val DATABASE_NAME = "DetailsDB.db"
//        val TABLE_DETAILS = "Details"
//        val COLUMN_ID = "id"
//        val COLUMN_TITLE = "title"
//        val COLUMN_RATE = "rate"
//        val COLUMN_REVIEW = "review"
//        val COLUMN_YEAR = "year"
//        val COLUMN_DIRECTOR = "director"
//        val COLUMN_ACTORS = "actors"
//
//
//    }
//}


//     fun getAllDetails(): ArrayList<String>? {
//        val array_list = ArrayList<String>()
//
//        val db = this.readableDatabase
//        val res: Cursor = db.rawQuery("select * from Details", null)
//        res.moveToFirst()
//        while (res.isAfterLast() === false) {
//            array_list.add(res.getString(res.getColumnIndex(TABLE_DETAILS)))
//            res.moveToNext()
//        }
//        return array_list
//    }


//
//    val COLUMN_LAST_NAME: String,
//    val COLUMN_FIRST_NAME: String
//) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//    // create table sql query
//    private val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
//            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " TEXT,"+ COLUMN_LAST_NAME+"TEXT,"
//            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")
//    // drop table sql query
//    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_USER"
//    override fun onCreate(db: SQLiteDatabase) {
//        db.execSQL(CREATE_USER_TABLE)
//    }
//    private val databaseOpenHelper: DatabaseHandler
//
//
//    companion object {
//        // Database Version
//        private val DATABASE_VERSION = 1
//        // Database Name
//        private val DATABASE_NAME = "UserManager.db"
//        // User table name
//        private val TABLE_USER = "user"
//        // User Table Columns names
//        private val COLUMN_USER_ID = "user_id"
//        private val COLUMN_USER_NAME = "user_name"
//        private val COLUMN_USER_EMAIL = "user_email"
//        private val COLUMN_USER_PASSWORD = "user_password"
//    }
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        //Drop User Table if exist
//        db.execSQL(DROP_USER_TABLE)
//        // Create tables again
//        onCreate(db)
//    }
//
//    fun addUser(user: User) {
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(COLUMN_FIRST_NAME, user.password)
//        values.put(COLUMN_LAST_NAME, user.Lastname)
//        values.put(COLUMN_USER_EMAIL, user.email)
//        values.put(COLUMN_USER_PASSWORD, user.password)
//        // Inserting Row
//        db.insert(TABLE_USER, null, values)
//        db.close()
//    }
//    /**
//     * This method to update user record
//     *
//     * @param user
//     */
//    fun updateUser(user: User) {
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(COLUMN_USER_NAME, user.Firstname)
//        values.put(COLUMN_USER_EMAIL, user.email)
//        values.put(COLUMN_USER_PASSWORD, user.password)
//        // updating row
//        db.update(TABLE_USER, values, "$COLUMN_USER_ID = ?",
//                arrayOf(user.password.toString()))
//        db.close()
//    }
//    /**
//     * This method is to delete user record
//     *
//     * @param user
//     */
//    fun deleteUser(user: User) {
//        val db = this.writableDatabase
//        // delete user record by id
//        db.delete(TABLE_USER, "$COLUMN_USER_ID = ?",
//                arrayOf(user.password.toString()))
//        db.close()
//    }
//    /**
//     * This method to check user exist or not
//     *
//     * @param email
//     * @return true/false
//     */
//    fun checkUser(email: String): Boolean {
//        // array of columns to fetch
//        val columns = arrayOf(COLUMN_USER_ID)
//        val db = this.readableDatabase
//        // selection criteria
//        val selection = "$COLUMN_USER_EMAIL = ?"
//        // selection argument
//        val selectionArgs = arrayOf(email)
//        // query user table with condition
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
//         */
//        val cursor = db.query(TABLE_USER, //Table to query
//                columns,        //columns to return
//                selection,      //columns for the WHERE clause
//                selectionArgs,  //The values for the WHERE clause
//                null,  //group the rows
//                null,   //filter by row groups
//                null)  //The sort order
//        val cursorCount = cursor.count
//        cursor.close()
//        db.close()
//        if (cursorCount > 0) {
//            return true
//        }
//        return false
//    }
//    /**
//     * This method to check user exist or not
//     *
//     * @param email
//     * @param password
//     * @return true/false
//     */
//    fun checkUser(email: String, password: String): Boolean {
//        // array of columns to fetch
//        val columns = arrayOf(COLUMN_USER_ID)
//        val db = this.readableDatabase
//        // selection criteria
//        val selection = "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD = ?"
//        // selection arguments
//        val selectionArgs = arrayOf(email, password)
//        // query user table with conditions
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
//         */
//        val cursor = db.query(TABLE_USER, //Table to query
//                columns, //columns to return
//                selection, //columns for the WHERE clause
//                selectionArgs, //The values for the WHERE clause
//                null,  //group the rows
//                null, //filter by row groups
//                null) //The sort order
//        val cursorCount = cursor.count
//        cursor.close()
//        db.close()
//        if (cursorCount > 0)
//            return true
//        return false
//    }
//