package com.example.gumgum.finalexam.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public  class ArticleHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "articles.db";

    // Articles table name
    public static final String TABLE_ARTICLES = "articles";

    // Articles Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_VISIBLE = "visible";
    public static final String KEY_CATEGORIE = "categorie";

    public ArticleHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ArticleS_TABLE = "CREATE TABLE " + TABLE_ARTICLES + "("
                + KEY_ID + " INTEGER PRIMARY KEY ," + KEY_TITLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"+KEY_VISIBLE+" INTEGER DEFAULT 0, "+KEY_CATEGORIE+" TEXT"+ ")";
        Log.d("xx",CREATE_ArticleS_TABLE);
        db.execSQL(CREATE_ArticleS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);

        // Create tables again
        onCreate(db);
    }
}
