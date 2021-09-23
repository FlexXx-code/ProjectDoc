package com.example.projectdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    EditText Names;
    EditText mail;
    EditText UserPassword;
    Button register;

    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("users");

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        register = (Button) findViewById(R.id.registerBtn);
        Names = (EditText) findViewById(R.id.UserName);
        mail = (EditText) findViewById(R.id.UserMail);
        UserPassword = (EditText) findViewById(R.id.UserPass);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                //get users
                String name = Names.getText().toString();
                String email = mail.getText().toString();
                String password = UserPassword.getText().toString();

                HashMap<String, String > userMap = new HashMap<>();
                userMap.put("name", name);
                userMap.put("mail", email);
                userMap.put("password", password);

                root.push().setValue(userMap);


                UserHelperClass helperClass = new UserHelperClass(name, email, password);
                reference.child(email).setValue(helperClass);
            }
        });
    }
}