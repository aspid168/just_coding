package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Practice_end_scr extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int right_answer = intent.getIntExtra("right", -1);
        int questions = intent.getIntExtra("questions", -1);
        setContentView(R.layout.practice_end_scr);
        TextView right = findViewById(R.id.right);
        TextView wrong = findViewById(R.id.wrong);
        right.setText("Правильно: " + right_answer);
        wrong.setText("Не правильно: " + (questions - right_answer));
    }
    public void return_to_main_scr(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
