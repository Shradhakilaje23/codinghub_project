package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin_login extends AppCompatActivity {
    Button loginButton;
    EditText loginEmail,loginPassword;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        loginEmail = findViewById(R.id.login_Email);
        loginPassword = findViewById(R.id.login_Password);
        loginButton = findViewById(R.id.login_Button);
        auth = FirebaseAuth.getInstance();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }
        private void loginUser() {
            String email,password;
            email=loginEmail.getText().toString().trim();
            password=loginPassword.getText().toString().trim();
            if(email.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this,"Please Provide all fields",Toast.LENGTH_SHORT).show();
            }else{

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            startActivity(new Intent(Admin_login.this,Admin_home.class));
                            finish();
                        }else
                        {

                            Toast.makeText(Admin_login.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }
