package com.infostack.geoattendance.models;

public class LeaveHistory {
    String leave_date;
    String leave_type;
    String reason;
    String status;

    public LeaveHistory(String leave_date, String leave_type, String reason, String status) {
        this.leave_date = leave_date;
        this.leave_type = leave_type;
        this.reason = reason;
        this.status = status;
    }

    public String getLeave_date() {
        return leave_date;
    }

    public void setLeave_date(String leave_date) {
        this.leave_date = leave_date;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
