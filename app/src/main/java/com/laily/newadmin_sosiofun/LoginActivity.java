package com.laily.newadmin_sosiofun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.laily.newadmin_sosiofun.UI.BottomActivity;
import com.laily.newadmin_sosiofun.UI.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private SharedPrefManager sharedPrefManager;
    private EditText etUsername;
    private EditText etPassword;
    private TextView forgotpass;
    private Button btnLogin;
    private ProgressBar pbLogin;
    private ImageView ivLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        sharedPrefManager = new SharedPrefManager(this);
        etUsername = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        pbLogin = findViewById(R.id.progressBar);
        ivLogin = findViewById(R.id.ivLogin);
        forgotpass = findViewById(R.id.textView);
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Kirim Email", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"laily.hamidah@students.amikom.ac.id"});
//                intent.putExtra(Intent.EXTRA_CC, new String[] {"guntoroagun@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Lupa Password");
                intent.putExtra(Intent.EXTRA_TEXT, "Kirimkan Kembali Password dan Username Sosiofun");

                try {
                    startActivity(Intent.createChooser(intent, "Kirim Email?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    //do something else
                }
            }
        });

        login();
    }
    private void login() {
        btnLogin.setOnClickListener(v -> {
            final String username = etUsername.getText().toString();
            final String password = etPassword.getText().toString();

            pbLogin.setVisibility(View.VISIBLE);
            ivLogin.setVisibility(View.GONE);

            if (username.isEmpty() || password.isEmpty()){
                pbLogin.setVisibility(View.GONE);
                ivLogin.setVisibility(View.VISIBLE);
                Toast.makeText(LoginActivity.this, "Harap isi semua!", Toast.LENGTH_SHORT).show();
            }else{
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String spUsername = sharedPrefManager.getUsername();
                        String spPassword = sharedPrefManager.getPassword();

                        Log.d("username","user"+username);
                        Log.d("password","pass"+password);

                        if (username.equals(spUsername) && password.equals(spPassword)){
                            Intent i = new Intent(LoginActivity.this, BottomActivity.class);
                            Toast.makeText(LoginActivity.this, "Hai Admin!", Toast.LENGTH_SHORT).show();
                            sharedPrefManager.saveIsLogin(true);
                            finishAffinity();
                            startActivity(i);
                        }else {
                            pbLogin.setVisibility(View.GONE);
                            ivLogin.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, "Username dan password salah!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);
            }
        });
    }
}