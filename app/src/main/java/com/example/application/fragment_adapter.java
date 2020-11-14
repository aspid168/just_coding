package com.example.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rd.PageIndicatorView;
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
        public Fragment1ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(fragment.get(PAGES), parent, false);
        PAGES++;
        return new Fragment1ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


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
