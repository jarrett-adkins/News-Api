package com.example.admin.newsapplication.data.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.admin.newsapplication.model.Model

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "favorites.db", null, 1) {

    val TAG = "DBHelper";
    val TABLE = "favorites"

    companion object {
        public val ID: String = "_id"
        public val SOURCE_ID: String = "source_id"
        public val SOURCE_NAME: String = "source_name"
        public val AUTHOR: String = "author"
        public val TITLE: String = "title"
        public val DESCRIPTION: String = "description"
        public val URL: String = "url"
        public val URL_TO_IMAGE: String = "url_to_image"
        public val PUBLISHED_AT: String = "published_at"
    }

    val DATABASE_CREATE =
            "CREATE TABLE if not exists " + TABLE + " (" +
                    "$ID integer PRIMARY KEY autoincrement," +
                    "$SOURCE_ID text," +
                    "$SOURCE_NAME text," +
                    "$AUTHOR text," +
                    "$TITLE text," +
                    "$DESCRIPTION text," +
                    "$URL text," +
                    "$URL_TO_IMAGE text," +
                    "$PUBLISHED_AT text" +
                    ")"

    override fun onCreate(db: SQLiteDatabase) {
        Log.d(TAG, "Creating Database")
        db.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        Log.d(TAG, "Dropping Table")
        db.execSQL("DROP TABLE IF EXISTS " + TABLE)
        onCreate(db)
    }

    fun checkIfFavorited(article: Model.Article): Boolean {
        Log.d(TAG, "Checking if " + article.url + " is in the database.")
        val query = "SELECT $ID FROM $TABLE WHERE $URL = '" + article.url + "'"
        val cursor = readableDatabase.rawQuery(query, null)
        return cursor.moveToFirst()
    }

    fun addToFavorites(article: Model.Article): Long {
        Log.d(TAG, "Adding article to database")
        val values = ContentValues()
        values.put(SOURCE_ID, article.source.id)
        values.put(SOURCE_NAME, article.source.name)
        values.put(AUTHOR, article.author)
        values.put(TITLE, article.title)
        values.put(DESCRIPTION, article.description)
        values.put(URL, article.url)
        values.put(URL_TO_IMAGE, article.urlToImage)
        values.put(PUBLISHED_AT, article.publishedAt)

        return writableDatabase.insert(TABLE, null, values);
    }
}