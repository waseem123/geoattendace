package com.infostack.geoattendance.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infostack.geoattendance.R;
import com.infostack.geoattendance.models.LeaveHistory;

import java.util.List;

public class LeaveHistoryAdapter extends RecyclerView.Adapter<LeaveHistoryAdapter.LeaveHistoryViewHolder> {
    private Context mContext;
    private List<LeaveHistory> historyList;

    public LeaveHistoryAdapter(Context mContext, List<LeaveHistory> historyList) {
        this.mContext = mContext;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public LeaveHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contect_leavehistory, parent, false);
        return new LeaveHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveHistoryViewHolder holder, int position) {
        holder.tv_leavedate.setText(historyList.get(position).getLeave_date());
        holder.tv_leavetype.setText(historyList.get(position).getLeave_type());
        holder.tv_leavereason.setText(historyList.get(position).getReason());

        String status = "Status : " + historyList.get(position).getStatus();
        holder.tv_leavestatus.setText(status);
        switch (status) {
            case "Status : Approved":
                holder.tv_leavestatus.setBackgroundColor(Color.parseColor("#00BCD4"));
                break;
            case "Status : Rejected":
                holder.tv_leavestatus.setBackgroundColor(Color.parseColor("#EF9A9A"));
                break;
            case "Status : Pending":
                holder.tv_leavestatus.setBackgroundColor(Color.parseColor("#FFF59D"));
                break;

        }
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class LeaveHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_leavedate, tv_leavetype, tv_leavereason, tv_leavestatus;

        public LeaveHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_leavedate = itemView.findViewById(R.id.tv_leavedate);
            tv_leavereason = itemView.findViewById(R.id.tv_leavereason);
            tv_leavetype = itemView.findViewById(R.id.tv_leavetype);
            tv_leavestatus = itemView.findViewById(R.id.tv_leavestatus);
        }
    }
}
