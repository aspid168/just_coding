package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class TheoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> elements;
    private List<Integer> images;
    private Boolean state;
    private int topic;
    private int pos;
    Context mcontext;
    public TheoryAdapter(List<String> e, int topic, Context context, Boolean state) {
        elements = e;
        this.topic = topic;
        mcontext = context;
        this.state = state;
    }
    public TheoryAdapter(List<Integer> e, Boolean state, Integer pos) {
        images = e;
        this.state = state;
        this.pos = pos;
    }


    public static class TheoryViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        public TheoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.element);
        }
    }

    public static class ElementViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ElementViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(state) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theory_element, parent, false);
            return new TheoryViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theory_element_1, parent, false);
            return new ElementViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(state) {
            TextView textView = ((TheoryViewHolder) holder).textView1;
            textView.setText(elements.get(position));

            textView.setOnClickListener(v -> {
                switch (topic) {
                    case 0:
                        ((Theory)mcontext).articles(position);
                        break;
                    case 1:
                        ((Theory)mcontext).preposition(position);
                        break;
                    case 2:
                        ((Theory)mcontext).pronoun(position);
                        break;
                    case 3:
                        ((Theory)mcontext).verb(position);
                        break;
                }
            });
        }
        else
        {
            ImageView imageView = ((ElementViewHolder)holder).imageView;
            imageView.setImageResource(images.get(pos));
        }
    }

    @Override
    public int getItemCount() {
        if(state)
            return elements.size();
        else
            return 1;
    }
}
