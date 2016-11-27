package com.example.gumgum.finalexam.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gumgum.finalexam.helper.ArticleHelper;
import com.example.gumgum.finalexam.model.Article;

import java.util.ArrayList;
import java.util.List;


public class ArticleDAO {

    ArticleHelper articleHelper;

    public ArticleDAO(Context context) {
        articleHelper = new ArticleHelper(context);
    }

    // Adding new Article
    public long addArticle(Article Article) {
        SQLiteDatabase db = articleHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(articleHelper.KEY_TITLE, Article.getTitle()); // Article Title
        values.put(articleHelper.KEY_DESCRIPTION, Article.getDescription()); // Article Description
        values.put(articleHelper.KEY_VISIBLE, Article.isVisible()); // Article Visibility
        values.put(articleHelper.KEY_CATEGORIE, Article.getCategorie()); // Article Categorie
        long temp = db.insert(articleHelper.TABLE_ARTICLES, null, values);
        db.close();
        // Inserting Row
        return  temp;
    }


    // Getting All Articles
    public List<Article> getAllArticles() {
        List<Article> ArticleList = new ArrayList<Article>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + articleHelper.TABLE_ARTICLES;

        SQLiteDatabase db = articleHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Article Article = new Article();
                Article.setId(Integer.parseInt(cursor.getString(0)));
                Article.setTitle(cursor.getString(1));
                Article.setDescription(cursor.getString(2));
                Article.setVisible(cursor.getInt(3) == 1);
                Article.setCategorie(cursor.getString(4));
                // Adding Article to list
                ArticleList.add(Article);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return Article list
        return ArticleList;
    }


    // Getting Articles Count
    public int getArticlesCount() {
        String countQuery = "SELECT  * FROM " + articleHelper.TABLE_ARTICLES;
        SQLiteDatabase db = articleHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int temp=cursor.getCount();
        cursor.close();
        db.close();
        // return total
        return temp;
    }

}
