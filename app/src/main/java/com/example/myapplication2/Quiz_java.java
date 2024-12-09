package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz_java extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionTextview, questionTextView;
    Button option1, option2, option3, option4;
    Button submitBtn,logoutbtn;

    int score = 0;
    int totalquestion = Modelclass2.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_java);

        totalQuestionTextview = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.question);
        option1 = findViewById(R.id.btn1);
        option2 = findViewById(R.id.btn2);
        option3 = findViewById(R.id.btn3);
        option4 = findViewById(R.id.btn4);
        submitBtn = findViewById(R.id.submit_btn);
        logoutbtn=findViewById(R.id.logout);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz_java.this, MainActivity.class));
            }
        });

        submitBtn.setOnClickListener(this);

        totalQuestionTextview.setText("Number of Question:" + totalquestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        option1.setBackgroundColor(Color.WHITE);
        option2.setBackgroundColor(Color.WHITE);
        option3.setBackgroundColor(Color.WHITE);
        option4.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(Modelclass2.correctAnswer[currentQuestionIndex]))
            {
                score++;
            }

            currentQuestionIndex++;
            loadNewQuestion();


        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion() {


        if (currentQuestionIndex == totalquestion) {
            finishQuiz();
            return;
        }

        questionTextView.setText(Modelclass2.question[currentQuestionIndex]);
        option1.setText(Modelclass2.choices[currentQuestionIndex][0]);
        option2.setText(Modelclass2.choices[currentQuestionIndex][1]);
        option3.setText(Modelclass2.choices[currentQuestionIndex][2]);
        option4.setText(Modelclass2.choices[currentQuestionIndex][3]);

    }

    void finishQuiz() {

        String passStatus = "";
        if (score > totalquestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is: " + score + "out of :" + totalquestion)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();










    }


    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

}
