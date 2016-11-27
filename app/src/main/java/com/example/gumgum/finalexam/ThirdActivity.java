package com.example.gumgum.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gumgum.finalexam.DAO.ArticleDAO;
import com.example.gumgum.finalexam.model.Article;

import static android.R.attr.x;

public class ThirdActivity extends AppCompatActivity {

    String cat = "";
    TextView txtCategorie;
    EditText txtTitre;
    EditText txtDescription;
    Switch visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent i = getIntent();
        cat = i.getStringExtra("categorie");
        txtCategorie = (TextView) findViewById(R.id.catTitle);
        txtCategorie.setText(cat);
        txtTitre = (EditText) findViewById(R.id.txtTitle);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        visible = (Switch) findViewById(R.id.switchVisible);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_ajouter) {
            //Toast.makeText(getApplicationContext(), "ajouter!", Toast.LENGTH_SHORT).show();
            if (txtTitre.getText().length() != 0 && txtDescription.getText().length() != 0) {
                Article a = new Article(txtTitre.getText().toString(), txtDescription.getText().toString(),
                        visible.isChecked(), txtCategorie.getText().toString());
                ArticleDAO articleDAO=new ArticleDAO(this.getApplicationContext());
                long x = articleDAO.addArticle(a);
                Toast.makeText(getApplicationContext(), x+"" , Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Plz fill out all the required fields ", Toast.LENGTH_SHORT).show();
            }
        } else if (item.getItemId() == R.id.menu_afficher) {
            //ArticleDAO articleDAO=new ArticleDAO(this.getApplicationContext());
            //Toast.makeText(getApplicationContext()," -----> all = " +articleDAO.getArticlesCount() + " / "+articleDAO.getAllArticles().size() , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(), FourthActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
