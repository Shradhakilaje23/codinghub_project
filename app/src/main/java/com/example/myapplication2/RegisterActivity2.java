package com.example.myapplication2;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

    public class RegisterActivity2 extends AppCompatActivity {

        private EditText username;

        private EditText email;
        private EditText password;
        private Button register;
        private Button loginUser;

        private DatabaseReference mRootRef;
        private FirebaseAuth mAuth;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register2);

            username = findViewById(R.id.reg_name);
            email = findViewById(R.id.reg_email);
            password = findViewById(R.id.reg_password);
            register = findViewById(R.id.reg_Button);
            loginUser = findViewById(R.id.reg_login);

            mRootRef = FirebaseDatabase.getInstance().getReference();
            mAuth = FirebaseAuth.getInstance();


            loginUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity2.this, Login_Activity2.class));
                }
            });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String txtUsername = username.getText().toString();
                    String txtEmail = email.getText().toString();
                    String txtPassword = password.getText().toString();

                    if (TextUtils.isEmpty(txtUsername) || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)) {
                        Toast.makeText(RegisterActivity2.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                    } else if (txtPassword.length() < 6) {
                        Toast.makeText(RegisterActivity2.this, "Password too short!", Toast.LENGTH_SHORT).show();
                    } else {
                        registerUser(txtUsername, txtEmail, txtPassword);
                    }
                }
            });
        }

        private void registerUser(final String username, final String email, String password) {


            mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("id", mAuth.getCurrentUser().getUid());
                    map.put("email", email);
                    map.put("username", username);
                    map.put("password", password);


                    mRootRef.child("Users").child(mAuth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(RegisterActivity2.this, "Update the profile " +
                                        "for better expereince", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity2.this, Login_Activity2.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(RegisterActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

