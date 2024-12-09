package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz_page extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5,btn6;
TextView noofquestion;
TextView questionTextView;
Button submitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        btn1 = findViewById(R.id.btn);
        btn2 = findViewById(R.id.button1);
        btn3 = findViewById(R.id.button2);
        btn4 = findViewById(R.id.button3);
        btn5 = findViewById(R.id.button4);
        btn6 = findViewById(R.id.button5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Quiz_page.this,Quiz.class);
                        startActivity(intent1);
                    }
                });

          btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2=new Intent(Quiz_page.this,Quiz_java.class);
            startActivity(intent2);
        }
    });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(Quiz_page.this,Quiz_python.class);
                startActivity(intent3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(Quiz_page.this,Quiz_php.class);
                startActivity(intent4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(Quiz_page.this,Quiz_html.class);
                startActivity(intent5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6=new Intent(Quiz_page.this,Quiz_css.class);
                startActivity(intent6);
            }
        });
    }
    }
