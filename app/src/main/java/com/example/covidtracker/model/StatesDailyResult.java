package com.example.covidtracker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StatesDailyResult implements Parcelable {

    public final static Parcelable.Creator<StatesDailyResult> CREATOR = new Creator<StatesDailyResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StatesDailyResult createFromParcel(Parcel in) {
            return new StatesDailyResult(in);
        }

        public StatesDailyResult[] newArray(int size) {
            return (new StatesDailyResult[size]);
        }

    };
    @SerializedName("states_daily")
    @Expose
    private List<StatesDaily> statesDaily = new ArrayList<>();

    protected StatesDailyResult(Parcel in) {
        in.readList(this.statesDaily, (com.example.covidtracker.model.StatesDaily.class.getClassLoader()));
    }

    public StatesDailyResult() {
    }

    public List<StatesDaily> getStatesDaily() {
        return statesDaily;
    }

    public void setStatesDaily(List<StatesDaily> statesDaily) {
        this.statesDaily = statesDaily;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(statesDaily);
    }

    public int describeContents() {
        return 0;
    }

}
