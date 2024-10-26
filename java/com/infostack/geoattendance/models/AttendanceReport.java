package com.infostack.geoattendance.models;

/**
 * Created by Waseem Attar on 3/28/2020.
 */
public class AttendanceReport {
    String date;
    String inouttime;
    String punches;
    String working_hrs;
    String remark;
    String latitude;
    String longitude;

    public AttendanceReport(String date, String inouttime, String punches, String working_hrs, String remark, String latitude, String longitude) {
        this.date = date;
        this.inouttime = inouttime;
        this.punches = punches;
        this.working_hrs = working_hrs;
        this.remark = remark;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AttendanceReport(String date, String inouttime, String punches, String working_hrs, String remark) {
        this.date = date;
        this.inouttime = inouttime;
        this.punches = punches;
        this.working_hrs = working_hrs;
        this.remark = remark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInouttime() {
        return inouttime;
    }

    public void setInouttime(String inouttime) {
        this.inouttime = inouttime;
    }

    public String getPunches() {
        return punches;
    }

    public void setPunches(String punches) {
        this.punches = punches;
    }

    public String getWorking_hrs() {
        return working_hrs;
    }

    public void setWorking_hrs(String working_hrs) {
        this.working_hrs = working_hrs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
