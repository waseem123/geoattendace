package com.infostack.geoattendance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.infostack.geoattendance.R;

public class LoginActivity extends AppCompatActivity {
    Button btn_signin;
    TextInputLayout til_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        til_mobile = findViewById(R.id.til_mobile);
        btn_signin = findViewById(R.id.btn_signin);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobilenumber = til_mobile.getEditText().getText().toString();
                if (mobilenumber.isEmpty() || mobilenumber.length() != 10) {
                    til_mobile.setError("10 - digit mobile number is required");
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, MPinActivity.class);
                startActivity(intent);
            }
        });
    }
}
