package com.kogo.socially;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.kogo.socially.adapter.IntroViewPagerAdapter;
import com.kogo.socially.databinding.ActivityIntroBinding;
import com.kogo.socially.modals.ScreenItem;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends FragmentActivity  {

    private ActivityIntroBinding introBinding;
    private IntroViewPagerAdapter introViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        introBinding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(introBinding.getRoot());

        List<ScreenItem> screenItemList = new ArrayList<>();
        screenItemList.add(new ScreenItem("welcom", R.drawable.img1));
        screenItemList.add(new ScreenItem("welcom", R.drawable.img2));
        screenItemList.add(new ScreenItem("welcom", R.drawable.img3));
        setIntroViewPagerAdapter(screenItemList);

    }

    private void setIntroViewPagerAdapter(List<ScreenItem> screenItemList){

        introViewPagerAdapter = new IntroViewPagerAdapter(this, screenItemList);
        introBinding.viewPager.setAdapter(introViewPagerAdapter);       // ERROR
      //  introBinding.tabLayout.setupWithViewPager(introBinding.viewPager);

    }

}