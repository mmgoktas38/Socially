package com.kogo.socially;

import androidx.fragment.app.FragmentActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.kogo.socially.adapter.IntroViewPagerAdapter;
import com.kogo.socially.databinding.ActivityIntroBinding;
import com.kogo.socially.modals.ScreenItem;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends FragmentActivity  {

    private ActivityIntroBinding introBinding;
    private IntroViewPagerAdapter introViewPagerAdapter;
    private int position;
    private List<ScreenItem> screenList = new ArrayList<>();
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        introBinding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(introBinding.getRoot());

        if (restorePrefData()){
            Toast.makeText(this, "diğer sayfa", Toast.LENGTH_LONG).show();
        }

        screenList.add(new ScreenItem(R.drawable.hero_img, R.drawable.button_next));
        screenList.add(new ScreenItem(R.drawable.hero_img2, R.drawable.button_next2));
        screenList.add(new ScreenItem(R.drawable.hero_img2, R.drawable.button_next));
        setIntroViewPagerAdapter(screenList);

        position = introBinding.viewPager.getCurrentItem();

        introBinding.textViewNext.setOnClickListener(view -> {
            if (position < screenList.size()){
                position++;
                introBinding.viewPager.setCurrentItem(position);
            }

            if (position == screenList.size()){
                savePrefData();
            }
            else {
            }

        });

        introBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (tab.getPosition() == screenList.size() - 1){
                    introBinding.textViewNext.setText("Get Started");
                }
                else{
                    introBinding.textViewNext.setText("Next");
                }

                if (position == 1){
                    introBinding.textViewNext.setTextColor(Color.BLACK);
                    introBinding.imageViewNextIcon.setImageResource(R.drawable.icon_next_black);
                }
                else{
                    introBinding.textViewNext.setTextColor(Color.WHITE);
                    introBinding.imageViewNextIcon.setImageResource(R.drawable.icon_next_white);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setIntroViewPagerAdapter(List<ScreenItem> screenItemList){

        introViewPagerAdapter = new IntroViewPagerAdapter(this, screenItemList);
        introBinding.viewPager.setAdapter(introViewPagerAdapter);
        introBinding.tabLayout.setupWithViewPager(introBinding.viewPager);

    }

    private void savePrefData(){

        sharedPreferences = getApplicationContext().getSharedPreferences("onboardingpref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFirstTimeLaunch",true);
        editor.apply();

    }

    private Boolean restorePrefData(){
        sharedPreferences = getApplicationContext().getSharedPreferences("onboardingpref", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isFirstTimeLaunch", false);
    }

}