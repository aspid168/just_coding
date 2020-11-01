package com.example.application;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Theory extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> theory = new LinkedList<>();
    private List<Integer> images = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int topic = intent.getIntExtra("topic", -1);
        int element = intent.getIntExtra("element", -1);
        int position = intent.getIntExtra("position", -1);
        setContentView(R.layout.activity_theory);
        recyclerView = findViewById(R.id.recyclerviewTheory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        switch (topic){
            case 0:
                theory.add("theory_articles_1");
                theory.add("theory_articles_2");
                theory.add("theory_articles_3");
                theory.add("theory_articles_4");
                recyclerView.setAdapter(new TheoryAdapter(theory,topic,this, true));
                break;
            case 1:
                theory.add("theory_preposition_1");
                theory.add("theory_preposition_2");
                theory.add("theory_preposition_3");
                theory.add("theory_preposition_4");
                theory.add("theory_preposition_5");
                recyclerView.setAdapter(new TheoryAdapter(theory,topic,this, true));
                break;
            case 2:
                theory.add("theory_pronoun_1");
                theory.add("theory_pronoun_2");
                theory.add("theory_pronoun_3");
                theory.add("theory_pronoun_4");
                theory.add("theory_pronoun_5");
                theory.add("theory_pronoun_6");
                recyclerView.setAdapter(new TheoryAdapter(theory,topic,this, true));
                break;
            case 3:
                theory.add("theory_verbs_1");
                theory.add("theory_verbs_2");
                recyclerView.setAdapter(new TheoryAdapter(theory,topic,this, true));
                break;
            default:
                switch (element){
                    case 0:
                        images.add(R.drawable.articles0);
                        images.add(R.drawable.articles1);
                        images.add(R.drawable.articles2);
                        images.add(R.drawable.articles3);
                        recyclerView.setAdapter(new TheoryAdapter(images, false, position));
                        break;
                    case 1:
                        images.add(R.drawable.preposition0);
                        images.add(R.drawable.preposition1);
                        images.add(R.drawable.preposition2);
                        images.add(R.drawable.preposition3);
                        images.add(R.drawable.preposition4);
                        recyclerView.setAdapter(new TheoryAdapter(images, false, position));
                        break;
                    case 2:
                        images.add(R.drawable.pronoun_0);
                        images.add(R.drawable.pronoun_1);
                        images.add(R.drawable.pronoun_2);
                        images.add(R.drawable.pronoun_3);
                        images.add(R.drawable.pronoun_4);
                        images.add(R.drawable.pronoun_5);
                        recyclerView.setAdapter(new TheoryAdapter(images, false, position));
                        break;
                    case 3:
                        images.add(R.drawable.verb0);
                        images.add(R.drawable.verb1);
                        recyclerView.setAdapter(new TheoryAdapter(images, false, position));
                        break;
                }
        }

    }
    public void articles(int position) {
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("element", 0);
        intent.putExtra("position", position);
        startActivity(intent);
    }
    public void preposition(int position){
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("element", 1);
        intent.putExtra("position", position);
        startActivity(intent);
    }
    public void pronoun(int position){
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("element", 2);
        intent.putExtra("position", position);
        startActivity(intent);
    }
    public void verb(int position){
        Intent intent = new Intent(this, Theory.class);
        intent.putExtra("element", 3);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
