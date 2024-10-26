package com.infostack.geoattendance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.infostack.geoattendance.R;

public class SplashActivity extends AppCompatActivity {
    Animation animation_top, animation_bottom;

    ImageView iv_logo;
    TextView tv_logo;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        animation_top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        animation_bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        iv_logo = findViewById(R.id.iv_logo);
        tv_logo = findViewById(R.id.tv_logo);
        relativeLayout = findViewById(R.id.fl_footer);

        iv_logo.setAnimation(animation_top);
        tv_logo.setAnimation(animation_bottom);
        relativeLayout.setAnimation(animation_bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

    }
}
