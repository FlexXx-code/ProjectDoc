package com.example.projectdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button SignUpbutton;
    Button LogInbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignUpbutton= (Button)findViewById(R.id.signUp_btn);
        LogInbutton= (Button)findViewById(R.id.loginBtn);

        SignUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);


            }
        });

        LogInbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SignIn.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"LOGGED IN!!",Toast.LENGTH_SHORT).show();

            }
        });


    }
}