package com.laily.newadmin_sosiofun.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.laily.newadmin_sosiofun.LoginActivity;
import com.laily.newadmin_sosiofun.R;
import com.laily.newadmin_sosiofun.SharedPrefManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        final Handler handler = new Handler();

        final SharedPrefManager sharedPrefManager = new SharedPrefManager(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPrefManager.getIsLogin()){
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    finishAffinity();
                    startActivity(i);
                }else{
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    finishAffinity();
                    startActivity(i);
                }
            }
        }, 3000);

    }
}