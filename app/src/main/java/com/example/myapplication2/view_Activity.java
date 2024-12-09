package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class view_Activity extends AppCompatActivity {
    private ListView list;
    private Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        show= findViewById(R.id.View);
        list=findViewById(R.id.list1);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> a = new ArrayList<>();
                ArrayAdapter adapter = new ArrayAdapter<>(view_Activity.this,R.layout.items, a);
                list.setAdapter(adapter);
                FirebaseDatabase.getInstance().getReference().child("Users").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            a.clear();
                            for (DataSnapshot snapshot1:snapshot.getChildren())
                            {
                                 users1 u=snapshot1.getValue(users1.class);

                                String t  ="\n Name-"+ u.getUsername()+ "\nEmail-" +u.getEmail();
                                 a.add(t);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}