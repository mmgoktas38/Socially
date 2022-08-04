package com.kogo.socially.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kogo.socially.R;
import com.kogo.socially.adapter.PostAdapter;
import com.kogo.socially.adapter.StoryAdapter;
import com.kogo.socially.databinding.FragmentHomeBinding;
import com.kogo.socially.modals.Post;
import com.kogo.socially.modals.Story;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding homeBinding;
    private List<Story> storyList = new ArrayList<>();
    private StoryAdapter storyAdapter;
    private List<Post> postList = new ArrayList<>();
    private PostAdapter postAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeBinding = FragmentHomeBinding.inflate(inflater, container, false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);

        buildStoryRecyclerView();
        buildPostRecyclerView();

        return homeBinding.getRoot();
    }

    private void buildStoryRecyclerView(){
        storyList.clear();

        storyList.add(new Story(String.valueOf(R.drawable.aaad)));
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

    private void buildPostRecyclerView(){
        postList.clear();

        postList.add(new Post("Dennis Reynolds", "2 hrs ago", String.valueOf(R.drawable.profile_img), 5.2, 1.1, 362, String.valueOf(R.drawable.post_img)));
        postList.add(new Post("Charlie Kelly", "4 hrs ago", String.valueOf(R.drawable.profile_img2), 6.1, 3.2, 656, String.valueOf(R.drawable.post_img2)));

        homeBinding.recyclerViewPost.setHasFixedSize(true);
        homeBinding.recyclerViewPost.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        postAdapter = null;
        postAdapter = new PostAdapter(getContext(), postList);
        homeBinding.recyclerViewPost.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();

    }
}