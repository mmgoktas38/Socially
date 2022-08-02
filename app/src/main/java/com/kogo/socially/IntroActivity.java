package com.kogo.socially;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        introBinding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(introBinding.getRoot());


        screenList.add(new ScreenItem("Welcome to\nSocially", R.drawable.hero_img, R.drawable.button_next));
        screenList.add(new ScreenItem("Welcome to\nSocially", R.drawable.hero_img2, R.drawable.button_next2));
        screenList.add(new ScreenItem("Welcome to\nSocially", R.drawable.hero_img2, R.drawable.button_next));
        setIntroViewPagerAdapter(screenList);

        position = introBinding.viewPager.getCurrentItem();

        introBinding.textViewNext.setOnClickListener(view -> {
            if (position < screenList.size()){
                position++;
                introBinding.viewPager.setCurrentItem(position);
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

}