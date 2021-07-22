package com.laily.newadmin_sosiofun.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.laily.newadmin_sosiofun.LoginActivity;
import com.laily.newadmin_sosiofun.Model.Video;
import com.laily.newadmin_sosiofun.R;
import com.laily.newadmin_sosiofun.SharedPrefManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView addEbook, addVideo;
    ImageView videolist, ebook,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        final SharedPrefManager sharedPrefManager = new SharedPrefManager(this);
        addEbook = findViewById(R.id.addEbook);
        addVideo = findViewById(R.id.addVideo);
        ebook = findViewById(R.id.ebook);
        logout = findViewById(R.id.logout);
        videolist = findViewById(R.id.videolibrary);

        addEbook.setOnClickListener(this);
        addVideo.setOnClickListener(this);
        ebook.setOnClickListener(this);
        videolist.setOnClickListener(this);
        logout.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            sharedPrefManager.saveIsLogin(false);
            finishAffinity();
            startActivity(i);
        });
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.addEbook:
                intent = new Intent(MainActivity.this, UploadEbookActivity.class);
                startActivity(intent);
                break;
            case R.id.addVideo:
                intent = new Intent(MainActivity.this, UploadVideoActivity.class);
                startActivity(intent);
                break;
            case R.id.ebook:
                intent = new Intent(MainActivity.this, EbookActivity.class);
                startActivity(intent);
                break;
            case R.id.videolibrary:
                intent = new Intent(MainActivity.this, VideoViewActivity.class);
                startActivity(intent);
                break;

        }

    }
}