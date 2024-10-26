package com.infostack.geoattendance.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infostack.geoattendance.R;
import com.infostack.geoattendance.adapters.LeaveHistoryAdapter;
import com.infostack.geoattendance.models.LeaveHistory;

import java.util.ArrayList;
import java.util.List;

public class LeaveHistoryActivity extends AppCompatActivity {
    RecyclerView rv_leaveHistory;
    LeaveHistoryAdapter historyAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<LeaveHistory> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_history);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rv_leaveHistory = findViewById(R.id.rv_leavehistory);

        historyList.add(new LeaveHistory("02/04/2020 - 05/04/2020", getString(R.string.sample_type), getString(R.string.lorem), getString(R.string.leave_status)));
        historyList.add(new LeaveHistory("02/02/2020 - 05/02/2020", getString(R.string.sample_type), getString(R.string.lorem), getString(R.string.leave_approved)));
        historyList.add(new LeaveHistory("10/02/2020 - 15/02/2020", getString(R.string.sample_type), getString(R.string.lorem), getString(R.string.leave_rejected)));
        historyList.add(new LeaveHistory("20/02/2020 - 25/02/2020", getString(R.string.sample_type), getString(R.string.lorem), getString(R.string.leave_status)));
        historyList.add(new LeaveHistory("02/02/2020 - 05/02/2020", getString(R.string.sample_type), getString(R.string.lorem), getString(R.string.leave_approved)));

        historyAdapter = new LeaveHistoryAdapter(LeaveHistoryActivity.this, historyList);
        rv_leaveHistory.setAdapter(historyAdapter);
        layoutManager = new LinearLayoutManager(LeaveHistoryActivity.this, RecyclerView.VERTICAL, false);
        rv_leaveHistory.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_feedback:
                Toast.makeText(LeaveHistoryActivity.this, "Feedback Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_about:
                Toast.makeText(LeaveHistoryActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logout:
                Toast.makeText(LeaveHistoryActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
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
