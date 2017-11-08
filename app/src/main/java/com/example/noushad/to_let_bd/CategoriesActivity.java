package com.example.noushad.to_let_bd;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private CategoriesAdapter mAdapter;
    private ViewPager mViewPager;
    private SlideShowAdapter mSlideShowAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        initializeViews();
        changeSlides();

    }

    private void changeSlides() {

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                int i = mViewPager.getCurrentItem();
                if(i==mSlideShowAdapter.getCount()-1){
                    i=0;
                }else{
                    i++;
                }
                mViewPager.setCurrentItem(i,false);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },3000,3000);
    }

    private void loadSlideImages() {
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.advice_1);
        images.add(R.drawable.advice_2);
        images.add(R.drawable.advice_3);
        images.add(R.drawable.advice_4);
        images.add(R.drawable.advice_5);
        images.add(R.drawable.advice_6);
        mSlideShowAdapter.addAll(images);
    }

    private void initializeViews() {
        mViewPager = findViewById(R.id.view_pager);
        CircleIndicator circleIndicator = findViewById(R.id.slide_indicator);
        mSlideShowAdapter = new SlideShowAdapter(this);
        loadSlideImages();
        mViewPager.setAdapter(mSlideShowAdapter);
        circleIndicator.setViewPager(mViewPager);
        mRecyclerView = findViewById(R.id.categorie_list_view);
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new CategoriesAdapter(this.getApplicationContext());
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mRecyclerView.setAdapter(mAdapter);
        }
        loadCategories();
    }

    private void loadCategories() {
        List<CategoriesItem> rentCategories = new ArrayList<>();
        rentCategories.add(new CategoriesItem("ফ্ল্যাট এবং এপার্টমেন্ট", R.drawable.apartment_icon, "ফ্ল্যাট অথবা এপার্ট্মেন্ট ভাড়া বা বিক্রয়"));
        rentCategories.add(new CategoriesItem("বাড়ি/ঘড়", R.drawable.home_icon, "বাড়ি/ ঘর ভাড়া বা বিক্রয়"));
        rentCategories.add(new CategoriesItem("রুম", R.drawable.room_icon, "রুম ভাড়া"));
        rentCategories.add(new CategoriesItem("সিট", R.drawable.seat_icon, "সিট ভাড়া"));
        rentCategories.add(new CategoriesItem("কমার্সিয়াল স্পেস", R.drawable.commeercial_space_icon, "বাণিজ্যিক প্রোপার্টি, অফিসের স্পেস ভাড়া দিন"));
        rentCategories.add(new CategoriesItem("দোকান", R.drawable.shop, "দোকান ভাড়া"));
        rentCategories.add(new CategoriesItem("গ্যারেজ", R.drawable.garage_icon, "গ্যারেজ ভাড়া"));
        rentCategories.add(new CategoriesItem("জমি/প্লট", R.drawable.plot_icon, "জমি বা প্লট ভাড়া / বিক্রয়"));
        mAdapter.addAll(rentCategories);
    }
}
