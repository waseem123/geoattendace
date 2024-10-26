package com.infostack.geoattendance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.infostack.geoattendance.R;
import com.infostack.geoattendance.sessions.UserSessionManager;

public class MPinActivity extends AppCompatActivity {
    Button btn_verifyMPin;
    TextInputLayout til_mpin;
    private UserSessionManager session;
    private String user_id = "101", User_Name = "Alexandar Pierce", User_Mail = "alexandar@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpin);
        session = new UserSessionManager(getApplicationContext());

        til_mpin = findViewById(R.id.til_mpin);
        btn_verifyMPin = findViewById(R.id.btn_verifympin);

        btn_verifyMPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mPin = til_mpin.getEditText().getText().toString();
                if (mPin.isEmpty() || mPin.length() != 6) {
                    til_mpin.setError("6 - digit mPIN number is required");
                    return;
                }
                Intent intent = new Intent(MPinActivity.this, DashboardActivity.class);
                startActivity(intent);

//                session.createUserLoginSession(user_id, User_Name, User_Mail);
//                Toast.makeText(getApplicationContext(), R.string.login_successful, Toast.LENGTH_LONG).show();
//
//                Intent dashBoardActivity = new Intent(MPinActivity.this, DashboardActivity.class);
//                dashBoardActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//                dashBoardActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(dashBoardActivity);
//                finishAffinity();
            }
        });
    }
}
