package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Practice extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        recyclerView = findViewById(R.id.recyclerviewTheory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        int topic = intent.getIntExtra("topic", -1);
        recyclerView.setAdapter(new PracticeAdapter(recyclerView, this, true, topic));

    }
    public void test(int questions, int right_answers){
        finish();
        Intent intent_end = new Intent(this, Practice_end_scr.class);
        intent_end.putExtra("right", right_answers);
        intent_end.putExtra("questions", questions);
        startActivity(intent_end);
    }
}