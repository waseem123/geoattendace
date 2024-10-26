package com.infostack.geoattendance.models;

/**
 * Created by Waseem Attar on 3/29/2020.
 */
public class SalaryReport {
    String date;
    String working_hrs;
    String deduction;
    String earnings;

    public SalaryReport(String date, String working_hrs, String deduction, String earnings) {
        this.date = date;
        this.working_hrs = working_hrs;
        this.deduction = deduction;
        this.earnings = earnings;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWorking_hrs() {
        return working_hrs;
    }

    public void setWorking_hrs(String working_hrs) {
        this.working_hrs = working_hrs;
    }

    public String getDeduction() {
        return deduction;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public String getEarnings() {
        return earnings;
    }

    public void setEarnings(String earnings) {
        this.earnings = earnings;
    }
}
