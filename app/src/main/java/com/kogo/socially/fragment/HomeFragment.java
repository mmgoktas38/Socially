package com.kogo.socially.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kogo.socially.R;
import com.kogo.socially.adapter.StoryAdapter;
import com.kogo.socially.databinding.FragmentHomeBinding;
import com.kogo.socially.modals.Story;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding homeBinding;
    private List<Story> storyList = new ArrayList<>();
    private StoryAdapter storyAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeBinding = FragmentHomeBinding.inflate(inflater, container, false);

        buildRecyclerView();

        return homeBinding.getRoot();
    }

    private void buildRecyclerView(){
        storyList.clear();

        storyList.add(new Story(String.valueOf(R.drawable.ellipse_4)));
        storyList.add(new Story(String.valueOf(R.drawable.ellipse_5)));
        storyList.add(new Story(String.valueOf(R.drawable.ellipse_6)));
        storyList.add(new Story(String.valueOf(R.drawable.ellipse_7)));

        homeBinding.recyclerViewStory.setHasFixedSize(true);
        homeBinding.recyclerViewStory.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        storyAdapter = null;
        storyAdapter = new StoryAdapter(getContext(), storyList);
        homeBinding.recyclerViewStory.setAdapter(storyAdapter);
        storyAdapter.notifyDataSetChanged();

    }
}