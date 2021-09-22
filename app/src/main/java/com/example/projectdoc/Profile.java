package com.example.projectdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    Button update;
    EditText FullNames,Email,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        showAllUserData();


    }

    private void showAllUserData() {

        Intent intent=getIntent();
        String user_fullnames= intent.getStringExtra("fullnames");
        String user_mail= intent.getStringExtra("mail");
        String user_password= intent.getStringExtra("password");
    }
}