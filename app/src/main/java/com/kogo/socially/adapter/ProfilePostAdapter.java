package com.kogo.socially.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kogo.socially.R;
import com.kogo.socially.modals.ProfilePost;

import java.util.List;

public class ProfilePostAdapter extends RecyclerView.Adapter<ProfilePostAdapter.CardViewHolder>{

    private int viewPosition;
    private Context mContext;
    private List<ProfilePost> profilePostList;

    public ProfilePostAdapter(Context mContext, List<ProfilePost> profilePostList) {
        this.mContext = mContext;
        this.profilePostList = profilePostList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            Log.e("position 1: ", String.valueOf(viewType));
            viewPosition = 0;
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_profile_post_big, parent,false);
            return new CardViewHolder(view);
        }
        else {
            Log.e("position 1: ", String.valueOf(viewType));
            viewPosition = 1;
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_profile_post_mini, parent,false);
            return new CardViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        ProfilePost aProfilePost = profilePostList.get(position);

        if (viewPosition == 0){
            holder.cLayoutProfilePostBig.setBackground(ContextCompat.getDrawable(mContext, mContext.getResources().getIdentifier(aProfilePost.getPostImage(),"drawable",mContext.getPackageName())));
        }else{
            holder.cLayoutProfilePostMini.setBackground(ContextCompat.getDrawable(mContext, mContext.getResources().getIdentifier(aProfilePost.getPostImage(),"drawable",mContext.getPackageName())));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;

    }

    @Override
    public int getItemCount() {
        return profilePostList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        private CardView cardViewProfilePostBig, cardViewProfilePostMini;
        private ConstraintLayout cLayoutProfilePostBig, cLayoutProfilePostMini;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewProfilePostBig = itemView.findViewById(R.id.cardViewProfilePostBig);
            cardViewProfilePostMini = itemView.findViewById(R.id.cardViewProfilePostMini);
            cLayoutProfilePostBig = itemView.findViewById(R.id.cLayoutProfilePostBig);
            cLayoutProfilePostMini = itemView.findViewById(R.id.cLayoutProfilePostMini);
        }
    }
}
