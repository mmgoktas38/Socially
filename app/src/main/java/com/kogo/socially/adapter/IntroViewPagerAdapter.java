package com.kogo.socially.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.kogo.socially.R;
import com.kogo.socially.ScreenSlidePageFragment;
import com.kogo.socially.modals.ScreenItem;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenItem> screenItemList;

    public IntroViewPagerAdapter() {
    }

    public IntroViewPagerAdapter(Context mContext, List<ScreenItem> screenItemList) {
        this.mContext = mContext;
        this.screenItemList = screenItemList;
    }

    @Override
    public int getCount() {
        return screenItemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_screen,null);

        ImageView imageViewIntro = view.findViewById(R.id.imageViewIntro);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);

        imageViewIntro.setImageResource(screenItemList.get(position).getImageIntro());
        textViewTitle.setText(screenItemList.get(position).getTitle());

        container.addView(view);

        return view;
    }
}
