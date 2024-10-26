package com.infostack.geoattendance.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.infostack.geoattendance.R;
import com.infostack.geoattendance.models.AttendanceReport;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {
    List<AttendanceReport> reports = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        
        reports.add(new AttendanceReport("25/02/2020", "12:10/19:00", "12:10/19:00", "12", "P", "17.6381281", "75.920123"));
        reports.add(new AttendanceReport("25/02/2020", "12:10/20:20", "12:10/20:20", "12", "PL"));
        reports.add(new AttendanceReport("25/02/2020", "12:10/19:00", "12:10/19:00", "12", "P", "17.6724044", "75.9102125"));
        reports.add(new AttendanceReport("25/02/2020", "12:10/18:00", "12:10/18:00", "12", "P", "17.6404026", "75.8737439"));
        reports.add(new AttendanceReport("25/02/2020", "12:10/20:00", "12:10/20:00", "12", "PL"));
        reports.add(new AttendanceReport("25/02/2020", "12:10/17:30", "12:10/17:30", "12", "P", "17.6365689", "75.9012644"));
        init();

    }

    private void init() {
        TableLayout ll = (TableLayout) findViewById(R.id.tbl_attendance);


        for (int i = 0; i < reports.size(); i++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            TextView tv_date = new TextView(AttendanceActivity.this);
            TextView tv_inout = new TextView(AttendanceActivity.this);
            TextView tv_punches = new TextView(AttendanceActivity.this);
            TextView tv_whrs = new TextView(AttendanceActivity.this);
            TextView tv_remark = new TextView(AttendanceActivity.this);
            TextView tv_map = new TextView(AttendanceActivity.this);

            tv_date.setTextSize(10);
            tv_inout.setTextSize(10);
            tv_punches.setTextSize(10);
            tv_whrs.setTextSize(10);
            tv_remark.setTextSize(10);
            tv_map.setTextSize(10);

            tv_date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_inout.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_punches.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_whrs.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_remark.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_map.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            tv_map.setTextColor(Color.parseColor("#0000FF"));

//            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                Typeface typeface = getResources().getFont(R.font.montserrat);
//                tv_date.setTypeface(typeface);
//                tv_inout.setTypeface(typeface);
//                tv_punches.setTypeface(typeface);
//                tv_whrs.setTypeface(typeface);
//                tv_remark.setTypeface(typeface);
//                tv_map.setTypeface(typeface);
//            }

            tv_date.setPadding(4, 4, 4, 4);
            tv_inout.setPadding(4, 4, 4, 4);
            tv_punches.setPadding(4, 4, 4, 4);
            tv_whrs.setPadding(4, 4, 4, 4);
            tv_remark.setPadding(4, 4, 4, 4);
            tv_map.setPadding(4, 4, 4, 4);
//            row.setBackground(getDrawable(R.drawable.tableborder));

            tv_date.setText(reports.get(i).getDate());
            tv_inout.setText(reports.get(i).getInouttime());

            tv_punches.setText(reports.get(i).getPunches());
            tv_whrs.setText(reports.get(i).getWorking_hrs());

            tv_remark.setText(reports.get(i).getRemark());

            if (reports.get(i).getLatitude() != null && reports.get(i).getLongitude() != null) {
                tv_map.setText("View");
                final int finalI = i;
                tv_map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AttendanceActivity.this, IndividualAttendanceActivity.class);
                        intent.putExtra("Date", reports.get(finalI).getDate());
                        intent.putExtra("INOUT", reports.get(finalI).getInouttime());
                        intent.putExtra("Punches", reports.get(finalI).getPunches());
                        intent.putExtra("Working", reports.get(finalI).getWorking_hrs());
                        intent.putExtra("Remark", reports.get(finalI).getRemark());
                        intent.putExtra("Latitude", reports.get(finalI).getLatitude());
                        intent.putExtra("Longitude", reports.get(finalI).getLongitude());
                        startActivity(intent);
                    }
                });
            }

            row.addView(tv_date);
            row.addView(tv_inout);
            row.addView(tv_punches);
            row.addView(tv_whrs);
            row.addView(tv_remark);
            row.addView(tv_map);

            ll.addView(row, i + 1);
        }
    }
}
