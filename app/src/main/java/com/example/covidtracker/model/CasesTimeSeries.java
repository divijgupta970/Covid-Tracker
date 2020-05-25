package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CasesTimeSeries implements Parcelable {

    public final static Parcelable.Creator<CasesTimeSeries> CREATOR = new Creator<CasesTimeSeries>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CasesTimeSeries createFromParcel(Parcel in) {
            return new CasesTimeSeries(in);
        }

        public CasesTimeSeries[] newArray(int size) {
            return (new CasesTimeSeries[size]);
        }

    };
    @SerializedName("dailyconfirmed")
    @Expose
    private String dailyconfirmed;
    @SerializedName("dailydeceased")
    @Expose
    private String dailydeceased;
    @SerializedName("dailyrecovered")
    @Expose
    private String dailyrecovered;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("totalconfirmed")
    @Expose
    private String totalconfirmed;
    @SerializedName("totaldeceased")
    @Expose
    private String totaldeceased;
    @SerializedName("totalrecovered")
    @Expose
    private String totalrecovered;

    protected CasesTimeSeries(Parcel in) {
        this.dailyconfirmed = ((String) in.readValue((String.class.getClassLoader())));
        this.dailydeceased = ((String) in.readValue((String.class.getClassLoader())));
        this.dailyrecovered = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.totalconfirmed = ((String) in.readValue((String.class.getClassLoader())));
        this.totaldeceased = ((String) in.readValue((String.class.getClassLoader())));
        this.totalrecovered = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CasesTimeSeries() {
    }

    public String getDailyconfirmed() {
        return dailyconfirmed;
    }

    public void setDailyconfirmed(String dailyconfirmed) {
        this.dailyconfirmed = dailyconfirmed;
    }

    public String getDailydeceased() {
        return dailydeceased;
    }

    public void setDailydeceased(String dailydeceased) {
        this.dailydeceased = dailydeceased;
    }

    public String getDailyrecovered() {
        return dailyrecovered;
    }

    public void setDailyrecovered(String dailyrecovered) {
        this.dailyrecovered = dailyrecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalconfirmed() {
        return totalconfirmed;
    }

    public void setTotalconfirmed(String totalconfirmed) {
        this.totalconfirmed = totalconfirmed;
    }

    public String getTotaldeceased() {
        return totaldeceased;
    }

    public void setTotaldeceased(String totaldeceased) {
        this.totaldeceased = totaldeceased;
    }

    public String getTotalrecovered() {
        return totalrecovered;
    }

    public void setTotalrecovered(String totalrecovered) {
        this.totalrecovered = totalrecovered;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dailyconfirmed);
        dest.writeValue(dailydeceased);
        dest.writeValue(dailyrecovered);
        dest.writeValue(date);
        dest.writeValue(totalconfirmed);
        dest.writeValue(totaldeceased);
        dest.writeValue(totalrecovered);
    }

    public int describeContents() {
        return 0;
    }

}