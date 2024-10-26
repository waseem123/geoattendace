package com.infostack.geoattendance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.infostack.geoattendance.R;
import com.infostack.geoattendance.sessions.UserSessionManager;
import com.skyfishjy.library.RippleBackground;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DashboardActivity extends AppCompatActivity {
    TextView tv_datetime;
    LinearLayout ll_leavemanagement, ll_attendancereport, ll_salaryreport;
    private UserSessionManager session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Session class instance
        session = new UserSessionManager(getApplicationContext());

        // Check user login (this is the important point)
        // If User is not logged in , This will redirect user to LoginActivity
        // and finish current activity from activity stack.
//        if (session.checkLogin())
//            finish();
//
//        // get user data from session
//        HashMap<String, String> user = session.getUserDetails();
//
//        // get name
//        String name = user.get(UserSessionManager.KEY_NAME);
//        System.out.println("This is username : - " + name);


        final RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.content);
        rippleBackground.startRippleAnimation();

        tv_datetime = findViewById(R.id.tv_datetime);
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        tv_datetime.setText(dayOfTheWeek);

        ll_leavemanagement = findViewById(R.id.ll_leavemanagement);

        ll_leavemanagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, LeaveActivity.class);
                startActivity(intent);
            }
        });

        ll_attendancereport = findViewById(R.id.ll_attendancereport);
        ll_attendancereport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AttendanceReportActivity.class);
                startActivity(intent);
            }
        });
        ll_salaryreport = findViewById(R.id.ll_salaryreport);
        ll_salaryreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SalaryReportActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_feedback:
                Toast.makeText(DashboardActivity.this, "Feedback Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_about:
                Toast.makeText(DashboardActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logout:
                // Clear the User session data
                // and redirect user to LoginActivity
//                session.logoutUser();
                Toast.makeText(DashboardActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
