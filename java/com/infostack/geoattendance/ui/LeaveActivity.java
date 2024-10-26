package com.infostack.geoattendance.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.infostack.geoattendance.R;
import com.infostack.geoattendance.models.LeaveHistory;

import java.util.Calendar;

public class LeaveActivity extends AppCompatActivity {
    Spinner sp_leavetype, sp_duration;
    Button btn_viewleavereport;

    String leavetype[] = {"Sick Leave", "Casual Leave"};
    String leaveduration[] = {"Full Day", "Half Day"};

    EditText ed_fromdate, ed_todate;
    private int mYear;
    private int mMonth;
    private int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn_viewleavereport = findViewById(R.id.btn_viewleavereport);
        sp_leavetype = findViewById(R.id.sp_leavetype);
        sp_duration = findViewById(R.id.sp_duration);

        ArrayAdapter leavetypeAdapter = new ArrayAdapter(LeaveActivity.this, android.R.layout.simple_spinner_dropdown_item, leavetype);
        sp_leavetype.setAdapter(leavetypeAdapter);

        ArrayAdapter durationAdapter = new ArrayAdapter(LeaveActivity.this, android.R.layout.simple_spinner_dropdown_item, leaveduration);
        sp_duration.setAdapter(durationAdapter);

        ed_fromdate = findViewById(R.id.ed_fromdate);
        ed_todate = findViewById(R.id.ed_todate);

        ed_fromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFromDatePicker();
            }
        });

        ed_todate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToDatePicker();
            }
        });

        btn_viewleavereport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LeaveActivity.this, LeaveHistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showToDatePicker() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(LeaveActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        ed_todate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void showFromDatePicker() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(LeaveActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        ed_fromdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_feedback:
                Toast.makeText(LeaveActivity.this, "Feedback Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_about:
                Toast.makeText(LeaveActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logout:
                Toast.makeText(LeaveActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
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
