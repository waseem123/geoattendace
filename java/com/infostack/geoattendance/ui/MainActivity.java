package com.infostack.geoattendance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.infostack.geoattendance.R;
import com.infostack.geoattendance.sessions.UserSessionManager;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll_direct, ll_login;
    private UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Session class instance
        session = new UserSessionManager(getApplicationContext());

        // Check user login (this is the important point)
        // If User is not logged in , This will redirect user to LoginActivity
        // and finish current activity from activity stack.

//        Toast.makeText(MainActivity.this, session.checkLogin() + "", Toast.LENGTH_SHORT).show();
//        if (session.checkLogin())
//            finish();


        ll_direct = findViewById(R.id.ll_direct);
        ll_login = findViewById(R.id.ll_login);

        ll_direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DirectAttendanceActivity.class);
                startActivity(intent);
            }
        });

        ll_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
