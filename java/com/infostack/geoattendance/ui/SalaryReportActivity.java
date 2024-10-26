package com.infostack.geoattendance.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.infostack.geoattendance.R;
import com.infostack.geoattendance.models.SalaryReport;

import java.util.ArrayList;
import java.util.List;

public class SalaryReportActivity extends AppCompatActivity {
    Spinner sp_salarymonth;
    TextView tv_perdaysalary;

    List<SalaryReport> reports = new ArrayList<>();

    String months[] = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_report);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sp_salarymonth = findViewById(R.id.sp_salarymonth);
        tv_perdaysalary = findViewById(R.id.tv_perdaysalary);

        sp_salarymonth.setAdapter(new ArrayAdapter(SalaryReportActivity.this, android.R.layout.simple_spinner_dropdown_item, months));

        reports.add(new SalaryReport("24/02/2020", "12", "7000", "18000"));
        reports.add(new SalaryReport("25/02/2020", "12", "5000", "20000"));
        reports.add(new SalaryReport("26/02/2020", "12", "2000", "23000"));
        reports.add(new SalaryReport("27/02/2020", "12", "0", "25000"));
        reports.add(new SalaryReport("28/02/2020", "12", "200", "24800"));
        reports.add(new SalaryReport("29/02/2020", "12", "2500", "22500"));
        init();


    }

    private void init() {
        TableLayout ll = (TableLayout) findViewById(R.id.tbl_salaryreport);


        for (int i = 0; i < reports.size(); i++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            TextView tv_date = new TextView(SalaryReportActivity.this);
            TextView tv_whrs = new TextView(SalaryReportActivity.this);
            TextView tv_deduction = new TextView(SalaryReportActivity.this);
            TextView tv_earnings = new TextView(SalaryReportActivity.this);

            tv_date.setTextSize(10);

            tv_whrs.setTextSize(10);
            tv_deduction.setTextSize(10);
            tv_earnings.setTextSize(10);

            tv_date.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_whrs.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_deduction.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv_earnings.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

//            tv_map.setTextColor(Color.parseColor("#0000FF"));

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

            tv_whrs.setPadding(4, 4, 4, 4);
            tv_deduction.setPadding(4, 4, 4, 4);
            tv_earnings.setPadding(4, 4, 4, 4);
//            row.setBackground(getDrawable(R.drawable.tableborder));

            tv_date.setText(reports.get(i).getDate());
            tv_whrs.setText(reports.get(i).getWorking_hrs());
            tv_deduction.setText(reports.get(i).getDeduction());
            tv_earnings.setText(reports.get(i).getEarnings());

//            if (reports.get(i).getLatitude() != null && reports.get(i).getLongitude() != null) {
//                tv_map.setText("View");
//                final int finalI = i;
//                tv_map.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(SalaryReportActivity.this, IndividualSalaryReportActivity.class);
//                        intent.putExtra("Date", reports.get(finalI).getDate());
//                        intent.putExtra("INOUT", reports.get(finalI).getInouttime());
//                        intent.putExtra("Punches", reports.get(finalI).getPunches());
//                        intent.putExtra("Working", reports.get(finalI).getWorking_hrs());
//                        intent.putExtra("Remark", reports.get(finalI).getRemark());
//                        intent.putExtra("Latitude", reports.get(finalI).getLatitude());
//                        intent.putExtra("Longitude", reports.get(finalI).getLongitude());
//                        startActivity(intent);
//                    }
//                });
//            }

            row.addView(tv_date);
            row.addView(tv_whrs);
            row.addView(tv_deduction);
            row.addView(tv_earnings);

            ll.addView(row, i + 1);
        }
    }
}
