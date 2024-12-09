package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import java.util.regex.Pattern;

public class Login_Activity2 extends AppCompatActivity {


    private EditText logemail;
    private EditText logpassword;
    private Button regbutton;
    private Button loginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        logemail = findViewById(R.id.login_Email);
        logpassword = findViewById(R.id.login_Password);
        regbutton = findViewById(R.id.register_button);
        loginButton = findViewById(R.id.login_Button);
        mAuth = FirebaseAuth.getInstance();

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity2.this, RegisterActivity2.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = logemail.getText().toString();
                String password = logpassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login_Activity2.this, "Please enter your email...", Toast.LENGTH_SHORT).show();
                    logemail.setError("Email is required");
                    logemail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(Login_Activity2.this, "Please re-enter your email", Toast.LENGTH_SHORT).show();
                    logemail.setError(" Valid Email is required");
                    logemail.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login_Activity2.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    logpassword.setError(" password is required");
                    logpassword.requestFocus();
                } else {
                    loginuser(email, password);


                }


            }
        });
    }

    private void loginuser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login_Activity2.this ,new  OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Login_Activity2.this, "You are logged in now", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login_Activity2.this, Home_pageActivity.class);
                    startActivity(intent);
                    finish();
                } else {


                    Toast.makeText(Login_Activity2.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}



