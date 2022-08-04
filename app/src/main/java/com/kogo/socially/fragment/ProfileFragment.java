package com.kogo.socially.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kogo.socially.R;
import com.kogo.socially.adapter.ProfilePostAdapter;
import com.kogo.socially.adapter.StoryAdapter;
import com.kogo.socially.databinding.FragmentProfileBinding;
import com.kogo.socially.modals.ProfilePost;
import com.kogo.socially.modals.Story;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding profileBinding;
    private List<ProfilePost> profilePostList = new ArrayList<>();
    private ProfilePostAdapter profilePostAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        profileBinding = FragmentProfileBinding.inflate(inflater, container, false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);

        buildStoryRecyclerView();

        profileBinding.imageViewProfieToMain.setOnClickListener(view -> {
        //    goToMain();
        });

        return profileBinding.getRoot();
    }

    private void buildStoryRecyclerView(){
        profilePostList.clear();

        profilePostList.add(new ProfilePost(String.valueOf(R.drawable.rectangle_5)));
        profilePostList.add(new ProfilePost(String.valueOf(R.drawable.rectangle_6)));
        profilePostList.add(new ProfilePost(String.valueOf(R.drawable.rectangle_8)));
        profilePostList.add(new ProfilePost(String.valueOf(R.drawable.rectangle_4)));

        profileBinding.recyclerViewProfilePost.setHasFixedSize(true);
        profileBinding.recyclerViewProfilePost.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        profilePostAdapter = null;
        profilePostAdapter = new ProfilePostAdapter(getContext(), profilePostList);
        profileBinding.recyclerViewProfilePost.setAdapter(profilePostAdapter);
        profilePostAdapter.notifyDataSetChanged();

    }

    public void goToMain(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, homeFragment).detach(getParentFragment()).commit();

    }

}