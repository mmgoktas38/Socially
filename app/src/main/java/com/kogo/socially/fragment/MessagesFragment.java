package com.kogo.socially.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kogo.socially.R;
import com.kogo.socially.adapter.MessageAdapter;
import com.kogo.socially.adapter.PostAdapter;
import com.kogo.socially.adapter.StoryAdapter;
import com.kogo.socially.databinding.FragmentMessagesBinding;
import com.kogo.socially.modals.Message;
import com.kogo.socially.modals.Post;
import com.kogo.socially.modals.Story;

import java.util.ArrayList;
import java.util.List;


public class MessagesFragment extends Fragment {

    private List<Message> messageList = new ArrayList<>();
    private MessageAdapter messageAdapter;
    private ArrayList<Message> filteredlist = new ArrayList<>();
    private FragmentMessagesBinding messagesBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        messagesBinding = FragmentMessagesBinding.inflate(inflater,container,false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        if(navBar != null){
          //  navBar.setVisibility(View.GONE);
        }

        buildMessageRecyclerView();

        messagesBinding.recyclerViewMessages.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && navBar.isShown()) {
                    navBar.setVisibility(View.GONE);
                } else if (dy < 0 ) {
                    navBar.setVisibility(View.VISIBLE);

                }
            }
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        messagesBinding.imageViewMessageToHome.setOnClickListener(view -> {
        //    goMessagesToHome();
        });
        messagesBinding.cLayoutWriteMessage.setOnClickListener(view -> { Log.e("here", "here"); });

        messagesBinding.editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(String.valueOf(editable));
            }
        });


        return messagesBinding.getRoot();
    }

    private void buildMessageRecyclerView(){
        messageList.clear();

        messageList.add(new Message(String.valueOf(R.drawable.malena), "Malena Tudi", "Hey, how's it goin?"));
        messageList.add(new Message(String.valueOf(R.drawable.jakob), "Jakob Curtis", "Yo, are you going to the Jake’s wedding?"));
        messageList.add(new Message(String.valueOf(R.drawable.abram), "Abram Levin", "Amir said we’d be staying over for a while... but ..."));
        messageList.add(new Message(String.valueOf(R.drawable.marilyn), "Marilyn Herwitz", "hey, i got new memes for you"));
        messageList.add(new Message(String.valueOf(R.drawable.desirae), "Desirae Saris", "GoT really took a nose dive huh"));

        messagesBinding.recyclerViewMessages.setHasFixedSize(true);
        messagesBinding.recyclerViewMessages.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        messageAdapter = null;
        messageAdapter = new MessageAdapter(getContext(), messageList);
        messagesBinding.recyclerViewMessages.setAdapter(messageAdapter);
        messageAdapter.notifyDataSetChanged();

    }

    public void filter(String text){
        filteredlist.clear();

        for (Message item : messageList) {
            if (item.getNameSurname().toLowerCase().contains(text.toLowerCase()) || item.getMessage().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            //Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
            messageAdapter.filterList(filteredlist);
        } else {
            messageAdapter.filterList(filteredlist);
        }
    }

    public void goMessagesToHome(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.navHostFragment, homeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}