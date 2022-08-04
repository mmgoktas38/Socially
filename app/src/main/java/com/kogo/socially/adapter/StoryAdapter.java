package com.kogo.socially.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kogo.socially.R;
import com.kogo.socially.modals.Story;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.CardViewHolder>{

    private Context mContext;
    private List<Story> storyList;

    public StoryAdapter(Context mContext, List<Story> storyList) {
        this.mContext = mContext;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_story, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Story aStory = storyList.get(position);

        holder.imageViewCircleStrory.setImageResource(mContext.getResources().getIdentifier(storyList.get(position).getStoryImage(),"drawable",mContext.getPackageName()));

    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView imageViewCircleStrory;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCircleStrory = itemView.findViewById(R.id.imageViewCircleProfilePhotoMessageA);
        }

    }

}
