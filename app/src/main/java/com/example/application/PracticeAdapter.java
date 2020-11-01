package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PracticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Boolean state = false;
    RecyclerView recyclerView;
    Context mcontext;
    int question_number;
    int topic;
    int right_answers;
    PracticeAdapter(RecyclerView recyclerView, Context context, Boolean state, int topic){
        this.recyclerView = recyclerView;
        mcontext = context;
        this.state = state;
        this.topic = topic;
    }
    PracticeAdapter(int question_number, RecyclerView recyclerView, Context mcontext, int right_answers){
        this.question_number = question_number;
        this.recyclerView = recyclerView;
        this.mcontext = mcontext;
        this.right_answers = right_answers;
    }


    public static class PracticeViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public PracticeViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
    public static class PracticeElementViewHolder extends RecyclerView.ViewHolder{
        TextView question;
        TextView right;
        Button first;
        Button second;
        Button third;
        Button fourth;
        TextView questions_number;
        public PracticeElementViewHolder(View itemView){
            super(itemView);
            questions_number = itemView.findViewById(R.id.questions);
            question = itemView.findViewById(R.id.task);
            first = itemView.findViewById(R.id.first);
            second = itemView.findViewById(R.id.second);
            third = itemView.findViewById(R.id.third);
            fourth = itemView.findViewById(R.id.fourth);
            right = itemView.findViewById(R.id.right);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (state)
            return new PracticeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.practice, parent, false));
        else
            return new PracticeElementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.practice_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(state) {
            TextView textView = ((PracticeViewHolder) holder).textView;
            String[] theme = mcontext.getResources().getStringArray(R.array.topic);
            textView.setText(theme[topic]);
            textView.setOnClickListener(v ->{
                recyclerView.setAdapter(new PracticeAdapter(0, recyclerView, mcontext, 0));
            });

        }
        else{
            final TextView question = ((PracticeElementViewHolder) holder).question;
            Button first = ((PracticeElementViewHolder) holder).first;
            Button second = ((PracticeElementViewHolder) holder).second;
            Button third = ((PracticeElementViewHolder) holder).third;
            Button fourth = ((PracticeElementViewHolder) holder).fourth;
            TextView right = ((PracticeElementViewHolder)holder).right;
            TextView questions_number = ((PracticeElementViewHolder)holder).questions_number;
            int[] answer = mcontext.getResources().getIntArray(R.array.answers);
            if(answer.length == question_number) {

                ((Practice)mcontext).test(answer.length, right_answers);
            }
            else
                question.setText("Choose " + answer[question_number]);

            right.setText("Верно: " + right_answers);
            questions_number.setText(question_number + "/7");
            first.setOnClickListener(v -> {
                if(first.getText().toString().equals(Integer.toString(answer[question_number]))){
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers+1));
                }
                else{
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers));
                }
            });
            second.setOnClickListener(v -> {
                if(second.getText().toString().equals(Integer.toString(answer[question_number]))){
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers+1));
                }
                else{
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers));
                }
            });
            third.setOnClickListener(v -> {
                if(third.getText().toString().equals(Integer.toString(answer[question_number]))){
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers+1));
                }
                else{
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers));
                }

            });
            fourth.setOnClickListener(v -> {
                if(fourth.getText().toString().equals(Integer.toString(answer[question_number]))){
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers+1));
                }
                else{
                    recyclerView.setAdapter(new PracticeAdapter(question_number+1, recyclerView, mcontext, right_answers));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
