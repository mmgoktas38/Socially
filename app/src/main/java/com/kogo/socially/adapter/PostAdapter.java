package com.kogo.socially.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kogo.socially.R;
import com.kogo.socially.modals.Post;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CardViewHolder>{

    private Context mContext;
    private List<Post> postList;

    public PostAdapter(Context mContext, List<Post> postList) {
        this.mContext = mContext;
        this.postList = postList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_post, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        Post aPost = postList.get(position);

        holder.imageViewCircleProfileImage.setImageResource(mContext.getResources().getIdentifier(aPost.getProfileImage(),"drawable",mContext.getPackageName()));
        holder.textViewUsername.setText(aPost.getUsername());
        holder.textViewSharingTime.setText(aPost.getSharingTime());
        holder.textViewLikesCount.setText("" + aPost.getLikesCount() + "K" );
        holder.textViewCommentsCount.setText("" + aPost.getCommentsCount() + "K" );
        holder.textViewSaveCount.setText(String.valueOf(aPost.getSaveCount()) );
        holder.cLayoutPost.setBackground(ContextCompat.getDrawable(mContext, mContext.getResources().getIdentifier(aPost.getPostImage(),"drawable",mContext.getPackageName())));

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageViewCircleProfileImage;
        private TextView textViewUsername, textViewSharingTime, textViewLikesCount, textViewCommentsCount, textViewSaveCount;
        private ConstraintLayout cLayoutPost;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCircleProfileImage = itemView.findViewById(R.id.imageViewCircleProfilePhotoMessageA);
            textViewUsername = itemView.findViewById(R.id.textViewNameSurname);
            textViewSharingTime = itemView.findViewById(R.id.textViewSharingTime);
            textViewLikesCount = itemView.findViewById(R.id.textViewLikesCount);
            textViewCommentsCount = itemView.findViewById(R.id.textViewCommentsCount);
            textViewSaveCount = itemView.findViewById(R.id.textViewSaveCount);
            cLayoutPost = itemView.findViewById(R.id.cLayoutPost);

        }
    }
}
