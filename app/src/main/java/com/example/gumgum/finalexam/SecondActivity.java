package com.example.gumgum.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button btnSport;
    Button btnCulture;
    Button btnPolitic;
    Button btnHighTech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnSport = (Button) findViewById(R.id.sportButton);
        btnCulture = (Button) findViewById(R.id.cultureButton);
        btnPolitic = (Button) findViewById(R.id.politicButton);
        btnHighTech = (Button) findViewById(R.id.highTechButton);

        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(getBaseContext(), ThirdActivity.class);
                intent.putExtra("categorie","Sport");

                startActivity(intent);
            }
        });

        btnCulture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(getBaseContext(), ThirdActivity.class);
                intent.putExtra("categorie","Culture");
                startActivity(intent);
            }
        });
        btnPolitic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(getBaseContext(), ThirdActivity.class);
                intent.putExtra("categorie","Politique");
                startActivity(intent);
            }
        });
        btnHighTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "high tech!", Toast.LENGTH_SHORT).show();
                Intent intent = new  Intent(getBaseContext(), ThirdActivity.class);
                intent.putExtra("categorie","High-Tech");
                startActivity(intent);
            }
        });
    }

    /*
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    */
}
