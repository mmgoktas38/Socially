package com.kogo.socially.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.kogo.socially.R;
import com.kogo.socially.databinding.ActivityMessageBinding;
import com.kogo.socially.fragment.MessagesFragment;

public class MessageActivity extends AppCompatActivity {

    private ActivityMessageBinding messageBinding;
    private String name, photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messageBinding = ActivityMessageBinding.inflate(getLayoutInflater());
        // hide status bar, write this code before setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(messageBinding.getRoot());

        name = getIntent().getStringExtra("name");
        photo = getIntent().getStringExtra("photo");
        setNamePhoto(name, photo);

        messageBinding.imageViewMessageActivityToHome.setOnClickListener(view -> { goToMessages(); });

    }

    public void setNamePhoto(String name, String photo){
        messageBinding.textViewNameSurnameOnMessageA.setText(name);
        messageBinding.imageViewCircleProfilePhotoMessageA.setImageResource(getApplicationContext().getResources().getIdentifier(photo,"drawable",getApplicationContext().getPackageName()));
    }

    public void goToMessages(){
        Fragment messagesFragment = new MessagesFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.cLayoutMessageActivity, messagesFragment).attach(messagesFragment).commit();
        finish();
    }

}