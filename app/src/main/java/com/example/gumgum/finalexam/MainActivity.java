package com.example.gumgum.finalexam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "exam_app_prefs";
    Button btnValidate;
    Button btnCancel;
    EditText txtEmail;
    EditText txtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnValidate = (Button) findViewById(R.id.validateButton);
        btnCancel = (Button) findViewById(R.id.cancelButton);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPwd= (EditText) findViewById(R.id.txtPwd);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String email = settings.getString("email", null);
        String password = settings.getString("password", null);

        if (email != null && password != null) {
            Intent intent = new Intent(getBaseContext(), SecondActivity.class);
            startActivity(intent);
            finish();
        }
    }


    public void onClick(View v) {
        if(v.getId() == R.id.validateButton){
            if(txtEmail.getText().length() != 0 && txtPwd.getText().length()!= 0 ) {
                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("email", txtEmail.getText().toString());
                editor.putString("password", txtPwd.getText().toString());
                editor.commit();
                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "No credentials specified !", Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId() == R.id.cancelButton){
            txtEmail.setText("");
            txtPwd.setText("");
        }
    }
}
