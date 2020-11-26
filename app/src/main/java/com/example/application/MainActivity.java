package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.rd.PageIndicatorView;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager2 = findViewById(R.id.topics);
        PageIndicatorView pageIndicatorView = findViewById(R.id.ind);
        List<Integer> fragm_list = new LinkedList<>();
        fragm_list.add(R.layout.fragment_articles);
        fragm_list.add(R.layout.fragment_preposition);
        fragm_list.add(R.layout.fragment_pronoun);
        fragm_list.add(R.layout.fragment_verb);
        viewPager2.setAdapter(new fragment_adapter(fragm_list, viewPager2, pageIndicatorView));
    }

    public void articles_theory(View view) {
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("topic", 0);
        startActivity(intent);
    }
    public void preposition_theory(View view){
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("topic", 1);
        startActivity(intent);
    }
    public void pronoun_theory(View view){
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("topic", 2);
        startActivity(intent);
    }
    public void verb_theory(View view){
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("topic", 3);
        startActivity(intent);
    }

    public void articles_practice(View view) {
        Intent intent = new Intent(this, Practice.class);
        intent.putExtra("topic", 0);
        startActivity(intent);
    }
    public void preposition_practice(View view){
        Intent intent = new Intent(this, Practice.class);
        intent.putExtra("topic", 1);
        startActivity(intent);
    }
    public void pronoun_practice(View view){
        Intent intent = new Intent(this, Practice.class);
        intent.putExtra("topic", 2);
        startActivity(intent);
    }
    public void verb_practice(View view){
        Intent intent = new Intent(this, Practice.class);
        intent.putExtra("topic", 3);
        startActivity(intent);
    }
}