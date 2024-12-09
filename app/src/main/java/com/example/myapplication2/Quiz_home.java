package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz_home extends AppCompatActivity {
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_home);
        button1=findViewById(R.id.btn1);
        button2 =findViewById(R.id.btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Quiz_home.this,RegisterActivity2.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Quiz_home.this,Admin_login.class);
                startActivity(intent2);
            }
        });
    }
}


