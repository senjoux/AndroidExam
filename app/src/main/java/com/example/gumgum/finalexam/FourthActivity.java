package com.example.gumgum.finalexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gumgum.finalexam.DAO.ArticleDAO;
import com.example.gumgum.finalexam.model.Article;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {

    ListView articles_liste_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        articles_liste_view = (ListView) findViewById(R.id.articles_liste);
        ArticleDAO articleDAO=new ArticleDAO(this.getApplicationContext());
        List<Article> temp = articleDAO.getAllArticles();
        List<Article> visibleArticales=new ArrayList<Article>();
        for(Article a : temp){
            if (a.isVisible())
                visibleArticales.add(a);
        }
        ArrayAdapter<Article> arrayAdapter = new ArrayAdapter<Article>(
                this,
                android.R.layout.simple_list_item_1,
                visibleArticales );

        articles_liste_view.setAdapter(arrayAdapter);


    }
}
