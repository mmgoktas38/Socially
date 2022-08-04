package com.kogo.socially.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kogo.socially.R;
import com.kogo.socially.modals.Message;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.CardViewHolder>{

    private Context mContext;
    private List<Message> messageList;

    public MessageAdapter(Context mContext, List<Message> messageList) {
        this.mContext = mContext;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_messages, parent, false);
        return new MessageAdapter.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.CardViewHolder holder, int position) {

        Message aMessage = messageList.get(position);

        holder.imageViewCircleProfilePhoto.setImageResource(mContext.getResources().getIdentifier(aMessage.getProfileImage(),"drawable",mContext.getPackageName()));
        holder.textViewUsername.setText(aMessage.getNameSurname());
        holder.textViewMessage.setText(aMessage.getMessage());

    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<Message> filterllist) {
        messageList = filterllist;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageViewCircleProfilePhoto;
        private TextView textViewUsername, textViewMessage;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCircleProfilePhoto = itemView.findViewById(R.id.imageViewCircleProfilePhotoMessageA);
            textViewUsername = itemView.findViewById(R.id.textViewNameSurname);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
        }
    }
}
