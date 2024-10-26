package com.infostack.geoattendance.ui;
/**
 * Created by Waseem Attar on 3/22/2020.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.infostack.geoattendance.R;

public class SampleActivity extends AppCompatActivity {

    private TextView tv_airplanestatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        tv_airplanestatus = findViewById(R.id.tv_airplanestatus);

        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                tv_airplanestatus.setText("Airplane mode service changed");

            }
        };

        Context context = SampleActivity.this;
        context.registerReceiver(receiver, intentFilter);

    }
}
