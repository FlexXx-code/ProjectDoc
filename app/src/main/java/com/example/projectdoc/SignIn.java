package com.example.projectdoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    
    EditText Logmail;
    EditText LogPass;
    Button SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    private Boolean validateLogmail() {
        String val = Logmail.getText().toString();
        if (val.isEmpty()) {
            Logmail.setError("Field cannot be empty");
            return false;
        } else {
            Logmail.setError(null);

            return true;
        }
    }
    private Boolean validateLogPass() {
        String val = LogPass.getText().toString();
        if (val.isEmpty()) {
            LogPass.setError("Field cannot be empty");
            return false;
        } else {
            LogPass.setError(null);

            return true;
        }
    }


    public void loginUser(View view) {
        //Validate Login Info
        if (!validateLogmail() | !validateLogPass()) {
            return;
        } else{
            isUser();
        }
    }

    private void isUser() {
      final   String userEnteredLogmail=Logmail.getText().toString().trim();
        String userEnteredLogPass=LogPass.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkUser  = reference.orderByChild("LogMail").equalTo(userEnteredLogmail);


        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()) {
                    Logmail.setError(null);

                    String passwordFromDB = snapshot.child(userEnteredLogmail).child("LogPass").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredLogPass)) {
                        Logmail.setError(null);

                        String namesFromDB = snapshot.child(userEnteredLogmail).child("names").getValue(String.class);
                        String mailFromDB = snapshot.child(userEnteredLogmail).child("mail").getValue(String.class);

                        Intent intent= new Intent(getApplicationContext(),Profile.class);
                        intent.putExtra("fullnames",namesFromDB);
                        intent.putExtra("mail",mailFromDB);
                        intent.putExtra("password",passwordFromDB);
                        startActivity(intent);


                    }
                    else {
                        LogPass.setError("Wrong Password");
                        LogPass.requestFocus();
                    }
                }
                    else{
                        Logmail.setError("No User Contains such Email");
                    LogPass.requestFocus();

                    }
                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
