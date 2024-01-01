package com.beckytech.ogartiiwwankutaa7ffaa.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.beckytech.ogartiiwwankutaa7ffaa.MainActivity;
import com.beckytech.ogartiiwwankutaa7ffaa.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageView splashView = findViewById(R.id.splashscreen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
                @Override
                public void onDraw() {
                    splashView.setVisibility(View.GONE);
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            });
        }
        else {
            new Handler().postDelayed(() -> {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }, 1500);
        }
    }
}