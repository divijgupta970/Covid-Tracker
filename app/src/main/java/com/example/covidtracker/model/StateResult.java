package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StateResult implements Parcelable {

    public final static Parcelable.Creator<StateResult> CREATOR = new Creator<StateResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StateResult createFromParcel(Parcel in) {
            return new StateResult(in);
        }

        public StateResult[] newArray(int size) {
            return (new StateResult[size]);
        }

    };
    @SerializedName("cases_time_series")
    @Expose
    private List<CasesTimeSeries> casesTimeSeries = new ArrayList<>();
    @SerializedName("statewise")
    @Expose
    private List<Statewise> statewise = new ArrayList<>();
    @SerializedName("tested")
    @Expose
    private List<Tested> tested = new ArrayList<>();

    protected StateResult(Parcel in) {
        in.readList(this.casesTimeSeries, (com.example.covidtracker.model.CasesTimeSeries.class.getClassLoader()));
        in.readList(this.statewise, (com.example.covidtracker.model.Statewise.class.getClassLoader()));
        in.readList(this.tested, (com.example.covidtracker.model.Tested.class.getClassLoader()));
    }

    public StateResult() {
    }

    public List<CasesTimeSeries> getCasesTimeSeries() {
        return casesTimeSeries;
    }

    public void setCasesTimeSeries(List<CasesTimeSeries> casesTimeSeries) {
        this.casesTimeSeries = casesTimeSeries;
    }

    public List<Statewise> getStatewise() {
        return statewise;
    }

    public void setStatewise(List<Statewise> statewise) {
        this.statewise = statewise;
    }

    public List<Tested> getTested() {
        return tested;
    }

    public void setTested(List<Tested> tested) {
        this.tested = tested;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(casesTimeSeries);
        dest.writeList(statewise);
        dest.writeList(tested);
    }

    public int describeContents() {
        return 0;
    }

}
