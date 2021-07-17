package com.laily.newadmin_sosiofun.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.laily.newadmin_sosiofun.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView addEbook, addVideo, ebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addEbook = findViewById(R.id.addEbook);
        addVideo = findViewById(R.id.addVideo);
        ebook = findViewById(R.id.ebook);

        addEbook.setOnClickListener(this);
        addVideo.setOnClickListener(this);
        ebook.setOnClickListener(this);
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
                intent = new Intent(MainActivity.this, VideoViewActivity.class);
                startActivity(intent);
                break;
            case R.id.ebook:
                intent = new Intent(MainActivity.this, EbookActivity.class);
                startActivity(intent);
                break;
        }

    }
}