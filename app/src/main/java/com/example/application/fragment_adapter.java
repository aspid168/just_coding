package com.example.application;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rd.PageIndicatorView;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class fragment_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Integer> fragment;
    private ViewPager2 viewPager2;
    private int PAGES = 0;
    private PageIndicatorView pageIndicatorView;


    public fragment_adapter(List<Integer> fragment, ViewPager2 viewPager2, PageIndicatorView pag) {
        this.fragment = fragment;
        this.viewPager2 = viewPager2;
        this.pageIndicatorView = pag;
    }

    public class Fragment1ViewHolder extends RecyclerView.ViewHolder{
//        private Button th1;
//        private Button ex1;
        public Fragment1ViewHolder(@NonNull View itemView) {
            super(itemView);
//            th1 = itemView.findViewById(R.id.theory_articles);
//            ex1 = itemView.findViewById(R.id.exercises_articles);

        }
    }
//    public class Fragment2ViewHolder extends RecyclerView.ViewHolder{
//        private Button th2;
//        private Button ex2;
//        public Fragment2ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            th2 = itemView.findViewById(R.id.theory_preposition);
//            ex2 = itemView.findViewById(R.id.exercises_preposition);
//
//        }
//    }
//    public class Fragment3ViewHolder extends RecyclerView.ViewHolder{
////        private List<Button> theory = new LinkedList<>();
//        private Button th3;
//        private Button ex3;
//        public Fragment3ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            th3 = itemView.findViewById(R.id.theory_pronoun);
//            ex3 = itemView.findViewById(R.id.exercises_pronoun);
//
//        }
//    }
//    public class Fragment4ViewHolder extends RecyclerView.ViewHolder{
//        private Button th4;
//        private Button ex4;
//        public Fragment4ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            th4 = itemView.findViewById(R.id.theory_verbs);
//            ex4 = itemView.findViewById(R.id.exercises_verbs);
//
//        }
//    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(fragment.get(PAGES), parent, false);
        PAGES++;
        return new Fragment1ViewHolder(view);


//        switch (PAGES){
//            case 1:
//                return new Fragment1ViewHolder(view);
//            case 2:
//                return new Fragment2ViewHolder(view);
//            case 3:
//                return new Fragment3ViewHolder(view);
//            case 4:
//                return new Fragment4ViewHolder(view);
//            default:
//                return null;
//        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        switch (position){
//            case 0:
//                Button ex1 = ((Fragment1ViewHolder)holder).ex1;
//                Button th1 = ((Fragment1ViewHolder)holder).th1;
//                ex1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.v("1.1", "1.1");
//
//                    }
//                });
//                th1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.v("1.2", "1.2");
//                    }
//                });
//            break;
//            case 1:
//                Button ex2 = ((Fragment2ViewHolder)holder).ex2;
//                Button th2 = ((Fragment2ViewHolder)holder).th2;
//                ex2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.v("2.1", "2.1");
//                    }
//                });
//                th2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.v("2.2", "2.2");
//                    }
//                });
//            break;
//            case 2:
//                Button ex3 = ((Fragment3ViewHolder)holder).ex3;
//                Button th3 = ((Fragment3ViewHolder)holder).th3;
//                ex3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.v("3.1", "3.1");
//                    }
//                });
//                th3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.v("3.2", "3.2");
//                    }
//                });
//                break;
//            case 3:
//            Button ex4 = ((Fragment4ViewHolder)holder).ex4;
//            Button th4 = ((Fragment4ViewHolder)holder).th4;
//            ex4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.v("4.1", "4.1");
//                }
//            });
//            th4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.v("4.2", "4.2");
//                }
//            });
//            break;
//        }


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            }

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fragment.size();
    }
}
