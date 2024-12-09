package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CourseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    String courselist[] = {"DataStructure", "Java", "Python", "Php", "Html5", "Css"};
    int courseImages[] = {R.drawable.datastructure, R.drawable.java, R.drawable.python1, R.drawable.php, R.drawable.html, R.drawable.css};

    String urls[] = {"https://www.javatpoint.com/data-structure-tutorial",
                      "https://www.guru99.com/java-tutorial.html",
                      "https://www.javatpoint.com/python-tutorial",
                      "https://www.javatpoint.com/php-tutorial",
                       "https://www.tutorialspoint.com/html5/index.htm",
                       "https://www.javatpoint.com/css-tutorial"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        listView = (ListView) findViewById(R.id.lst1);
        Custombaseadapter custombaseadapter = new Custombaseadapter(getApplicationContext(), courselist, courseImages,urls);
        listView.setAdapter(custombaseadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


    }
}




