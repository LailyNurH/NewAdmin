package com.laily.newadmin_sosiofun.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.laily.newadmin_sosiofun.LoginActivity;
import com.laily.newadmin_sosiofun.R;
import com.laily.newadmin_sosiofun.SharedPrefManager;
import com.laily.newadmin_sosiofun.UI.EbookActivity;
import com.laily.newadmin_sosiofun.UI.MainActivity;
import com.laily.newadmin_sosiofun.UI.UploadEbookActivity;
import com.laily.newadmin_sosiofun.UI.UploadVideoActivity;
import com.laily.newadmin_sosiofun.UI.VideoViewActivity;


public class HomeFragment extends Fragment implements View.OnClickListener {
    CardView addEbook, addVideo;
    ImageView videolist, ebook, logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        final SharedPrefManager sharedPrefManager = new SharedPrefManager(getContext());
        addEbook = view.findViewById(R.id.addEbook);
        addVideo = view.findViewById(R.id.addVideo);
        ebook = view.findViewById(R.id.ebook);
        logout = view.findViewById(R.id.logout);
        videolist = view.findViewById(R.id.videolibrary);

        addEbook.setOnClickListener(this);
        addVideo.setOnClickListener(this);
        ebook.setOnClickListener(this);
        videolist.setOnClickListener(this);
        logout.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), LoginActivity.class);
            sharedPrefManager.saveIsLogin(false);
            getActivity().finishAffinity();
            startActivity(i);
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.addEbook:
                intent = new Intent(getActivity(), UploadEbookActivity.class);
                startActivity(intent);
                break;
            case R.id.addVideo:
                intent = new Intent(getActivity(), UploadVideoActivity.class);
                startActivity(intent);
                break;
            case R.id.ebook:
                intent = new Intent(getActivity(), EbookActivity.class);
                startActivity(intent);
                break;
            case R.id.videolibrary:
                intent = new Intent(getActivity(), VideoViewActivity.class);
                startActivity(intent);
                break;

        }

    }
}