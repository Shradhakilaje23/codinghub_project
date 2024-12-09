package com.example.myapplication2;

import static com.example.myapplication2.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_pageActivity extends AppCompatActivity {
Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_page);

       button1=findViewById(R.id.btn1);
       button2 =findViewById(id.btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Home_pageActivity.this,CourseActivity.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Home_pageActivity.this,Quiz_page.class);
                startActivity(intent2);
            }
        });
    }
}


