package com.example.projectdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText Names;
    EditText email;
    EditText UserPassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        register= (Button)findViewById(R.id.registerBtn);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
                Toast.makeText(SignUp.this,"YOU ARE REGISTERED!!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}