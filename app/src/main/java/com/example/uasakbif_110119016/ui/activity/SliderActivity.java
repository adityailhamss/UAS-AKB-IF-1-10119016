package com.example.uasakbif_110119016.ui.activity;
/*
NIM     : 10119016
Nama    : Aditya Ilham Subagja
Kelas   : IF-1
*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uasakbif_110119016.PageAdapter;
import com.example.uasakbif_110119016.R;

public class SliderActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button btnNext;
    int[] layouts;
    PageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        viewPager = findViewById(R.id.pager);
        btnNext = findViewById(R.id.nextBtn);

        layouts = new int[] {
                R.layout.activity_welcome1,
                R.layout.activity_welcome2,
                R.layout.activity_welcome3
        };

        adapter = new PageAdapter(this, layouts);
        viewPager.setAdapter(adapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1<layouts.length){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else{
                    //kembali ke main activity
                    startActivity(new Intent(SliderActivity.this, LoginActivity.class));
                    finish();
                }
            }
        });

        viewPager.addOnPageChangeListener(viewPagerChangeListener);
    }

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i == layouts.length -1 ){
                btnNext.setText("Mulai");
            }else {
                btnNext.setText("Lanjutkan");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}